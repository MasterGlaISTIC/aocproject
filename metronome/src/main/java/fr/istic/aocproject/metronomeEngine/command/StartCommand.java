package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;


public class StartCommand implements ICommand
{
	
	private Controller controller;
	//IMetronomieEngine theMetronome;
	
	public void setController(Controller controller){
		this.controller = controller;
	} 
	
	public StartCommand(){
	}

	public void execute() {

		//theMetronome.startCmd();		

		System.out.println("2- CMD start");
		controller.start();
	}

}

