package fr.istic.aocproject.adapter;

import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

public class IncBtn implements IButton{

	Button inc;
	ICommand commandInc;
	
	public IncBtn(Button inc){
		this.inc = inc;
	}
	

	@Override
	public void setClickCommand(ICommand parameter) {
		commandInc = parameter;
		commandInc.execute(); 
		
	}

}
