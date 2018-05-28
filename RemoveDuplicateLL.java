import java.util.Hashtable;

/**
 * Remove duplicate from unsorted linked list
 * @author Deep
 *
 */

class LinkedListNode {
	int data;
	LinkedListNode next;
	LinkedListNode(int d) {data=d;}
}


public class RemoveDuplicateLL {
	
	public static void removeDuplicate(LinkedListNode node) {
		
		Hashtable<Integer, Boolean> htable = new Hashtable<Integer, Boolean>();
		LinkedListNode prev = null;
		while(node != null) {
			if(htable.containsKey(node.data)) {
				prev.next = node.next;
			} else {
				htable.put(node.data,true);
				prev = node;
			}
			node = node.next;
		}
			
	}
	
	/**Display the List
	 * 
	 * @param node
	 */
	public static void show(LinkedListNode node) {
		while(node != null) {
			System.out.print( node.data + " -> ");
			node = node.next;
		}
		System.out.print("null");
	}
	
	public static void main(String[] args) {
		
		LinkedListNode head, n1;
		n1 = new LinkedListNode(2);
		head = n1;
		n1.next = new LinkedListNode(4);
		n1 = n1.next;
		n1.next = new LinkedListNode(3);
		n1 = n1.next;
		n1.next = new LinkedListNode(4);
		n1 = n1.next;
		n1.next = new LinkedListNode(2);
		n1 = n1.next;
		System.out.println("Input List");
		show(head);
		removeDuplicate(head);
		System.out.println();
		System.out.println("Final List");
		show(head);
	}

}


/**
 * Output :
Input List
2 -> 4 -> 3 -> 4 -> 2 -> null
Final List
2 -> 4 -> 3 -> null
*
*/
