package com.eteration.simplebanking.helper;

public class MockIdDataGenerator {

    private static long nextId = 1;

    public static synchronized long generateUniqueId() {
        return nextId++;
    }
}
