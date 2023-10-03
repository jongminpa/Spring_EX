package com.example.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //model 클래스 패키지 자동 임포트
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstCOntroller {
    @GetMapping("/hi")
    public String noceToMeetYou(Model model){//모델객체 받아오기
        model.addAttribute("username","JongMin");
        return "greetings";
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","박종민");
        return "goodbye";
    }
}
