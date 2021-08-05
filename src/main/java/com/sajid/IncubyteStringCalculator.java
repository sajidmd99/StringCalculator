package com.sajid;

public class IncubyteStringCalculator {
    public static int add(String numbers) {
        // for empty string
        if(numbers.length() == 0)
            return 0;

            //for one number
        else if(numbers.length() == 1)
            return Integer.parseInt(numbers);

        //for two numbers

        int n1 = Integer.parseInt(numbers.charAt(0)+"");
        int n2 = Integer.parseInt(numbers.charAt(2)+"");
        return n1 + n2;
    }
}
