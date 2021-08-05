package com.sajid;

public class IncubyteStringCalculator {
    public static int add(String numbers) {
        //for empty string
        if(numbers.isEmpty()) return 0;

        // for custom delimeter
        String[] arrOfNumbers;
        if(numbers.startsWith("//")) {
            arrOfNumbers = splitByCustomDelimeter(numbers);
        }
        else {
            arrOfNumbers = splitByLinesAndCommas(numbers);
        }
        int sum = 0;
        for(String num: arrOfNumbers) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }

    public static String[] splitByLinesAndCommas(String numbers) {
        return numbers.split(",|\n");
    }

    public static String[] splitByCustomDelimeter(String numbers) {
        String delimeter = "" + numbers.charAt(2);
        String[] numArray = numbers.split("\n");

        return numArray[1].split(delimeter);
    }
}
