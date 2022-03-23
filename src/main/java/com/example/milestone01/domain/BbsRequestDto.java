package com.example.milestone01.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BbsRequestDto {
    private String title;
    private String contents;
    private String writer;
}

