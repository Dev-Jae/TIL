package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)    // JUnit에 내장된 SpringRunner를 사용할 것을 명시
@SpringBootTest                 // 스프링부트를 띄운 상태로 테스트를 진행할 것을 명시
@Transactional                  // 테스트 케이스에 이 어노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트가 끝나면 롤백을 한다.
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {

        // given
        Member member = new Member();
        member.setName("chu");

        // when
        Long saveId = memberService.join(member);

        // then
        //em.flush(); // 이렇게 하면 DB에 반영이 됨.
        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {

        // given
        Member member1 = new Member();
        member1.setName("chu");

        Member member2 = new Member();
        member2.setName("chu");

        // when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 한다!!!

        // then
        fail("예외가 발생해야 한다.");
    }

}