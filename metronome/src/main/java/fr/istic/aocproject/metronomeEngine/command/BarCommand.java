package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

/*
 *  @author chaabi & amhachi
 *  Classe of the bar concret command   
 */

public class BarCommand implements ICommand {

	IController controller; 

	public void setController(Controller controller){
		this.controller = controller;
	}
	public BarCommand() {

	}
	
	/*
	 *Execute bar command  
	 *display led 2
	 */

	public void execute() {
		controller.displayLed2();
	}

}