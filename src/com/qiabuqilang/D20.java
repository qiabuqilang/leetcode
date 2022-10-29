package com.qiabuqilang;

import java.util.ArrayList;
import java.util.Stack;

public class D20 {



    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();

        if(len<2){
            return false;
        }
        char fchar = s.charAt(0);
        if(fchar ==41 || fchar==93|| fchar==125){
            return false;
        }
        Boolean res = true;
        for(int i=0;i<len;i++){

                char chari = s.charAt(i);
                if(chari == 40 || chari ==91 || chari==123){
                    stack.push(chari);
                }else{

                    if(stack.empty()){
                        res = false;
                    }else{
                        char pop = stack.pop();
                        switch (chari){
                            case 41:
                                res = res &&(pop ==40);
                                break;

                            case 93:
                                res= res &&(pop ==91);
                                break;

                            case 125:
                                res =res &&(pop == 123);
                                break;
                        }
                    }

                }

        }
       int stackSize= stack.size();
        if(stackSize>0){
            return false;
        }
       return res;
    }

    public static void main(String[] args) {

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "(){}}{";
        String s7 = "[";
        String s8 = "({{{{}}}))";
        String s9 = ")(){}";
        String s10= "((";
        D20 d20 = new D20();
//        boolean res1 = d20.isValid(s1);
//        boolean res2 = d20.isValid(s2);
//        boolean res3 = d20.isValid(s3);
//        System.out.println(res1);
//        System.out.println("-----------------");
//        System.out.println(res2);
//        System.out.println("-----------------");
        System.out.println(d20.isValid(s10));
        System.out.println("-----------------");

    }
}
