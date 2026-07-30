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
    public ListNode middleNode(ListNode head) {
        ListNode sl =head ,ft=head;
        
        while(ft !=null && ft.next !=null){
            sl = sl.next;
            ft = ft.next.next;
        }
        return sl;
    }
}