package com.qiabuqilang;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class D255 {
    public static void main(String[] args) {
        /*Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        System.out.println(queue1.element());
        System.out.println(queue1.element());*/
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
    }

}

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if(queue1.isEmpty()){
            queue2.add(x);
        }else{
            queue1.add(x);
        }
    }

    public int pop() {
        int i,size;
        if(queue2.isEmpty()){
            size = queue1.size();
            i = 0;
            while(i<size-1){
                queue2.add(queue1.remove());
                i++;
            }
            return queue1.remove();
        }else{
            size = queue2.size();
            i=0;
            while (i<size-1){
                queue1.add(queue2.remove());
                i++;
            }
            return queue2.remove();
        }
    }

    public int top() {
        int i,size;
        Integer data =null;
        if(queue2.isEmpty()){
            size = queue1.size();
            i = 0;
            while(i<size-1){
                queue2.add(queue1.remove());
                i++;
            }
            data = queue1.remove();
            queue2.add(data);
        }else{
            size = queue2.size();
            i=0;
            while (i<size-1){
                queue1.add(queue2.remove());
                i++;
            }
            data = queue2.remove();
            queue1.add(data);
        }
        return data;
    }

    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

