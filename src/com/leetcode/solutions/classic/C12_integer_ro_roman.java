package com.leetcode.solutions.classic;

public class C12_integer_ro_roman {
    public String intToRoman(int num) {
        if (num <= 10) return toString(num);

        // we first get the num of digits of the integer
        int temp = num;
        int nDigits = -1; // 1 less than actual number
        while (temp > 0) {
            nDigits++;
            temp /= 10;
        }

        // create an empty string
        StringBuilder sb = new StringBuilder();

        // parse the integer from left to right
        while (num > 0) {
            int place = (int) Math.pow(10, nDigits--);
            int digit = num / place;
            num -= digit * place;

            if (digit == 4 || digit == 9) {
                sb.append(toString(place));
                sb.append(toString((digit + 1) * place));
            } else if (digit == 5) {
                sb.append(toString(place * digit));
            } else if (digit < 4){
                for (int i = 0; i < digit; i++) {
                    sb.append(toString(place));
                }
            } else if (digit > 5) {
                sb.append(toString(5 * place));
                for (int i = 0; i < digit - 5; i++) {
                    sb.append(toString(place));
                }
            }
        }

        return sb.toString();
    }

    private String toString(int num) {
        String roman = "";
        switch(num) {
            case 1: roman = "I";
                break;
            case 2: roman = "II";
                break;
            case 3: roman = "III";
                break;
            case 4: roman = "IV";
                break;
            case 5: roman = "V";
                break;
            case 6: roman = "VI";
                break;
            case 7: roman = "VII";
                break;
            case 8: roman = "VIII";
                break;
            case 9: roman = "IX";
                break;
            case 10: roman = "X";
                break;
            case 50: roman = "L";
                break;
            case 100: roman = "C";
                break;
            case 500: roman = "D";
                break;
            case 1000: roman = "M";
                break;
            default: roman = "Invalid";
                break;
        }
        return roman;
    }
}
