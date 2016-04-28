import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/**
 * A class that simulates a clock
 * @author McKayla
 *
 */
@SuppressWarnings("serial")
public class Clock extends JComponent {
	/**
	 * 
	 */
	private int hours;
	private int minutes;
	private final double radius = 100;
	private final double mph = 60; //Minutes per hour
	private final double hpd = 12; //Hours per day
	private final double hourHand = 75;
	private final double minHand = 90;
	
	/**
	 * Sets default time to 12:00
	 */
	public Clock() {
	      hours = 12;
	      minutes = 0;
	}
	
	/**
	 * Sets the time
	 * @param hours
	 * @param minutes
	 */
	public void setTime(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	/**
	 * Constructs the face of the clock and determines where the minute and hour hands
	 * should respectively appear when a digital time is entered
	 */
	public void paintComponent(Graphics g) {
	      Graphics2D g2 = (Graphics2D) g;
	      
	      Ellipse2D.Double face = new Ellipse2D.Double(0, 0, 2 * radius, 2 * radius);
	      g2.draw(face);
	      Point2D.Double center = new Point2D.Double(radius, radius);
	      
	      double angle = Math.PI /2 - 2 * Math.PI * minutes / mph;
	      Point2D.Double minutePoint = new Point2D.Double(radius + minHand * Math.cos(angle), radius - minHand * Math.sin(angle));
	      Line2D.Double minuteHand = new Line2D.Double(center, minutePoint);
	      g2.draw(minuteHand);
	      
	      angle = Math.PI / 2 - 2 * Math.PI * (hours * mph + minutes) / (mph * hpd);
	      Point2D.Double hourPoint = new Point2D.Double(radius + hourHand * Math.cos(angle), radius - hourHand * Math.sin(angle));
	      Line2D.Double hourHand = new Line2D.Double(center, hourPoint);
	      g2.draw(hourHand);
	}

}
