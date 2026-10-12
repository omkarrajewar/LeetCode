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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list=new ListNode();
        list.next=head;
        ListNode left=list;
        ListNode right=list;
        for(int i=0;i<=n;i++){
            left=left.next;
        }
        while(left != null){
            left=left.next;
            right=right.next;
        }
        right.next=right.next.next;
        return list.next;
    }
}