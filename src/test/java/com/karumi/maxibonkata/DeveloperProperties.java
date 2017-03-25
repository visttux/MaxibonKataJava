package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {
    private static final String ANY_NAME = "Pedro";

    @Property
    public void theNumberOfMaxibonsShouldBeGreaterThanZero(int numberOfMaxibons) {
        Developer developer = new Developer(ANY_NAME, numberOfMaxibons);

        int numberOfMaxibonsToGrab = developer.getNumberOfMaxibonsToGrab();

        assertTrue(numberOfMaxibonsToGrab >= 0);
    }

    @Test
    public void ifDeveloperIsPedroShouldGrab3Maxibons() {
        Developer pedro = Karumies.PEDRO;
        Developer alberto = Karumies.ALBERTO;
        Developer davide = Karumies.DAVIDE;
        Developer jorge = Karumies.JORGE;
        Developer sergio = Karumies.SERGIO;

        assertTrue(pedro.getNumberOfMaxibonsToGrab() == 3);
        assertTrue(alberto.getNumberOfMaxibonsToGrab() == 1);
        assertTrue(davide.getNumberOfMaxibonsToGrab() == 0);
        assertTrue(jorge.getNumberOfMaxibonsToGrab() == 1);
        assertTrue(sergio.getNumberOfMaxibonsToGrab() == 2);
    }
}
