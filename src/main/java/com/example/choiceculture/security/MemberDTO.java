package com.example.choiceculture.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class MemberDTO extends User {
    private String id;
    private String email;
    private String password;
    private String name;
    private List<String> roleNames = new ArrayList<>();


    public MemberDTO(String id,String email, String password, String name, List<String> roleNames) {
        // ROLE_ 접두사를 붙여서 권한을 부여
        super(id, password, roleNames.stream().map(str -> new SimpleGrantedAuthority("ROLE_" + str)).collect(Collectors.toList()));
        this.id = id;
//        this.email = email;
        this.password = password;
        this.name = name;
        this.roleNames = roleNames;
    }

    public Map<String, Object> getClaims() {

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", this.id);
        dataMap.put("email", this.email);
        dataMap.put("password", this.password);
        dataMap.put("name", this.name);
        dataMap.put("roleNames", this.roleNames);

        return dataMap;
    }

}
