package socialdistancing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/* 
	BuildingView extends JPanel so that we can override the paint method. The paint method is necessary to use the simple
	drawing tools of the library! 
	Simulator implements an ActionListener which adds the method actionPerformed. This method is invoked by the 
	animation timer every timerValue(16ms).
*/
public class BuildingView extends JPanel implements ActionListener {
	// serial suppresses warning
	private static final long serialVersionUID = 1L;

	// simulation control objects/values
	JFrame frame;
	SimulationController control; //
	Timer timer; // Event control
	int time = 0; // Track time as the simulation runs
	CommunityModel commuityModel;

	/* constructor will setup our main Graphic User Interface - a simple Frame! */
	public BuildingView(SimulationController ctl, String title, CommunityModel model) {
		// used for Control callback
		this.control = ctl;
		commuityModel = model;

		// Setup the GUI
		frame = new JFrame(title);
		frame.setSize(ctl.frameX, ctl.frameY); // set the size

		// add this so that hitting the x button will actually end the program
		// the program will continue to run behind the scenes and you might end up with
		// 10+ of them
		// without realizing it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// make it visible
		frame.setVisible(true);
		frame.add(this); // add this class (JPanel) to the JFrame

	}

	// activation of Simulator separated from Constructor
	public void activate() {
		// Timer for animation
		// Argument 1: timerValue is a period in milliseconds to fire event
		// Argument 2:t any class that "implements ActionListener"
		timer = new Timer(control.timerValue, this); // timer constructor
		timer.restart(); // restart or start

		// frame becomes visible
		frame.setVisible(true);
	}

	/* This invoked by Timer per period in milliseconds in timerValue */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Triggers paint call through polymorphism
		repaint();
	}

	/* paint method for drawing the simulation and animation */
	@Override
	public void paint(Graphics g) {

		// tracking total time manually with the time variable
		time += control.timerValue;

		// events
		super.paintComponent(g); // a necessary call to the parent paint method, required for proper screen
									// refreshing
		paintWalls(g);
		control.paintPersons(g); // repaint all objects in simulation

	}

	public void paintWalls(Graphics g) {

		// draws vertical walls
		g.drawImage(commuityModel.walls.get(0).getImage(), commuityModel.walls.get(0).getX(),
				commuityModel.walls.get(0).getY(), null);
		g.drawImage(commuityModel.walls.get(2).getImage(), commuityModel.walls.get(2).getX(),
				commuityModel.walls.get(2).getY(), null);
		g.drawImage(commuityModel.walls.get(4).getImage(), commuityModel.walls.get(4).getX(),
				commuityModel.walls.get(4).getY(), null);
		g.drawImage(commuityModel.walls.get(6).getImage(), commuityModel.walls.get(6).getX(),
				commuityModel.walls.get(6).getY(), null);

		// draws horizontal walls
		g.drawImage(commuityModel.walls.get(1).getImage(), commuityModel.walls.get(1).getX(),
				commuityModel.walls.get(1).getY(), null);
		g.drawImage(commuityModel.walls.get(3).getImage(), commuityModel.walls.get(3).getX(),
				commuityModel.walls.get(3).getY(), null);
		g.drawImage(commuityModel.walls.get(5).getImage(), commuityModel.walls.get(5).getX(),
				commuityModel.walls.get(5).getY(), null);
		g.drawImage(commuityModel.walls.get(7).getImage(), commuityModel.walls.get(7).getX(),
				commuityModel.walls.get(7).getY(), null);

		// sets text color
		g.setColor(Color.BLACK);
		g.setFont(new Font("Roboto", Font.BOLD, 20));

		g.drawString("Sprouts", 610, 50);
		g.drawString("Scripps Medical", 5, 50);
		g.drawString("Board and Brew", 5, 440);
		g.drawString("Mr. M's House", 590, 440);

	}

}