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

import java.util.*;
import java.math.*;

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

        BigInteger nr1 = BigInteger.ZERO;
        for (int i = list1.size()-1; i >= 0; i--){
            BigInteger digit = BigInteger.valueOf(list1.get(i));
            nr1 = nr1.multiply(BigInteger.TEN).add(digit);
        }

        BigInteger nr2 = BigInteger.ZERO;
        for (int i = list2.size()-1; i >= 0; i--){
            BigInteger digit = BigInteger.valueOf(list2.get(i));
            nr2 = nr2.multiply(BigInteger.TEN).add(digit);
        }
        
        System.out.println(nr1);
        System.out.println(nr2);

        BigInteger finalSum = nr1.add(nr2);
        if (finalSum.equals(BigInteger.ZERO)){
            return new ListNode(0);
        }
        System.out.println(finalSum);

        ListNode currentNode = new ListNode();
        ListNode finalNode = currentNode;
        ListNode nextNode;

        while (finalSum.compareTo(BigInteger.ZERO) > 0){
            int currentDigit = finalSum.remainder(BigInteger.TEN).intValue();
            currentNode.val = currentDigit;
            System.out.println(currentDigit);
            
            finalSum = finalSum.divide(BigInteger.TEN);

            if (finalSum.compareTo(BigInteger.ZERO) > 0) {
                nextNode = new ListNode();
                currentNode.next = nextNode;
                currentNode = currentNode.next;
            }
        }


        return finalNode;
    }
}
