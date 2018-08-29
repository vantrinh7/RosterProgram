/**
 * This class creates a roster that uses Douby Linked List to keep trach of
 * students during add/period. The maximum roster size is 3
 * 
 * @author vantrinh
 *
 */
public class Roster {

	/* Maximum size of the roster */
	public static final int MAX_SIZE = 3;

	/* A doubly linked list variable for roster */
	private DoublyLinkedList<String> roster;

	/* A doubly linked list variable for waitlist */
	private DoublyLinkedList<String> waitlist;

	/* Count number of student */
	private int count = 0;

	/**
	 * This constructor creates an empty roster
	 */
	public Roster() {

		/* Creates an empty roster and waitlist */
		roster = new DoublyLinkedList<String>();
		waitlist = new DoublyLinkedList<String>();
	}

	/**
	 * Adds a name to roster alphabetically
	 * 
	 * @param surname
	 *            student's surname
	 * @param givenName
	 *            student's given name
	 */
	public void add(String surname, String givenName) {

		if (count < MAX_SIZE) {

			/* Add to roster alphabetically */
			compareAndAdd(surname, givenName);

		} else {

			/* Add to waitlist */
			waitlist.add(surname + ", " + givenName);
		}

		/* Increment student count */
		count = count + 1;
	}

	/**
	 * Removes the first occurrence of a certain name in the list
	 * 
	 * @param surname
	 *            student's surname
	 * @param givenName
	 *            student's given name
	 */
	public void remove(String surname, String givenName) {

		/* If name is in roster or waitlist, remove name */
		if (roster.isInList(surname + ", " + givenName)) {
			roster.remove(roster.indexOf(surname + ", " + givenName));

		} else if (waitlist.isInList(surname + ", " + givenName)) {
			waitlist.remove(roster.indexOf(surname + ", " + givenName));
		}

		count = count - 1;
	}

	/**
	 * This method arranges the returns a roster in alphabetical order
	 * 
	 * @return the sorted roster
	 */
	public DoublyLinkedList<String> getRoster() {
		return roster;
	}

	/**
	 * This method returns the waitlist according to the order at which students
	 * were added
	 * 
	 * @return the waitlist
	 */
	public DoublyLinkedList<String> getWaitlist() {
		return waitlist;
	}

	/**
	 * Checks if a value is in the roster list
	 * 
	 * @param value
	 *            to be passed in
	 * @return true if it's in the list
	 */
	public boolean isInList(String value) {
		return roster.isInList(value);
	}

	/**
	 * Method to compare strings and add names to roster alphabetically
	 */
	public void compareAndAdd(String surname, String givenName) {

		/* If roster is empty, add to the beginning */
		if (roster.isEmpty()) {
			roster.add(surname + ", " + givenName);

		} else {

			/* Get the first node of the index, assign it to curNode value */
			DoublyLinkedListNode<String> curNode = roster.getFirstNode();

			/*
			 * Iterate through the array, compare the name to be added with the value of the
			 * node
			 */
			while (curNode != null) {

				/* If name to be added precedes name of current node */
				if (surname.compareTo(curNode.getValue()) < 0) {

					/* Add name to the index of current node */
					roster.add(roster.indexOf(curNode.getValue()), surname + ", " + givenName);
					break;

				} else {

					/* If current node is the last node , add to the end of the list */
					if (curNode == roster.getLastNode()) {
						roster.add(surname + ", " + givenName);
						break;
					} else {
						/* Move to next node */
						curNode = curNode.getNext();
					}
				}
			}
		}
	}
}
