package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {
    private KarumiHQs hq;

    @Before
    public void setup() {
        Chat chat = mock(Chat.class);
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
            List<@From(NotSoHungryDevelopersGenerator.class) Developer> developers ) {
        hq.openFridge(developers);

        int maxibonsLeft = hq.getMaxibonsLeft();

        assertTrue(maxibonsLeft >= 2);
    }
}
