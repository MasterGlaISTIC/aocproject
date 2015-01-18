package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;

public class StopCommand implements ICommand{
	

	private Controller controller;
	//IMetronomieEngine theMetronome;
	
	public void setController(Controller controller){
		this.controller = controller;
	} 
	
	
	public StopCommand(){
	}

	public void execute() {

		//theMetronome.startCmd();		

		System.out.println("STOP cmd");
		controller.stop();

	}


}
