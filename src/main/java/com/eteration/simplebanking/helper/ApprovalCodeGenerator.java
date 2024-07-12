package com.eteration.simplebanking.helper;

import java.util.Random;

public class ApprovalCodeGenerator {

    private static final String UPPER_CASE_LETTERS_DIGITS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final char DASH = '-';
    private static final int CODE_LENGTH = 36;

    public static String generateRandomApprovalCode() {
        StringBuilder approvalCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < CODE_LENGTH; i++) {
            char currentChar;
            if (i == 8 || i == 13 || i == 18 || i == 23) {
                currentChar = DASH;
            } else {
                int randomIndex = random.nextInt(UPPER_CASE_LETTERS_DIGITS.length());
                currentChar = UPPER_CASE_LETTERS_DIGITS.charAt(randomIndex);
            }
            approvalCode.append(currentChar);
        }

        return approvalCode.toString();
    }

}
