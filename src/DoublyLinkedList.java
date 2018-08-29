/**
 * This class creates a doubly linked list implements linked list class
 * 
 * @author vantrinh
 * @param <T>
 *            generic type
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

	/* Total number of nodes in the linked list */
	protected int count = 0;

	/* Variable for the first node of the linked list */
	protected DoublyLinkedListNode<T> head;

	/**
	 * This method returns the value of the first node
	 * 
	 * @return T value
	 */
	@Override
	public T getFirst() {
		if (head != null) {
			return head.getValue();
		}
		return null;
	}

	/**
	 * Get the first node of the list
	 * 
	 * @return the first node of the list
	 */
	public DoublyLinkedListNode<T> getFirstNode() {
		if (head != null) {
			return head;
		}
		return null;
	}

	/**
	 * This method returns the value of the last node
	 * 
	 * @return T value
	 */
	@Override
	public T getLast() {
		if (head != null) {
			return getLastNode().getValue();
		}
		return null;
	}

	/**
	 * This method extracts the last node of the list
	 * 
	 * @return the last node
	 */
	protected DoublyLinkedListNode<T> getLastNode() {

		if (head != null) {
			/* Create a variable for the current node, set it to head */
			DoublyLinkedListNode<T> curNode = head;

			/* Move through each node until the last node */
			while (curNode.getNext() != null) {
				curNode = curNode.getNext();
			}
			return curNode;
		}
		return null;
	}

	/**
	 * Returns the node at the specified position in this list.
	 * 
	 * @param index
	 * @return node at the specified position in this list.
	 */
	protected DoublyLinkedListNode<T> getNode(int index) {

		if (head != null) {
			DoublyLinkedListNode<T> curNode = head;

			while (index > 0) {

				/* Move through each element in the list */
				curNode = curNode.getNext();

				/* Decrement the index */
				index--;
			}
			/* Return node when index is 0 */
			return curNode;
		}
		return null;
	}

	/**
	 * This method appends a specified element to the end of the list
	 * 
	 * @param T
	 *            element
	 */
	@Override
	public void add(T element) {

		/* Create a new doubly linked list node */
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element);

		if (head == null) {

			/* Assign new node to be the head */
			head = newNode;

		} else {
			/* Store value of last node */
			DoublyLinkedListNode<T> lastNode = this.getLastNode();

			/* Otherwise set the next of the last node to be new node */
			lastNode.setNext(newNode);

			/* Otherwise set the previous of the new node to be last node */
			newNode.setPrevious(lastNode);
		}

		/* Increment the total amount of nodes in the list */
		count++;
	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices). This method covers possiblity of
	 * adding to the beginning and middle of the list. To add to the end of the
	 * list, use method add(T element) above
	 * 
	 * @param int
	 *            the index where we want to add
	 * @param T
	 *            the value of node to be added
	 */
	@Override
	public void add(int index, T element) {

		if (index == 0) {

			/* Give head value to an old head varible */
			DoublyLinkedListNode<T> oldHead = head;

			/* Assign desired node value to become new head value */
			head = new DoublyLinkedListNode<T>(element);

			/* Set the next */
			head.setNext(oldHead);

			/* Set previous */
			oldHead.setPrevious(head);

		} else {

			/* Get the node before the position we want to add */
			DoublyLinkedListNode<T> prevNode = getNode(index - 1);

			/* Get the node after the position we want to add */
			DoublyLinkedListNode<T> nextNode = prevNode.getNext();

			/* Create a variable to hold new node to be created */
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element);

			/* Set the previous of the new node */
			newNode.setPrevious(prevNode);

			/* Set the next of the new node */
			newNode.setNext(nextNode);

			/* Set the next of previous node to be the new node */
			prevNode.setNext(newNode);

			/* Set the previous of next node to be the new node */
			nextNode.setPrevious(newNode);

			/* Increase total node */
			count++;
		}

	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param int
	 *            the index number
	 */
	@Override
	public T remove(int index) {

		/* Create a variable to hold the removed node */
		DoublyLinkedListNode<T> removedNode = getNode(index);

		/* If the head or the removed node is null, end the method */
		if (head == null || removedNode == null) {
			return null;

			/* If node to be removed is head */
		} else if (head == removedNode) {

			/* Move head pointer to the next */
			head = head.getNext();

			/* If node to be removed is the last node */
		} else if (removedNode.getNext() == null) {

			/* Set the pointer of previous of it to null */
			removedNode.getPrevious().setNext(null);

			/* If node to be removed is somewhere in the middle */
		} else if (removedNode.getPrevious() != null && removedNode.getNext() != null) {
			removedNode.getNext().setPrevious(removedNode.getPrevious());

			removedNode.getPrevious().setNext(removedNode.getNext());
		}

		/* Reduce the amount of nodes in list */
		count--;

		return removedNode.getValue();
	}

	/**
	 * This method returns the value of a node at a certain index
	 * 
	 * @param int
	 *            the index number
	 */
	@Override
	public T get(int index) {
		if (head != null) {
			return getNode(index).getValue();
		}
		return null;
	}

	/**
	 * Returns index of the first occurrence of given value in the list or -1 if not
	 * found
	 * 
	 * @param value
	 *            the value to be looked for
	 * @return index of this value
	 */
	public int indexOf(T value) {
		int index = 0;
		DoublyLinkedListNode<T> curNode = head;

		/* Iterate through the list and check each value */
		while (curNode != null) {
			if (curNode.getValue().equals(value)) {
				return index;
			}
			index++;
			curNode = curNode.getNext();
		}
		return -1;

	}

	/**
	 * Checks if a value is in the list
	 * 
	 * @param value
	 *            the value passed in
	 * @return true if it is, false otherwise
	 */
	public boolean isInList(T value) {
		int index = 0;
		DoublyLinkedListNode<T> curNode = head;
		while (curNode != null) {
			if (curNode.getValue().equals(value)) {
				return true;
			}
			index = index + 1;
			curNode = curNode.getNext();
		}
		return false;
	}

	/**
	 * Return the amount of nodes in the list
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * Check if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Clear the whole list
	 */
	@Override
	public void clear() {
		head = null;
		count = 0;
	}

	/**
	 * Return a String representation of the list.
	 * 
	 * @return a string of the list
	 */
	public String toString() {
		String list = "";
		for (DoublyLinkedListNode<T> node = head; node != null; node = node.getNext()) {
			list = list + " " + node.toString();
		}
		return list;
	}
}
