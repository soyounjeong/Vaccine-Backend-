package com.project.third_project.Entity.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MAN("GENDER_MEN", "남"),
    WOMAN("GENDER_WOMAN", "여");

    private final String key;
    private final String title;
}
