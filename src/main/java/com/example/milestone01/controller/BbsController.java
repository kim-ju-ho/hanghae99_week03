package com.example.milestone01.controller;

import com.example.milestone01.domain.Bbs;
import com.example.milestone01.domain.BbsRepository;
import com.example.milestone01.domain.BbsRequestDto;
import com.example.milestone01.service.BbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Controller
public class BbsController {

    private final BbsRepository bbsRepository;
    private final BbsService bbsService;

    // 메인페이지
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("bbsList",bbsRepository.findAllByOrderByCreatedAtDesc());
        return "home";
    }
    // 등록 페이지로 이동
    @GetMapping("/writeBbs")
    public String writeBbs(Model model, BbsRequestDto requestDto){
        model.addAttribute("requestDto",requestDto);
        return "writeBbs";
    }
    // 업데이트 페이지로 이동
    @GetMapping("/api/bbs/update/{id}")
    public String updateBbs(@PathVariable Long id,Model model,BbsRequestDto requestDto){
        Bbs bbsOne =bbsRepository.findById(id).get();
        model.addAttribute("bbsOne",bbsOne);
        return "update";
    }
    // 상세페이지로 이동
    @GetMapping("/api/bbs/{id}")
    public String detailBbs(@PathVariable Long id,Model model){
        Bbs bbs =bbsRepository.findById(id).get();
        model.addAttribute("bbsOne",bbs);
        return "detailBbs";
    }
    // 게시물 등록
    @PostMapping("/api/bbs/write")
    public String createBbs(@ModelAttribute("requestDto") BbsRequestDto requestDto){
       Bbs bbs = new Bbs(requestDto);
       bbsRepository.save(bbs);
       return "redirect:/";
    }

    // 게시물 삭제
    @DeleteMapping("/api/bbs/{id}")
    public @ResponseBody String deleteBbs(@PathVariable Long id){
        bbsRepository.deleteById(id);
        return "success";
    }
    // 게시물 업데이트
    @PostMapping("/api/bbs/update/{id}")
    public String updateOneBbs(@PathVariable Long id,@ModelAttribute BbsRequestDto requestDto){
        System.out.println(id);
        System.out.println(requestDto.getTitle());
        bbsService.update(id,requestDto);
        return "redirect:/";
    }


}