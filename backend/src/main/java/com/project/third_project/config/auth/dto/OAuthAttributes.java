package com.project.third_project.config.auth.dto;

import com.project.third_project.entity.users.Gender;
import com.project.third_project.entity.users.Role;
import com.project.third_project.entity.users.Users;
import com.project.third_project.entity.users.Vaccination;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String pw;
    private Gender gender;
    private int age;
    private String address;
    private String addressDetail;
    private String hp;
    private Vaccination first;
    private Vaccination second;
    private Role role;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String pw, Gender gender, int age, String address, String addressDetail, String hp, Vaccination first, Vaccination second, Role role) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.pw = pw;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.addressDetail = addressDetail;
        this.hp = hp;
        this.first = first;
        this.second = second;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }
    // OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해야만 합니다.

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .pw((String) attributes.get("pw"))
                .hp((String) attributes.get("hp"))
                .gender((Gender) attributes.get("gender"))
                .age((int) attributes.get("age"))
                .address((String) attributes.get("address"))
                .addressDetail((String) attributes.get("addressDetail"))
                .first((Vaccination) attributes.get("first"))
                .second((Vaccination) attributes.get("second"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static  OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
    public Users toEntity() {
        return Users.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();
    }
}
