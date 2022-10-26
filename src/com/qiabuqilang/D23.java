package com.qiabuqilang;

public class D23 {
    public void printListNode(ListNode currentNode){
        while(currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        int len = 3;
        // create 5 listNode
        ListNode[] listNodes1 = new ListNode[len];
        ListNode[] listNodes2 = new ListNode[len];
        for(int i = 0;i<len;i++){
            listNodes1[i] = new ListNode(i+1);
            listNodes2[i] = new ListNode(i+2);
        }
        // add next node
        for(int i = 0;i<len;i++){
            if(i == len-1){
                listNodes1[i].next = (null);
                listNodes2[i].next = (null);
            }else{
                listNodes1[i].next = (listNodes1[i+1]);
                listNodes2[i].next = (listNodes2[i+1]);
            }
        }
        ListNode l1 = listNodes1[0];
        ListNode l2 = listNodes2[0];
        D23 d23 = new D23();
        d23.printListNode(l1);
        d23.printListNode(l2);
        ListNode[] l3 = new ListNode[2];
        l3[0] = l1;
        l3[1] = l2;
        ListNode l4 = d23.mergeKLists(l3);
        d23.printListNode(l4);
        ListNode l5 = null;
        ListNode[] l6 = new ListNode[1];
        l6[0] = l5;
//        ListNode l7 = d23.mergeKLists(l6);
//        d23.printListNode(l7);
        ListNode l8 = new ListNode(-1);
        l8.next = null;
        ListNode l9 = new ListNode(2);
        l9.next = null;
        ListNode[] l10 = new ListNode[3];
        l10[0] = l9;
        l10[1] = l5;
        l10[2] = l8;
//        ListNode l11 = d23.mergeKLists(l10);
//        d23.printListNode(l11);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int size = 0;
        ListNode[] current = new ListNode[lists.length];
        for(int i=0;i<lists.length;i++){
            current[i] = lists[i];
            while(lists[i] != null){
                size++;
                lists[i] = lists[i].next;

            }
        }
        if(size <=0){
            return null;
        }
        int[] arr = new int[size];
        int count = 0;
        for(int i=0;i<current.length;i++){
            while(current[i] != null){
                arr[count] = current[i].val;
                current[i] = current[i].next;
                count++;
            }
        }
        int temp = 0;
        for(int i=0;i<size;i++){
            for(int j = 0;j<i;j++){
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        ListNode[] listNodes = new ListNode[size];
        for(int i=0;i<size;i++){
            listNodes[i] = new ListNode(arr[i]);
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
