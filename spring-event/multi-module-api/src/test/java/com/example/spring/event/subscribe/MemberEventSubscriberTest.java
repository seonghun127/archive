package com.example.spring.event.subscribe;

import com.example.spring.event.MemberEvent;
import com.example.spring.event.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = MemberEventSubscriber.class)
@RunWith(SpringRunner.class)
public class MemberEventSubscriberTest {

    @MockBean
    private MemberEventSubscriber memberEventSubscriber;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Captor
    private ArgumentCaptor<MemberEvent> argumentCaptor;

    @Test
    public void 이벤트_발행_시_제대로_구독하는지_테스트() {
        // 1. Given
        Member member = Member.builder()
                .count(100)
                .build();
        MemberEvent event = MemberEvent.builder()
                .member(member)
                .build();

        // 2. When
        applicationEventPublisher.publishEvent(event);

        // 3. Then
        verify(memberEventSubscriber, times(1)).processEvent(argumentCaptor.capture());
        MemberEvent publishedEvent = argumentCaptor.getValue();
        assertThat(publishedEvent).isEqualTo(event);
    }

    @Test
    public void 이벤트_조건이_부합하지않은경우_이벤트_처리하지_않는지_테스트() {
        // 1. Given
        int notConditionCount = 99;
        Member member = Member.builder()
                .count(notConditionCount)
                .build();
        MemberEvent event = MemberEvent.builder()
                .member(member)
                .build();

        // 2. When
        applicationEventPublisher.publishEvent(event);

        // 3. Then
        verify(memberEventSubscriber, times(0)).processEvent(argumentCaptor.capture());
    }
}