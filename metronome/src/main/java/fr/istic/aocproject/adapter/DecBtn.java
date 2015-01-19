
package fr.istic.aocproject.adapter;

import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

/**
 * @author amhachi & chaabi
 * This class describes the Dec command 
 */
public class DecBtn implements IButton{


	Button dec;
	ICommand commandDec;
	
	public DecBtn(Button dec){
		this.dec = dec;
	}
	
	/*
	 * Sets and call the execute methode of the Command design pattern 
	 * @param patameter de type ICommand (DecCommand)
	 * @see fr.istic.aocproject.adapter.IButton#setClickCommand(fr.istic.aocproject.metronomeEngine.command.ICommand)
	 */
	
	@Override
	public void setClickCommand(ICommand parameter) {
		commandDec = parameter;
		commandDec.execute(); 
		
	}

}