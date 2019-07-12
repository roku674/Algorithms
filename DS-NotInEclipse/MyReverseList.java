//package a2;

import java.util.Collections;
import java.util.List;

//pulled from the in class example
class ListNode {
	public int val;
	public ListNode next;
	public String data;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	public ListNode(int x, ListNode nextnode) {
		val = x;
		next = nextnode;
	}
}
public class MyList {
	private Node head;
	private int size;
	private Node tail;
	
	public void deleteNode(int node) {
		// delete the node(except the data) in the list.
		// given only access to that node;
        //node.val = node.next.val;
        //node.next = node.next.next;
        if (head == null)
            return;
        Node temp = head;
        if (node == 0)
        {
            head = temp.next;  
            return;
        }
        for (int i=0; temp!=null && i<node-2; i++)
            temp = temp.next;
 
        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;  
	     }
	
	public void printNode(ListNode node) {
		System.out.println(node.val);
	}
	public void printNodeList(ListNode next) {
		//print out the sub-list starting with the node
		ListNode temp = next;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }
        System.out.println();
	}
	
	public static void main(String[] args) {
		MyList MyList = new MyList();
		MyList.add(1);
		MyList.add(2);
		MyList.add(3);
		MyList.add(4);
		MyList.add(5);
		MyList.deleteNode(3);
		System.out.println(MyList.toString());
		
		//System.out.println(MyList.toString());
		//MyList.addAfter(3,2);
		//System.out.println(MyList.toString());
		//MyList.addAfter(4,2);
		//System.out.println(MyList.toString());

	}

	private void add(int element) {
		Node node = new Node();
		node.setValue(element);
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.setNext(node);
			tail = node;
		}
		setSize(getSize() + 1);
	}
	
	public String toString() {
		String s = " "; 
		Node iter = head;
		while(iter != null) {
			s = s+ iter.getValue()+ " --> ";
			iter = iter.getNext();
		}
		
		return s + "end";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}


class Node {
	public Object val;
	private int value;
	Node next;
	
	public int getValue() {
		return this.value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public int compareTo(int tmp) {
		return (tmp == this.value)? 0 : 1;
	}
	
}
