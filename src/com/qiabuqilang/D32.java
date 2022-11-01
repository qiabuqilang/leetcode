package com.qiabuqilang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class D32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();

        if (len < 2) {
            return 0;
        }
        int res = 0;
        int lnum = 0;
        int rnum = 0;
        for (int i = 0; i < len; i++) {
            char chari = s.charAt(i);
            if (chari == 40 || chari == 91 || chari == 123) {
                lnum++;
            } else {
                rnum++;
                if(rnum > lnum){
                    break;
                }
            }
        }
        for (int i = 0; i < rnum; i++) {
            char chari = s.charAt(i);
            if (chari == 40 || chari == 91 || chari == 123) {
                stack.push(chari);
            } else {
                if (stack.empty()) {
                    continue;
                } else {
                    char pop = stack.pop();
                    switch (chari) {
                        case 41:
                            res += 2;
                            break;

                        case 93:
                            res += 2;
                            break;

                        case 125:
                            res += 2;
                            break;
                        }
                    }
            }

        }
        int res1 =0;
        for (int i = rnum+1; i < len; i++) {
            char chari = s.charAt(i);
            if (chari == 40 || chari == 91 || chari == 123) {
                stack.push(chari);
            } else {
                if (stack.empty()) {
                    continue;
                } else {
                    char pop = stack.pop();
                    switch (chari) {
                        case 41:
                            res1 += 2;
                            break;

                        case 93:
                            res1 += 2;
                            break;

                        case 125:
                            res1 += 2;
                            break;
                    }
                }
            }

        }
        if(res>res1){
            return res;
        }else{
            return res1;
        }
    }
/*
* 12112
* 11212
* 121122
* 12111122
* 12111112
* */
    public static void main(String[] args) {
        String s1= "(()";
        String s2 =")()())";
        String s3 = "";
        String s4 ="()(()";
        String s5 ="(()()";
        String s6 ="()(())";
        D32 d32 = new D32();
        System.out.println(d32.longestValidParentheses(s2));
    }
}
