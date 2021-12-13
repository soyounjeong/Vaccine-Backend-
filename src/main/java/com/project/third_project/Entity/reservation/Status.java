package com.project.third_project.Entity.reservation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    READY("STATUS_READY", "준비"),
    OK("STATUS_OK", "완료");

    private final String key;
    private final String title;

}
