
package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

public class DecCommand implements ICommand{
	
	IController controller;

	// IMetronomieEngine theMetronome;

	public void setController(Controller controller){
		this.controller = controller;
	}
	//IMetronomieEngine theMetronome;
	
	public DecCommand(){
		//theMetronome = newMetronome;
	}

	public void execute() {

		//theMetronome.startCmd();		

		System.out.println("dec !!!");
		controller.dec();

	}


}