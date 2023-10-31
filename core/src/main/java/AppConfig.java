import com.example.discount.DiscountPolicy;
import com.example.discount.FixDiscountPolicy;
import com.example.discount.RateDiscountPolicy;
import com.example.member.MemberRepository;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.member.MemoryMemberRepository;
import com.example.order.OrderService;
import com.example.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

}
