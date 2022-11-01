package com.qiabuqilang;

import java.util.Stack;

public class D232 {
    public static void main(String[] args) {
        int len =5;
        MyQueue myQueue = new MyQueue();
        for(int i=0;i<len;i++){
            myQueue.push(i+1);
        }
        for(int i=0;i<len;i++){
            System.out.println(myQueue.pop());
        }
    }
}
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public boolean empty() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty();
    }
}