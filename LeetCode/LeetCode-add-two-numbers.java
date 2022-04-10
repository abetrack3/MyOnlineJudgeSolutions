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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = (l1.val + l2.val) / 10;
        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
        ListNode tail = l3;
        
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null || l2 != null){
            int i = (l1 == null)? 0 : l1.val;
            int j = (l2 == null)? 0 : l2.val;
            
            tail.next = new ListNode((i + j + carry) % 10);
            tail = tail.next;
            
            carry = (i + j + carry) / 10;
            
            l1 = (l1 == null)? null : l1.next;
            l2 = (l2 == null)? null : l2.next;
            
        }
        
        if(carry == 1)
            tail.next = new ListNode(carry);
        
        return l3;
        
    }
}