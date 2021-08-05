package com.sajid;

public class IncubyteStringCalculator {
    public static int add(String numbers) {
        //for empty string
        if(numbers.isEmpty())
            return 0;
        // for multiple numbers with commas and new lines
        String[] arrOfNumbers = numbers.split(",|\n");
        int sum = 0;
        for(String num: arrOfNumbers) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
