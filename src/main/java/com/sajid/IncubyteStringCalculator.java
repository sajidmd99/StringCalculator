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
        if(numbers.startsWith("//[") && numbers.charAt(4) == ']') {
            arrOfStr = splitByMultipleDelimiter(numbers);
        }

        else if(numbers.startsWith("//[")) {         // string with multiple size delimiter
            arrOfStr = splitByAnyLengthDelimiter(numbers);
        }
        else if(numbers.startsWith("//")) {     // string with custom delimiter
            arrOfStr = splitByCustomDelimiter(numbers);
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

    public static String[] splitByCustomDelimiter(String numbers) {
        String delimeter = "" + numbers.charAt(2);
        String[] numArray = numbers.split("\n");

        return numArray[1].split(delimeter);
    }

    // splitting by delimiter of any length
    public static String[] splitByAnyLengthDelimiter(String numbers) {
        String delimeter = "" + numbers.charAt(3);
        String[] stArr = numbers.split("\n");
        List<String> stringList = new ArrayList<>();
        for(int i=1; i<stArr.length; i++) {
            String[] temp = stArr[i].split(delimeter);
            for(String st: temp) {
                if(!st.isEmpty()) stringList.add(st);
            }
        }

        String[] arr = new String[stringList.size()];
        for(int i=0; i<stringList.size(); i++) arr[i] = stringList.get(i);

        return arr;
    }

    public static String[] splitByMultipleDelimiter(String numbers) {
        String[] strArr = numbers.split("\n");

        return strArr[1].split("[!@#$%^&*_+-]");
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
