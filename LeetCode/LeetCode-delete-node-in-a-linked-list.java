/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        for(; node.next.next != null; node = node.next){
            node.val = node.next.val;
        }
        node.val = node.next.val;
        node.next = null;
    }
}