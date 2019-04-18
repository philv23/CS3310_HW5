package CS3310.wmich.edu.PVarnerKHamelink;

public class LinkedList {

	public Node head;
	public Node tail;

	/**
	 * Constructor, initializes Linked List
	 * 
	 * @param head
	 * @param tail
	 */

	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Gives the size of the Linked List
	 * 
	 * @return int size
	 */

	public int size() {
		int count = 0;
		Node headCopy = head;

		while (headCopy != null) {
			count++;
			headCopy = headCopy.next;
		}
		return count;
	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add Node to end of linked list with given value
	 * 
	 * @param double e value of Node
	 */

	public void add(int key, int value) {
		// List is empty
		if (head == null) {
			Node newNode = new Node(key, value);
			head = newNode;
			tail = head;
		} else {
			Node newNode = new Node(key, value);
			tail.next = newNode;
			tail = tail.next;
		}
	}

	/**
	 * Add Node to linked list at given index with given value
	 * 
	 * @param double e value of Node
	 * @param int index
	 */

	public void add(int index, int key, int value) {
		try {
			if (index < 0 || index > size()) {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Invalid Index");
		}

		if (index == 0) {
			Node newNode = new Node(key, value);
			newNode.next = head;
			head = newNode;
		}

		// Index > 0
		else {
			Node newNode = new Node(key, value);
			Node ref = head;

			for (int i = 0; i < index - 1; i++) {
				ref = ref.next;
			}
			Node successor = ref.next;
			ref.next = newNode;
			newNode.next = successor;

			if (newNode.next == null) {
				tail = newNode;
			}

		}
	}

	/**
	 * Set the value of a node at given positio
	 * 
	 * @param double val2 value of Node
	 * @param int position
	 */

	public void set(int position, int val2) {
		Node head1 = head;

		for (int i = 0; i < position; i++) {
			head1 = head1.next;

		}
		head1.value = val2;

	}
	
	public int search(int key) {
		Node head1 = head;
		int size1 = size();
		for (int i = 0; i < size1; i++) {
			if(head1.key == key) {
				return head1.value;
			}
			head1 = head1.next;
		}
		return 0;
	}

	/**
	 * Saves the value of the lists Nodes into a String
	 * 
	 * @return String of Values
	 */

	public String toString() {
		String list = "";

		Node ref = head;
		while (ref != null) {
			list = list + ref.value + " ";
			ref = ref.next;
		}
		return list;

	}
}
