package utils;

public class StringUtility {



        public static void verifyEquals(String expected, String actual){
            if (expected.equalsIgnoreCase(actual)) {
                System.out.println("Test is passed");
            } else {
                System.out.println("Test is failed");
                System.out.println("Expected result is: " + expected + " but Actual result is: " + actual);
            }
        }

    }

