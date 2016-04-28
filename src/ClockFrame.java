import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * A class that composes a GUI for Clock
 * @author softskeleton
 *
 */
@SuppressWarnings("serial")
public class ClockFrame extends JFrame {
	private JLabel hourLabel;
	private JLabel minuteLabel;
	private JTextField hourField;
	private JTextField minuteField;
	private JButton button;
	private JPanel panel;
	private final int FRAME_WIDTH = 600;
	private final int FRAME_HEIGHT = 600;
	private Clock clock;
	
	/**
	 * Composes a panel with texts, labels, fields and buttons
	 */
	public ClockFrame() {
	      clock = new Clock();
	      clock.setPreferredSize(new Dimension(350,350));
	      
	      final int FIELD_WIDTH = 5;
	      
	      hourLabel = new JLabel("Hour: ");
	      hourField = new JTextField(FIELD_WIDTH);
	      hourField.setText("");
	      
	      minuteLabel = new JLabel("Minute: ");
	      minuteField = new JTextField(FIELD_WIDTH);
	      minuteField.setText("");
	      createButton();
	      
	      panel = new JPanel();
	      panel.add(hourLabel);
	      panel.add(hourField);
	      panel.add(minuteLabel);
	      panel.add(minuteField);
	      panel.add(button);
	      panel.add(clock);
	      add(panel);
	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	/**
	 * Creates a draw button which takes the numerical time entered and draws it
	 * on the GUI Clock
	 */
	public void createButton() {
	      button = new JButton("Draw");
	      
	      class DrawListener implements ActionListener {
	         public void actionPerformed(ActionEvent event) {
	            int hour = Integer.parseInt(hourField.getText());
	            int minute = Integer.parseInt(minuteField.getText());
	            clock.setTime(hour, minute);
	            clock.repaint();
	         }
	      }
	      ActionListener listener = new DrawListener();
	      button.addActionListener(listener);       
	   }
	
	

}
