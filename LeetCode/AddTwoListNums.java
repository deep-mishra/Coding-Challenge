package com;

/** Problem:
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */


/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoListNums {

	/**
	 * Add two lists data
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head = null, cur = null, prev = null;
		int sum = 0, carrRet = 0, reminder;
		while (l1 != null || l2 != null) {
			if(l1 != null && l2 != null) {
				sum = l1.val + l2.val + carrRet;
				l1 = l1.next;
				l2 = l2.next;
			} else if(l1 != null) {
				sum = l1.val + carrRet;
				l1 = l1.next;
			} else {
				sum = l2.val + carrRet;
				l2 = l2.next;
			}
			
			carrRet = sum / 10;
			reminder = sum % 10;
			cur = new ListNode(reminder);
			
			if (head == null) {
				head = cur;
				prev = cur;
			} else {
				prev.next = cur;
				prev = cur;
			}
		}
		if (carrRet != 0) {
			cur = new ListNode(carrRet);
			prev.next = cur;
		}

		return head;
	}

	/**Display the List
	 * 
	 * @param node
	 */
	public static void show(ListNode node) {
		while(node != null) {
			System.out.print( node.val + " -> ");
			node = node.next;
		}
		System.out.print("null");
	}
	
	public static void main(String[] args) {	
		ListNode h1, n1;
		n1 = new ListNode(2);
		h1 = n1;
		n1.next = new ListNode(4);
		n1 = n1.next;
		n1.next = new ListNode(3);
		n1 = n1.next;

		System.out.println("First Number");
		show(h1);
		
		ListNode h2, n2;		
		n2 = new ListNode(5);
		h2 = n2;
		n2.next = new ListNode(6);
		n2 = n2.next;
		n2.next = new ListNode(4);
		n2 = n2.next;
		
		System.out.println("Second Number");
		show(h2);
				
		ListNode h3 =  addTwoNumbers(h1, h2);
		
		System.out.println("Summation");
		show(h3);
		
	}
	
	
}