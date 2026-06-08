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
        List<Integer> list1 = new ArrayList<Integer>();     
        List<Integer> list2 = new ArrayList<Integer>();

        ListNode currentNodeL1 = l1;
        while (currentNodeL1.next != null){
            list1.add(currentNodeL1.val);
            currentNodeL1 = currentNodeL1.next;
        }
        list1.add(currentNodeL1.val);

        ListNode currentNodeL2 = l2;
        while (currentNodeL2.next != null){
            list2.add(currentNodeL2.val);
            currentNodeL2 = currentNodeL2.next;
        }
        list2.add(currentNodeL2.val);

        Integer nr1 = 0;
        for (Integer i = list1.size()-1; i >= 0; i--){
            if (nr1 == 0){
                nr1 += list1.get(i);
            }
            else{
                nr1 = (nr1 * 10) + list1.get(i);
            }
        }

        Integer nr2 = 0;
        for (Integer i = list2.size()-1; i >= 0; i--){
            if (nr2 == 0){
                nr2 += list2.get(i);
            }
            else{
                nr2 = (nr2 * 10) + list2.get(i);
            }
        }

        Integer finalSum = nr1 + nr2;
        ListNode currentNode = new ListNode();
        ListNode finalNode = currentNode;
        ListNode nextNode;

        while (finalSum > 0){
            Integer currentDigit = finalSum % 10;
            currentNode.val = currentDigit;
            if (finalSum >= 10) {
                nextNode = new ListNode();
                currentNode.next = nextNode;
                currentNode = currentNode.next;
            }

            finalSum = finalSum / 10;
        }


        return finalNode;
    }
}
