package fr.istic.aocproject.adapter;

import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

/**
 * @author amhachi & chaabi
 * This class describes the increment button 
 */
public class IncBtn implements IButton{

	Button inc;
	ICommand commandInc;
	
	public IncBtn(Button inc){
		this.inc = inc;
	}
	
	/*
	 * Sets the Command and call the execute methode of the Command design pattern 
	 * @see fr.istic.aocproject.adapter.IButton#setClickCommand(fr.istic.aocproject.metronomeEngine.command.ICommand)
	 */

	@Override
	public void setClickCommand(ICommand parameter) {
		commandInc = parameter;
		commandInc.execute(); 
		
	}

}
