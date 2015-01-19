package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

/*
 *  @author amhachi & chaabi
 *  Command Interface 
 */

public class BeatCommand implements ICommand{
	

	IController controller;
	
	public void setController(Controller controller){
		this.controller = controller;
	} 
	
	public BeatCommand(){
	}

	public void execute() {

		controller.displayLed1();

	}


}