package com.sajid;

import java.util.ArrayList;
import java.util.List;

public class IncubyteStringCalculator {
    public static int add(String numbers) throws Exception {
        //for empty string
        if(numbers.isEmpty()) return 0;

        // getting array of number as Integer
        int[] arrOfNumbers = getArrayOfNumbers(numbers);
        int sum = sumOfArray(arrOfNumbers);

        return sum;
    }

    public static int[] getArrayOfNumbers(String numbers) {
        String[] arrOfStr;
        if(numbers.startsWith("//")) {
            arrOfStr = splitByCustomDelimeter(numbers);
        }
        else {
            arrOfStr = splitByLinesAndCommas(numbers);
        }

        int[] arrOfNumbers = new int[arrOfStr.length];
        for(int i=0; i<arrOfStr.length; i++) {
            arrOfNumbers[i] = Integer.parseInt(arrOfStr[i]);
        }

        return arrOfNumbers;
    }

    public static String[] splitByLinesAndCommas(String numbers) {
        return numbers.split(",|\n");
    }

    public static String[] splitByCustomDelimeter(String numbers) {
        String delimeter = "" + numbers.charAt(2);
        String[] numArray = numbers.split("\n");

        return numArray[1].split(delimeter);
    }

    public static int sumOfArray(int[] arr) throws Exception {
        isContainNegative(arr);

        int sum = 0;
        for(int num: arr) {
            if(num > 1000) continue;
            sum += num;
        }

        return sum;
    }

    public static void isContainNegative(int[] arr) throws Exception {
        List<Integer> negatives = new ArrayList<>();
        for(int num: arr) {
            if(num < 0) negatives.add(num);
        }

        if(negatives.size() > 0) {
            String message = "";
            for(int num: negatives) {
                message += num + "  ";
            }
            throw new Exception("negatives not allowed: " + message.trim());
        }
    }
}
