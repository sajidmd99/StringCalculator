package com.sajid;

public class IncubyteStringCalculator {
    public static int add(String numbers) {
        //for empty string
        if(numbers.isEmpty())
            return 0;
        // for multiple numbers
        String[] arrOfNumbers = numbers.split(",");
        int sum = 0;
        for(String num: arrOfNumbers) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
