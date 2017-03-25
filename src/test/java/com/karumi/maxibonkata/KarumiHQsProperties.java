package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {
    private KarumiHQs hq;
    private Chat chat;

    @Before
    public void setup() {
        chat = mock(Chat.class);
        hq = new KarumiHQs(chat);
    }

    @Property
    public void numberOfMaxibonsShouldBeGreaterThanTwo(
            @From(DevelopersGenerator.class) Developer developer) {
        hq.openFridge(developer);

        int maxibonsLeft = hq.getMaxibonsLeft();

        assertTrue(maxibonsLeft >= 2);
    }

    @Property
    public void numberOfMaxibonsShouldBeGreaterThanTwoWhenNotSoHungry(
            @From(NotSoHungryDevelopersGenerator.class) Developer developer) {
        hq.openFridge(developer);

        int maxibonsLeft = hq.getMaxibonsLeft();

        assertTrue(maxibonsLeft >= 2);
    }

    @Property
    public void numberOfMaxibonsShouldBeGreaterThanTwoWhenDevelopersGoInGroup(
            List<@From(KarumiesGenerator.class) Developer> developers ) {
        hq.openFridge(developers);

        int maxibonsLeft = hq.getMaxibonsLeft();

        assertTrue(maxibonsLeft >= 2);
    }

    @Property
    public void messageToBuyMoreIsSendWhenMaxibonsUnderTwoOnFridgeOpened(
            @From (HungryDevelopersGenerator.class) Developer developer) {
        hq.openFridge(developer);

        String expectedResult = "Hi guys, I'm " + developer.getName() + ". We need more maxibons!";
        verify(chat).sendMessage(expectedResult);
    }

    @Property
    public void messageToBuyMoreIsNotSendWhenMaxibonsNotUnderTwoOnFridgeOpened(
            @From (NotSoHungryDevelopersGenerator.class) Developer developer) {
        hq.openFridge(developer);

        String expectedResult = "Hi guys, I'm " + developer.getName() + ". We need more maxibons!";
        verify(chat, never()).sendMessage(expectedResult);
    }


}
