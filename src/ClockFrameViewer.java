import javax.swing.JFrame;

/**
 * A class that composes a ClockFrame
 * @author softskeleton
 *
 */
public class ClockFrameViewer {
	public static void main (String[] args) {		
		JFrame frame = new ClockFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("ClockViewer");
                frame.setVisible(true);
	}
}