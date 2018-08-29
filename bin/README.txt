Van Trinh

HW1 Retry Report

According to the Retry guidelines, below is my time accounting report for HW1 and HW2 assignments.

HW1 : 16 hours total
- 1 hour reading and comprehending the assignment
- 4 hours writing DoublyLinkedListNode and DoublyLinkedList classes
- 2 hours experimenting ways to sort the list
- 6 hours writing the GUI
- 3 hours fixing bugs and getting all parts to coordinate

HW2 : 6.5 hours total
- 1 hour reading the assignment
- 5 hours writing JUNIT tests
- 30 minutes writing the report

HW1 Retry: 4 hours total
- 2.5 hours fixing methods
- 1 hour changing the GUI
- 30 minutes writing the report


Changes I made were based on your comments on my HW1. In particular, I copied and pasted 
your comments below, and noted what I changed:

87

General
---------------
	incorrect file and folder names
	don't include SinglyLinkedList and SinglyLinkedListNode in src folder

==> I checked, and the file and folder names are now correct. 
    I also excluded SinglyLinkedListNode and Singly LinkedList files from the package.

Application
---------------
-5	names not added to roster in alphabetic order, fixed when name added to waitlist
	error message box and OK and Cancel buttons, only OK needed
-3	name can be added twice, both deleted when one deleted
	empty lines left in text box when name is deleted
	
==> I made names to be added alphabetically as we go, no longer wait till the end to sort.
    I also changed error message to provide only OK button, no longer both 2 buttons as before.
    I made it so that name can only be added once now. 
    If user tries to add the same name again, an error message appears.
    I also fixed the empty lines left in text box when name is deleted. Now there are no empty lines.

Source code
---------------
	DoublyLinkedList.java:257 index not used, IDE gives a warning
-5	Roster.java - sortRoster is hard coded for a list of length 3, sort algorithm is clumsy

==> I fixed warnings from IDE.
    I also replaced sortRoster with compareAndAdd method, which does not hard code, but compares
    and adds name in a way that gives alphabetical order. The algorithm is now flexible for list
    of any length. We can change to desirable length by simply changing MAX_SIZE variable in Roster.
    

Thank you for your reading :)
    