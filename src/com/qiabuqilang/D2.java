package com.qiabuqilang;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    
}

public class D2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int odds = 0;
      String stringRes = "";
       while(l1 != null || l2 != null || odds !=0){
         int temp1 = (l1==null)?0:l1.val;
         int temp2 = (l2==null)?0:l2.val;
         int sum = 0;
         if(odds >0){
             sum = temp1 + temp2 +odds;
         }else{
             sum = temp1 + temp2;
         }
         odds =0;
         if(sum >=10){
             int oddsl = Math.floorDiv(sum,10);
             sum = sum%10;
             for(int i=0;i<oddsl;i++){
                 odds++;
             }
         }
         stringRes += sum;
         l1 = (l1==null)?null:l1.next;
         l2 = (l2==null)?null:l2.next;
       }
        int lenr = stringRes.length();
        ListNode[] listNodes = new ListNode[lenr];
        for(int i=0;i<lenr;i++){
            int temp = stringRes.charAt(i) - '0';
            listNodes[i] = new ListNode(temp);
        }
        for(int i = 0;i<lenr;i++){
            if(i == lenr -1){
                listNodes[i].next = null;
            }else{
                listNodes[i].next = listNodes[i+1];
            }
        }
        ListNode currentNode = listNodes[0];
        while (currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
       return listNodes[0];
    }

    public static void main(String[] args) {
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l10.next=(l11);
        l11.next=(l12);
        l12.next=(null);
        ListNode l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l20.next=(l21);
        l21.next=(l22);
        l22.next=(null);
        D2 d2 = new D2();
//        d2.addTwoNumbers(l10,l20);
        ListNode b1 = new ListNode(0);
        b1.next=(null);
        ListNode b2 = new ListNode(0);
        b2.next=(null);
//        d2.addTwoNumbers(b1,b2);

        ListNode[] a1 = new ListNode[7];
        ListNode[] a2 = new ListNode[4];
        for(int i =0;i<7;i++){
            a1[i] = new ListNode(9);
        }
        for(int i =0;i<7;i++){
            if(i == 6){
                a1[i].next=(null);
            }else{
                a1[i].next=(a1[i+1]);
            }
        }

        for(int i =0;i<4;i++){
            a2[i] = new ListNode(9);
        }
        for(int i = 0;i<4;i++){
            if(i == 3){
                a2[i].next=(null);
            }else{
                a2[i].next=(a2[i+1]);
            }
        }

        d2.addTwoNumbers(a1[0],a2[0]);
    }
}

