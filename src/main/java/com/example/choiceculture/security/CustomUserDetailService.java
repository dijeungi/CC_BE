package com.example.choiceculture.security;

import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername: username: {}", username);

        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Check Email or Social"));


        MemberDTO memberDTO = new MemberDTO(
                member.getEmail(),
                member.getUserPassword(),
                member.getUserName(),
                member.getMemberRoleList().stream().map(Enum::name).toList());

        log.info("memberDTO: {}", memberDTO);

        return memberDTO;
    }
}
