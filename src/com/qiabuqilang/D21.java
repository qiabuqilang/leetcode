package com.qiabuqilang;

public class D21 {
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
        D21 d21 = new D21();
        ListNode l1 = listNodes1[0];
        ListNode l2 = listNodes2[0];
        d21.printListNode(l1);
        d21.printListNode(l2);
//        ListNode l3 = d21.mergeTwoLists(l1,l2);
//        d21.printListNode(l3);
        ListNode l4 = null;
        ListNode l5 = null;
//        ListNode l6 = d21.mergeTwoLists(l4,l5);
//        d21.printListNode(l6);
        ListNode l7 = null;
        ListNode l8 = new ListNode(0);
        l8.next = null;
//        ListNode l9 = d21.mergeTwoLists(l7,l8);
//        d21.printListNode(l9);
        ListNode l10 = new ListNode(5);
        l10.next = null;
//        ListNode l11 = d21.mergeTwoLists(l10,l1);
//        d21.printListNode(l11);
        ListNode l12 = new ListNode(-9);
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        l13.next = null;
        ListNode l14 = new ListNode(5);
        ListNode l15 = new ListNode(7);
        l14.next = l15;
        l15.next = null;
        ListNode l16 = d21.mergeTwoLists(l12,l14);
        d21.printListNode(l16);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int size1 = 0;
        int size2 = 0;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while(curr1 != null){
            size1++;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            size2++;
            curr2 = curr2.next;
        }
        int len = size1 + size2;
        if(len <= 0){
            return null;
        }
        ListNode[] listNodes = new ListNode[len];
        int[] arr = new int[len];
        int count = 0;
        while(list1 != null || list2 !=null || count < len){
            int t1 = list1==null?0:list1.val;
            int t2 = list2==null?0:list2.val;
            if(t1 != 0 && t2 != 0){
                if(t1>t2){
                    arr[count] = t2;
                    arr[count+1] = t1;
                }else{
                    arr[count] = t1;
                    arr[count+1] = t2;
                }
                count +=2;
            }else{
                if(t1==0) {
                    arr[count] = t2;
                }else{
                    arr[count] = t1;
                }
                count++;
            }
            list1 = list1 == null?null:list1.next;
            list2 = list2 == null?null:list2.next;
        }
        int temp = 0;
        for(int i=0;i<len;i++){
            for(int j = 0;j<i;j++){
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0;i<len;i++){
            listNodes[i] = new ListNode(arr[i]);
        }
        for(int i=0;i<len;i++){
            if(i==len-1){
                listNodes[i].next = null;
            }else{
                listNodes[i].next = listNodes[i+1];
            }
        }
        return listNodes[0];
    }
}
