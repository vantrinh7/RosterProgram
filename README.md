Name: Van Trinh

Assignment: 1

Description

* LinkedListNode and LinkedList are interfaces that describe a node and a linked list of nodes (Written by Eitan).

* SinglyLinkedListNode and SinglyLinkedList are used to create a linked list of nodes in which each node has only
one pointer towards the next node (Written by Eitan).

* DoublyLinkedListNode and DoublyLinkedList are used to create a linked list of nodes that have a pointer towards
the next node, and a pointer towards the previous node. They contain methods to construct and modify doubly linked 
list node and doubly linked list to be used for Roster class.

* Roster is a list of students being kept track during add/drop period. It is listed in alphabetically order and
has the maximum size of 3. If more than 3 students are added, the extras will show up in the waitlist, which does 
not have alphabetical order but the order of who is added first.

* RosterApplication has main method that creates a frame and calls RosterGUIController.

* RosterGUIController utilizes BorderLayout manager as an overall layout, creates the panels in the center, west, east
and bottom. The west and bottom panels use BoxLayout to hold JTextFields (to enter names) and JButtons (to modify lists). 
This class also implements an Action Listener, to detect and react to button click events. Specifically, it calls methods
in Roster and DoublyLinkedList to modify the lists when "Add" or "Remove" buttons are clicked. 


References - I referenced StackOverFlow, GeeksForGeeks and Youtube when encountering bugs and questions.

I have tried to make the program as simple as possible without being sloppy. There seems to be a lot of coding, but I
believe they are there for good reason. Although the program sounds very simple, there are in fact a lot of functionalities
to be implemented. DoublyLinkedList and RosterGUIController are much longer than others, mainly because of their crucial
functions in the program. I put a lot of thought into making the program look tolerable and executable. Please bear with
me till the last code lines. Thank you for your reading and understanding :).