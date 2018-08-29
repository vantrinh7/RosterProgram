
/**
 * This class has the main method, runs the program and provides JFrame for the program
 * @author vantrinh
 *
 */

import javax.swing.JFrame;

public class RosterApplication {

	/* The height of frame */
	public static int FRAME_WIDTH = 800;

	/* The width of frame */
	public static int FRAME_HEIGHT = 500;

	/**
	 * This method creates JFrame that holds the view
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/* Create a new frame */
		JFrame guiFrame = new JFrame("Roster Program");

		/* Set size of the frame */
		guiFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		/* Add the panel Roster GUI Controller */
		guiFrame.add(new RosterGUIController());

		/* Exit normally on closing the window */
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Show the frame */
		guiFrame.setVisible(true);
	}
}
