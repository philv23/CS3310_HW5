package CS3310.wmich.edu.PVarnerKHamelink;

public class Node {
	int key;
	int value;
	Node next;

	/**
	 * Constructor, initializes Node
	 * 
	 * @param value
	 * @param next
	 */

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		next = null;
	}

}