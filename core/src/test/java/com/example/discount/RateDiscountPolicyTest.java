package com.example.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.member.Grade;
import com.example.member.Member;

public class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다")
	public void testDiscount() {
		//given
		Member member = new Member(1L,"memberVip",Grade.VIP);
		//when
		int discount = discountPolicy.discount(member,10000);
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
		
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
	public void testDiscount_x() {
		//given
		Member member = new Member(1L,"memberBasic",Grade.BASIC);
		//when
		int discount = discountPolicy.discount(member,10000);
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
		
	}
}
