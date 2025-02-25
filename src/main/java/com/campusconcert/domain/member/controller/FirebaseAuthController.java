package com.campusconcert.domain.member.controller;

import com.campusconcert.domain.member.service.FirebaseAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/firebase/auth")
public class FirebaseAuthController {

    private final FirebaseAuthService firebaseAuthService;

    public FirebaseAuthController(FirebaseAuthService firebaseAuthService) {
        this.firebaseAuthService = firebaseAuthService;
    }

    @PostMapping("/verify-token")
    public ResponseEntity<String> verifyIdToken(@RequestBody Map<String, String> request) {
        String idToken = request.get("token"); // 🔹 JSON에서 "token" 키로 ID 토큰 추출
        if (idToken == null) {
            return ResponseEntity.badRequest().body("ID 토큰이 없습니다.");
        }

        String uid = firebaseAuthService.verifyIdToken(idToken);
        return ResponseEntity.ok("인증 성공! UID: " + uid);
    }
}

