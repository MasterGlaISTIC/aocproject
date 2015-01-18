package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

public class BarCommand implements ICommand {

	IController controller;

	// IMetronomieEngine theMetronome;

	public void setController(Controller controller){
		System.out.println("8- Controller initialisation Bar");
		this.controller = controller;
	}
	public BarCommand() {
		System.out.println("7 - Bar initialisation");
		
	}

	public void execute() {
		System.out.println("11- Bar execute");
		System.out.println("Bar cmd");
		controller.displayLed2();

	}

}