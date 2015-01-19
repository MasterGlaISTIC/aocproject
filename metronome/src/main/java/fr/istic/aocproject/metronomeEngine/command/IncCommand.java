package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

public class IncCommand implements ICommand{
	
	IController controller;

	// IMetronomieEngine theMetronome;

	public void setController(Controller controller){
		this.controller = controller;
	}
	//IMetronomieEngine theMetronome;
	
	public IncCommand(){
		//theMetronome = newMetronome;
	}

	public void execute() {


		controller.inc();	

	}


}