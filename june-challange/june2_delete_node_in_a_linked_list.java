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
        int temp;
        while (node.next.next != null) {
            temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            
            node = node.next;
        }
        
        temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;
        
        node.next = null;
    }
}