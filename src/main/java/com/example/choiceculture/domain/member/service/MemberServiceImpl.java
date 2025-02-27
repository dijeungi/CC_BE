package com.example.choiceculture.domain.member.service;


//import com.example.choiceculture.domain.heart.service.HeartService;

import com.example.choiceculture.domain.member.dto.JoinRequestDTO;
import com.example.choiceculture.domain.member.dto.MemberRequestDTO;
import com.example.choiceculture.domain.member.dto.MemberTestDTO;
import com.example.choiceculture.domain.member.dto.PasswordRequestDTO;
import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.domain.member.enums.UserEmailAlarm;
import com.example.choiceculture.domain.member.repository.MemberRepository;
import com.example.choiceculture.props.JwtProps;
import com.example.choiceculture.security.MemberDTO;
import com.example.choiceculture.util.JWTUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final JWTUtil jwtUtil;
    private final JwtProps jwtProps;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public MemberTestDTO findUser(String email) {
        Member member = this.getMember(email);
        return this.entityToDto(member);
    }

    @Override
    public void join(JoinRequestDTO request) {
        memberRepository.findById(request.getId())
                .ifPresent(member -> {
                    throw new IllegalArgumentException("이미 존재하는 회원입니다!");
                });

        Member member = Member.builder()
                .id(request.getId())
                .email(request.getEmail())
                .userName(request.getName())
                .userPassword(passwordEncoder.encode(request.getPassword()))
                .userPhone(request.getPhone())
                .userEmailAlarm(UserEmailAlarm.valueOf(request.getMailYn()))
                .build();

        member.addRole(request.getRole()); // 회원가입시, USER 권한을 부여

        memberRepository.save(member);
    }


    @Override
    public Map<String, Object> login(String id, String password) {
        Member member = getMember(id);

        if (!passwordEncoder.matches(password, member.getUserPassword())) {
            throw new IllegalArgumentException("password not found");
        }

        MemberDTO memberDTO = new MemberDTO(member.getId(), member.getEmail(), member.getUserPassword(), member.getUserName(),
                member.getMemberRoleList().stream().map(Enum::name).toList());

        log.info("memberService login memberDTO: {}", memberDTO);

        Map<String, Object> claims = memberDTO.getClaims();

        String accessToken = jwtUtil.generateToken(claims, jwtProps.getAccessTokenExpirationPeriod());
        String refreshToken = jwtUtil.generateToken(claims, jwtProps.getRefreshTokenExpirationPeriod());

        claims.put("accessToken", accessToken);
        claims.put("refreshToken", refreshToken);

        return claims;
    }

    @Override
    public void changePassword(PasswordRequestDTO requestDTO) {
        Member member = memberRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        if (passwordEncoder.matches(requestDTO.getBeforePassword(), member.getUserPassword())) {
            throw new IllegalArgumentException("이전에 사용했던 비밀번호입니다.");
        }

        member.setUserPassword(passwordEncoder.encode(requestDTO.getPassword()));
        memberRepository.save(member);

    }

    @Override
    public void update(MemberRequestDTO requestDTO) {
        Member member = memberRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        member.setUserName(Objects.requireNonNullElse(requestDTO.getUserName(), member.getUserName()));
        member.setUserPhone(Objects.requireNonNullElse(requestDTO.getUserPhone(), member.getUserPhone()));
        member.setEmail(Objects.requireNonNullElse(requestDTO.getEmail(), member.getEmail()));
        member.setUserBirth(Objects.requireNonNullElse(requestDTO.getUserBirth(), member.getUserBirth()));
        member.setUserEmailAlarm(Objects.requireNonNullElse(requestDTO.getEmailAlarm(), member.getUserEmailAlarm()));
        member.setUserFavorite1(Objects.requireNonNullElse(requestDTO.getUserFavorite1(), member.getUserFavorite1()));
        member.setUserFavorite2(Objects.requireNonNullElse(requestDTO.getUserFavorite2(), member.getUserFavorite2()));
        member.setUserFavorite3(Objects.requireNonNullElse(requestDTO.getUserFavorite3(), member.getUserFavorite3()));
        member.setUpDate(LocalDateTime.now());

        memberRepository.save(member);
    }

    @Override
    public void delete(String userId) {
        memberRepository.deleteById(userId);
    }


    @Override
    public String makeTempPassword() {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < 10; i++) {
            buffer.append((char) ((int) (Math.random() * 55) + 65));
        }
        return buffer.toString();
    }

    /**
     * Social Login 성공시 JWT 토큰 발급
     *
     * @param memberDTO Social Login 성공한 회원 정보
     * @return JWT 토큰 정보가 같이 있는 유저정보 Map
     */

    @Override
    @NotNull
    public Map<String, Object> getSocialClaims(MemberDTO memberDTO) {
        Map<String, Object> claims = memberDTO.getClaims();
        String jwtAccessToken = jwtUtil.generateToken(claims, jwtProps.getAccessTokenExpirationPeriod());      // 15분
        String jwtRefreshToken = jwtUtil.generateToken(claims, jwtProps.getRefreshTokenExpirationPeriod());     // 1일

        claims.put("accessToken", jwtAccessToken);
        claims.put("refreshToken", jwtRefreshToken);
        return claims;
    }


    /**
     * email로 회원을 찾는다.
     *
     * @param id 이메일
     * @return 회원
     */
    @Transactional(readOnly = true)
    @Override
    public Member getMember(String id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다."));
    }


    @Transactional(readOnly = true)
    public Member getMemberByPhoneNumber(String phoneNumber) {
        return memberRepository.findByUserPhone(phoneNumber)
                .orElseThrow(() -> new EntityNotFoundException("해당 전화번호로 가입된 사용자가 없습니다."));
    }

    @Transactional(readOnly = true)
    @Override
    public Member getMemberById(String id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID로 가입된 사용자가 없습니다."));
    }

}
