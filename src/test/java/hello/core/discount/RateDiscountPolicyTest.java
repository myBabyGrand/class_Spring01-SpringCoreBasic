package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP 등급은 10% 정률 할인을 적용한다.")
    void discount_VIP() {
        //given
        Member member = new Member(1L, "VIPMember", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member , 10000);
        //then
        Assertions.assertEquals(discount, 1000);
    }
    @Test
    @DisplayName("BASIC 등급은 할인이 없다.")
    void discount_BASIC() {
        //given
        Member member = new Member(1L, "BASICMember", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member , 10000);
        //then
        Assertions.assertEquals(discount, 0);
    }
}