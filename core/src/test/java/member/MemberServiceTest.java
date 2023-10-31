package member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.member.Grade;
import com.example.member.Member;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;

public class MemberServiceTest {

	MemberService memberService = new MemberServiceImpl();
	
	@Test
	void join() {
		//given
		Member member = new Member(1L,"memberA",Grade.VIP);
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}
}
