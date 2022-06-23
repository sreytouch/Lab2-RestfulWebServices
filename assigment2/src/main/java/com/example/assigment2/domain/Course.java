package com.miu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    private Long id;

    private String name;

    private String code;

    private boolean deleted;

    public Course(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
