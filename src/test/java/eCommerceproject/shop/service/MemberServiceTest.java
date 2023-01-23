package eCommerceproject.shop.service;

import eCommerceproject.shop.domain.Member;
import eCommerceproject.shop.dto.MemberFormDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setName("김현수");
        memberFormDto.setEmail("haensuya@gmail.com");
        memberFormDto.setPassword("1234");
        memberFormDto.setAddress("서울시 마포구 1-1");

        return Member.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        Assertions.assertThat(member).isEqualTo(savedMember);
    }

    @Test
    @DisplayName("이메일 중복 회원 검사")
    public void saveDuplicateMemberTest() {
        Member member1 = createMember();
        memberService.saveMember(member1);

        Member member2 = createMember();

        //Junit5 예외 테스트
        assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);
        });

    }

}
