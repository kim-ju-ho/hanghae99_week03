package com.example.milestone01.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity

public class Bbs extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO) // id 자동생성
    @Id // PK를 나타낸다.
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String contents;


    public Bbs(String title,String contents, String writer){
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public Bbs(BbsRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.writer = requestDto.getWriter();
    }
    //update
    public void update(BbsRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

}
