package com.CK;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "DCXXI";
        Solution solution = new Solution();
        System.out.println(solution.romanToInt(s));
    }
}

class Solution {
    public int romanToInt(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Integer> num = new ArrayList<>();
        int i = 0;
        String temp;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        while (sb.length() != 0) {
            if (sb.length() > 2 && sb.charAt(0) == sb.charAt(1) && sb.charAt(1) == sb.charAt(2)) {
                i = 3;
                temp = String.valueOf(sb.charAt(0));
                num.add(map.get(temp) * i);
            } else if (sb.length() > 1 && sb.charAt(0) == sb.charAt(1)) {
                i = 2;
                temp = String.valueOf(sb.charAt(0));
                num.add(map.get(temp) * i);
            } else if (sb.length() > 1 && map.containsKey(sb.substring(0, 2))) {
                i = 2;
                num.add(map.get(sb.substring(0, 2)));
            } else {
                i = 1;
                num.add(map.get(String.valueOf(sb.charAt(0))));
            }
            sb.delete(0, i );
        }
        int returnNum = 0;
        for (Integer snum: num){
            returnNum +=snum;
        }
        return returnNum;
    }
}


