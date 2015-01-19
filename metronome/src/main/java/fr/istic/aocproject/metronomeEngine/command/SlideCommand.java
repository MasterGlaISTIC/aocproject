package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

public class SlideCommand implements ICommand{

	IController controller;
	private int position = 0;
	

	public void setController(Controller controller){
		this.controller = controller;
	}
	
	
	public SlideCommand(){
		
	}

	public void execute() {

		controller.notifyMetronomeSlidePosition(position);

	}

	
	public void setPosition(int position) {
		this.position = position;
		
	}


}
