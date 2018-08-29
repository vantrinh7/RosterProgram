/**
 * This class implements LinkedListNode to create a Doubly Linked List Node
 * 
 * @author vantrinh
 *
 * @param <T>
 */
public class DoublyLinkedListNode<T> implements LinkedListNode<T> {

	/* Variable for the value of a node */
	protected T value;

	/* Variable for the next node */
	protected DoublyLinkedListNode<T> next;

	/* Variable for the previous node */
	protected DoublyLinkedListNode<T> prev;

	/**
	 * Constructs a doubly linked list node with a specified value
	 * 
	 * @param value
	 */
	public DoublyLinkedListNode(T value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see LinkedListNode#getValue()
	 */
	@Override
	public T getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see LinkedListNode#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * This method returns the previous doubly linked list node
	 * 
	 * @return the previous doubly linked list node
	 */
	public DoublyLinkedListNode<T> getPrevious() {
		return prev;
	}

	/**
	 * This method returns the next doubly linked list node
	 * 
	 * @return next doubly linked list node
	 */
	public DoublyLinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * This method set the previous node to be a given value
	 * 
	 * @param node
	 */
	public void setPrevious(DoublyLinkedListNode<T> node) {

		/*
		 * This cast will throw a runtime exception if someone tries to set the next
		 * node to something that is not a DoublyLinkedListNode
		 */
		this.prev = node;
	}

	/**
	 * This method set the next node to be a given value
	 * 
	 * @param node
	 */
	public void setNext(DoublyLinkedListNode<T> node) {

		/*
		 * This cast will throw a runtime exception if someone tries to set the next
		 * node to something that is not a DoublyLinkedListNode
		 */
		this.next = node;
	}

	/**
	 * Returns a String representation of this node.
	 */
	public String toString() {
		// A variable representing a string value
		String result = "";
		// Return the data as a string representation
		return result + this.getValue();
	}
}
