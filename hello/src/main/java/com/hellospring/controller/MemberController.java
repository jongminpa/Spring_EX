package com.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hellospring.domain.Member;
import com.hellospring.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberservice;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberservice = memberService;
	}
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberservice.join(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberservice.findMembers();
		model.addAttribute("members",members);
		return "members/memberList";	
	}
}
	

