package com.qiabuqilang;

public class D19 {
    public void printListNode(ListNode currentNode){
        while(currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.println("------------------------");
    }
    public static void main(String[] args) {
        // create 5 listNode
        ListNode[] listNodes = new ListNode[5];
        for(int i = 0;i<5;i++){
            listNodes[i] = new ListNode(i+1);
        }
        // add next node
        for(int i = 0;i<5;i++){
            if(i == 4){
                listNodes[i].next = (null);
            }else{
                listNodes[i].next = (listNodes[i+1]);
            }
        }
        ListNode headNode = listNodes[0];
        D19 d19 = new D19();
        d19.printListNode(headNode);
        headNode = d19.removeNthFromEnd(headNode,2);
        d19.printListNode(headNode);

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode lastNode = head;
        while(lastNode.next != null){
            size++;
            lastNode = lastNode.next;
        }
        int position = size - n + 1;
        if(position == 1){
            head = head.next;
        }else{
            ListNode previousNode = head;
            ListNode currentNode = head;
            int count = 1;
            while(count < position -1){
                previousNode = previousNode.next;
                count++;
            }
            count = 1;
            while (count< position){
                currentNode = currentNode.next;
                count++;
            }
            if(size > position){
                previousNode.next = currentNode.next;
                currentNode = null;
            }else{
                previousNode.next = null;
            }

        }
        return head;
    }
}
/**
 <p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>
 <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
 <pre>
 <strong>Input:</strong> head = [1,2,3,4,5], n = 2
 <strong>Output:</strong> [1,2,3,5]
 </pre>

 <p><strong class="example">Example 2:</strong></p>

 <pre>
 <strong>Input:</strong> head = [1], n = 1
 <strong>Output:</strong> []
 </pre>

 <p><strong class="example">Example 3:</strong></p>

 <pre>
 <strong>Input:</strong> head = [1,2], n = 1
 <strong>Output:</strong> [1]
 </pre>

 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li>The number of nodes in the list is <code>sz</code>.</li>
 <li><code>1 &lt;= sz &lt;= 30</code></li>
 <li><code>0 &lt;= Node.val &lt;= 100</code></li>
 <li><code>1 &lt;= n &lt;= sz</code></li>
 </ul>

 <p>&nbsp;</p>
 <p><strong>Follow up:</strong> Could you do this in one pass?</p>

 <div><div>Related Topics</div><div><li>Linked List</li><li>Two Pointers</li></div></div><br><div><li>👍 13548</li><li>👎 559</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//leetcode submit region end(Prohibit modification and deletion)
