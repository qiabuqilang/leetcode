package com.qiabuqilang;

public class D24 {
    public void printListNode(ListNode currentNode){
        while(currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.println("------------------------");
    }
    public static void main(String[] args) {
        int len = 4;
        int[] vals = {1,2,3,4};
        // create 5 listNode
        ListNode[] listNodes1 = new ListNode[len];
        for(int i = 0;i<len;i++){
            listNodes1[i] = new ListNode(vals[i]);

        }
        // add next node
        for(int i = 0;i<len;i++){
            if(i == len-1){
                listNodes1[i].next = (null);
            }else{
                listNodes1[i].next = (listNodes1[i+1]);

            }
        }
        ListNode l1 = listNodes1[0];
        D24 d24 = new D24();
        d24.printListNode(l1);
        ListNode l2 = d24.swapPairs(l1);
        d24.printListNode(l2);

    }
    public ListNode swapPairs(ListNode head) {
        int size = 0;
        ListNode current = head;
        while(current != null){
            size++;
            current = current.next;

        }
        if(size <=0){
            return null;
        }
        int len = (int)Math.ceil(size*1.0/2);
        int[][] arr = new int[len][2];

        current = head;
        int n = 0;
        for(int i =0;i<len;i++){
            while(current != null){
                if(n%2==0 && n!=0){
                    n = 0;
                    break;
                }
               arr[i][n] = current.val;
               current = current.next;
               n++;
            }
        }
        for(int i =0;i<len;i++){
            int swap = 0;
            if((i+1)*2-size!=1){
                swap = arr[i][0];
                arr[i][0] = arr[i][1];
                arr[i][1] = swap;

            }

        }
        int[] res = new int[size];
        n = 0;
        for(int i=0;i<len;i++){

                res[n] = arr[i][0];
                if(n<size-1){
                    res[n+1] = arr[i][1];
                }

                n +=2;


        }
        ListNode[] listNodes = new ListNode[size];
        for(int i=0;i<size;i++){
            listNodes[i] = new ListNode(res[i]);
        }
        for(int i=0;i<size;i++){
            if(i == size-1){
                listNodes[i].next = null;
            }else{
                listNodes[i].next = listNodes[i+1];
            }
        }
        return listNodes[0];

    }
}
