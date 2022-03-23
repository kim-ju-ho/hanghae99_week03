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

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("bbsList",bbsRepository.findAllByOrderByCreatedAtDesc());
        return "home";
    }
    @GetMapping("/writeBbs")
    public String writeBbs(Model model, BbsRequestDto requestDto){
        model.addAttribute("requestDto",requestDto);
        return "writeBbs";
    }


    @PostMapping("/api/bbs/write")
    public String createBbs(@ModelAttribute("requestDto") BbsRequestDto requestDto){
       Bbs bbs = new Bbs(requestDto);
       bbsRepository.save(bbs);
       return "redirect:/";
    }

    @GetMapping("/api/bbs/{id}")
    public String detailBbs(@PathVariable Long id,Model model){
        Bbs bbs =bbsRepository.findById(id).get();
        model.addAttribute("bbsOne",bbs);
        return "detailBbs";
    }
}