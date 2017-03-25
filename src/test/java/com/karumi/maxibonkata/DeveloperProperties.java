package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {
    private static final String ANY_NAME = "Pedro";


    @Property
    public void theNumberOfMaxibonsShouldBeGreaterThanZero(int numberOfMaxibons) {
        Developer developer = new Developer(ANY_NAME, numberOfMaxibons);

        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }
}
