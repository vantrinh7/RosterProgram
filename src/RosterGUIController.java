
/**
 * This class constructs GUI and coordinates action events on the GUI and the logic of program
 * @author vantrinh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")

public class RosterGUIController extends JPanel implements ActionListener {

	/* Variable to hold the list of students */
	private Roster newRoster;

	/* Variable to hold the alphabetical list of students */
	private DoublyLinkedList<String> sortedRoster;

	/* The wait list */
	private DoublyLinkedList<String> waitlist;

	/* Text area to type surname */
	private JTextField surNameText;

	/* Text area to type given name */
	private JTextField givenNameText;

	/* Text area to type removed surname */
	private JTextField removedLast;

	/* Text area to type given surname */
	private JTextField removedFirst;

	/* Text area to display roster */
	private JTextArea rosterArea;

	/* Text area to display waitlist */
	private JTextArea waitlistArea;

	/* Add Name button */
	private JButton addButton;

	/* Remove Name button */
	private JButton removeButton;

	/**
	 * Constructs the GUI of program States the layout and calls methods to create
	 * the view
	 */
	public RosterGUIController() {

		/*
		 * Call the super class of JPanel and give it Border Layout with horizontal gap
		 * and vertical gap
		 */
		super(new BorderLayout(10, 50));

		/* Create the left, center, right and bottom areas of the layout */
		createLeft();
		createCenter();
		createRight();
		createBottom();

		/* Initialize the new roster and wait list */
		newRoster = new Roster();
		waitlist = newRoster.getWaitlist();
	}

	/**
	 * Create the left view
	 */
	public void createLeft() {

		/* Create a label for surname */
		JLabel surName = new JLabel("Surname");

		/* Create a label for given name */
		JLabel givenName = new JLabel("Given Name");

		/* Create two name text fields with width of 5 columns */
		surNameText = new JTextField(5);
		givenNameText = new JTextField(5);

		/* Create an Add button to add names to list, add action listener */
		addButton = new JButton("Add");
		addButton.addActionListener(this);

		/* Create a new panel, set size and box layout to store the above items */
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(200, 600));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

		/* Add this panel to the west */
		this.add(westPanel, BorderLayout.WEST);

		/*
		 * Add the items to the panel, and adjusting the positions by creating rigid
		 * (empty) areas between them
		 */
		westPanel.add(Box.createRigidArea(new Dimension(100, 30)));
		westPanel.add(surName);
		westPanel.add(Box.createRigidArea(new Dimension(100, 20)));
		westPanel.add(surNameText);
		westPanel.add(Box.createRigidArea(new Dimension(100, 20)));
		westPanel.add(givenName);
		westPanel.add(Box.createRigidArea(new Dimension(100, 20)));
		westPanel.add(givenNameText);
		westPanel.add(Box.createRigidArea(new Dimension(100, 20)));
		westPanel.add(addButton);
		westPanel.add(Box.createRigidArea(new Dimension(100, 400)));
	}

	/**
	 * Create the center view
	 */
	public void createCenter() {
		/* Create a label for the roster area */
		JLabel rosterLabel = new JLabel("Roster");

		/* Create a text area to display the roster */
		rosterArea = new JTextArea();
		rosterArea.setColumns(10);
		rosterArea.setLineWrap(true);
		rosterArea.setRows(5);
		rosterArea.setEditable(false);

		/* Create a panel, set size and layout */
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(300, 500));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		/* Add this panel to the middle */
		this.add(centerPanel, BorderLayout.CENTER);

		/* Add items to center panel */
		centerPanel.add(rosterLabel);
		centerPanel.add(rosterArea);

	}

	/**
	 * Create the right view
	 */
	public void createRight() {

		/* Create a label for the waitlist area */
		JLabel waitlistLabel = new JLabel("Waitlist");

		/* Create a text area to display the waitlist */
		waitlistArea = new JTextArea();
		waitlistArea.setColumns(10);
		waitlistArea.setLineWrap(true);
		waitlistArea.setRows(5);
		waitlistArea.setEditable(false);

		/* Create a panel, set size and layout */
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(300, 500));
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

		/* Add this panel to the right */
		this.add(eastPanel, BorderLayout.EAST);

		/* Add items to east panel */
		eastPanel.add(waitlistLabel);
		eastPanel.add(waitlistArea);
	}

	/**
	 * Create bottom view
	 */
	public void createBottom() {

		/* Create a Remove button, add action listener */
		removeButton = new JButton("Remove");
		removeButton.addActionListener(this);

		/* Create labels */
		JLabel last = new JLabel("Surname");
		JLabel first = new JLabel("Given Name");

		/* Create a text area to type name in */
		removedLast = new JTextField(5);
		removedFirst = new JTextField(5);

		/* Create a panel to hold the above items */
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(800, 30));
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));

		/* Add panel to the bottom and add items to panel */
		this.add(southPanel, BorderLayout.SOUTH);

		/*
		 * Add the items to the panel, and adjusting the positions by creating rigid
		 * (empty) areas between them
		 */
		southPanel.add(Box.createRigidArea(new Dimension(140, 30)));
		southPanel.add(last);
		southPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		southPanel.add(removedLast);
		southPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		southPanel.add(first);
		southPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		southPanel.add(removedFirst);
		southPanel.add(Box.createRigidArea(new Dimension(10, 30)));
		southPanel.add(removeButton);
		southPanel.add(Box.createRigidArea(new Dimension(5, 30)));
	}

	/**
	 * Specify suitable actions when buttons are clicked
	 * 
	 * @param e
	 *            event
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			add();
		} else if (e.getSource() == removeButton) {
			remove();
		}
	}

	/**
	 * Checks if text fields are empty or not If not, adds name to lists and to the
	 * display
	 */
	public void add() {

		/* If one of two name texts is empty, give a warning */
		if ((surNameText.getText().equals("")) || (givenNameText.getText().equals(""))) {
			String message = "Part of name is missing, please provide both Surname and Given Name!";
			JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.CANCEL_OPTION);
		}
		/* If name texts are not empty */
		else if ((!surNameText.getText().equals("")) && (!givenNameText.getText().equals(""))) {

			/*
			 * Check if name is already in either list, and if so, give a warning. If name
			 * is not in either lists, add it.
			 */
			String name = surNameText.getText() + ", " + givenNameText.getText();

			if (newRoster.isInList(name)) {
				String message = "Name is already in Roster list, please provide a different one";
				JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.CANCEL_OPTION);

			} else if (waitlist.isInList(name)) {
				String message = "Name is already in Waitlist, please provide a different one";
				JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.CANCEL_OPTION);

			} else {
				/* Add to roster list */
				newRoster.add(surNameText.getText(), givenNameText.getText());

				/* Erase the current display, get the sorted roster */
				rosterArea.setText("");
				sortedRoster = newRoster.getRoster();

				/* Then display the sorted roster */
				DoublyLinkedListNode<String> curNode = sortedRoster.getFirstNode();
				while (curNode != null) {
					rosterArea.append("\n" + curNode.getValue());
					curNode = curNode.getNext();
				}

				/* Erase the current display of wait list */
				waitlistArea.setText("");

				/* Display the waitlist */
				DoublyLinkedListNode<String> waitlistHead = waitlist.getFirstNode();
				while (waitlistHead != null) {
					waitlistArea.append("\n" + waitlistHead.getValue());
					waitlistHead = waitlistHead.getNext();
				}
			}
		}

		/* Clear off the text boxes */
		surNameText.setText("");
		givenNameText.setText("");
	}

	/**
	 * Checks if name is present in either lists If it is, remove it from display
	 */
	public void remove() {
		/* Text to be removed */
		String removed = removedLast.getText() + ", " + removedFirst.getText();

		/* If it's in roster, remove it from roster list and display */
		if (newRoster.isInList(removed)) {
			newRoster.remove(removedLast.getText(), removedFirst.getText());

			/* Erase the current display, get the sorted roster */
			rosterArea.setText("");
			// sortedRoster = newRoster.getRoster();

			/* Then display the sorted roster */
			DoublyLinkedListNode<String> curNode = sortedRoster.getFirstNode();
			while (curNode != null) {
				rosterArea.append("\n" + curNode.getValue());
				curNode = curNode.getNext();
			}

			/* If it's in waitlist, remove it from waitlist list and display */
		} else if (waitlist.isInList(removed)) {
			waitlist.remove(waitlist.indexOf(removedLast.getText() + ", " + removedFirst.getText()));

			/* Erase the current display, get the wait list */
			waitlistArea.setText("");
			// waitlist = newRoster.getWaitlist();

			/* Display the waitlist */
			DoublyLinkedListNode<String> waitlistHead = waitlist.getFirstNode();
			while (waitlistHead != null) {
				waitlistArea.append("\n" + waitlistHead.getValue());
				waitlistHead = waitlistHead.getNext();
			}

			/* If it's not in any, give a message */
		} else {
			String message = "Name is not in either lists, please try again!";
			JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.CLOSED_OPTION);
		}

		/* Remove texts from text field */
		removedLast.setText("");
		removedFirst.setText("");
	}
}
