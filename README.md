# Roster Program

Roster is a program that keeps track of students during a period of adding and dropping classes. 

![](misc/1.png)      ![](misc/2.png)

The user interface consists of a column with roster size and name of student to be added. Student names are sorted into alphabetical order in the Roster, and first-in-first-out order in the Waitlist. At the beginning, students are added to the Roster, and when the roster reaches its given size, students are added to the waitlist. When removing a student name, the program searches and removes the name from whichever list it is in. 

## File Description

* [LinkedListNode](https://github.com/vantrinh7/RosterProgram/blob/master/src/LinkedListNode.java) and [LinkedList](https://github.com/vantrinh7/RosterProgram/blob/master/src/LinkedList.java) are interfaces that describe a node and a linked list of nodes.

* [DoublyLinkedListNode](https://github.com/vantrinh7/RosterProgram/blob/master/src/DoublyLinkedListNode.java) and [DoublyLinkedList](https://github.com/vantrinh7/RosterProgram/blob/master/src/DoublyLinkedList.java) are used to create a list of nodes in which each node has a pointer towards the next node, and a pointer towards the previous node. They contain methods to construct and modify doubly linked list node and list to be used for Roster class.

* [Roster](https://github.com/vantrinh7/RosterProgram/blob/master/src/Roster.java) is a list of students being kept track during add/drop period. It is listed in alphabetically order and has the size provided by the user. If more studenst than the determined size are added, the extras will show up in the waitlist, which has first in first out order instead of alphabetical order.

* [RosterApplication](https://github.com/vantrinh7/RosterProgram/blob/master/src/RosterApplication.java) has the main method, which creates a frame and calls RosterGUIController.

* [RosterGUIController](https://github.com/vantrinh7/RosterProgram/blob/master/src/RosterGUIController.java) utilizes BorderLayout manager as an overall layout, creates the panels in the center, west, east and bottom. The west and bottom panels use BoxLayout to hold JTextFields (to enter names) and JButtons (to modify lists). This class also implements an Action Listener that detects and reacts to button click events. Specifically, it calls methods in Roster and DoublyLinkedList to modify the lists when "Add" or "Remove" buttons are clicked. 


