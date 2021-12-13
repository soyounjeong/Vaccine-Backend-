package com.project.third_project.Entity.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Vaccination {

    Y("VACCINATION_Y", "네"),
    N("VACCINATION_N", "아니요");

    private final String key;
    private final String title;
}
