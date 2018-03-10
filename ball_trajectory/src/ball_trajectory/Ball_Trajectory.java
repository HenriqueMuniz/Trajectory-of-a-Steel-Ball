package ball_trajectory;

import ball_trajectory_Classes.Decay;
import ball_trajectory_Classes.Euler;
import ball_trajectory_interfaces.ODESolver;

import javax.swing.*;

import org.opensourcephysics.display.DatasetManager;
import org.opensourcephysics.display.DrawingFrame;
import org.opensourcephysics.display.PlottingPanel;
//import org.opensourcephysics.numerics.Euler;
//import org.opensourcephysics.numerics.ODESolver;

import org.opensourcephysics.sip.ch07.*;

public class Ball_Trajectory {
	public static void main(String[] args) {
		PlottingPanel plottingPanel = new PlottingPanel("Time","Number", "Number versus Time");
		DrawingFrame plottingFrame = new DrawingFrame(plottingPanel);
		DatasetManager datasetCollection = new DatasetManager();
		plottingPanel.addDrawable(datasetCollection); // add dataset collection to plotting panel
		Decay decay = new Decay(); // object that contains decay equations
		ODESolver odeSolver = new Euler(decay); // use Euler method to solve decay equations
		odeSolver.setStepSize (0.1);
		for (int i = 0; i < 100; i++) {
			// append time and particle number
		datasetCollection .append(0, decay.state [1], decay.state [0]);
			odeSolver.step ();
		}
		plottingPanel.repaint ();
	}
}
