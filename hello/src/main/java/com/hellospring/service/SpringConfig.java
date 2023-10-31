package com.hellospring.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hellospring.aop.TimeTraceAop;
import com.hellospring.repository.JdbcMemberRepository;
import com.hellospring.repository.JpaMemberRepository;
import com.hellospring.repository.MemberRepository;
import com.hellospring.repository.MemoryMemberRepository;

import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {


	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	

	//@Bean
	//public MemberRepository memberReopsitory() {
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JpaMemberRepository(em);
	//}
}
