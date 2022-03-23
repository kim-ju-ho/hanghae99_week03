package com.example.milestone01.service;

import com.example.milestone01.domain.Bbs;
import com.example.milestone01.domain.BbsRepository;
import com.example.milestone01.domain.BbsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BbsService {
    private final BbsRepository bbsRepository;

    public Long update(Long id, BbsRequestDto requestDto) {
        Bbs bbs = bbsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        bbs.update(requestDto);
        return id;
    }

}