package fr.istic.aocproject.metronomeEngine;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;


public class StartCommand implements ICommand
{
	
	
	//IMetronomieEngine theMetronome;
	
	 Controller control = new Controller();
	 
	public Controller getControl() {
		return control;
	}

	public void setControl(IController controller) {
		this.control = (Controller) controller;
	}	

	public StartCommand(){
		
	}

	public void execute() {
		control.inStart();
			
	}

}

