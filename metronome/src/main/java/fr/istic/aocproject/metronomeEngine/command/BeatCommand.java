package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

public class BeatCommand implements ICommand{
	

	IController controller;
	
	public void setController(Controller controller){
		System.out.println("5 - Controller initialisation");
		this.controller = controller;
	} 
	
	public BeatCommand(){
		System.out.println("4- Beat initialisation");
	}

	public void execute() {

		controller.displayLed1();

	}


}