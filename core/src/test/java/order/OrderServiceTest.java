package order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.member.Grade;
import com.example.member.Member;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.order.Order;
import com.example.order.OrderService;
import com.example.order.OrderServiceImpl;

public class OrderServiceTest {
	
	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA",Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId,"itemA" ,18000);
		
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}

}
