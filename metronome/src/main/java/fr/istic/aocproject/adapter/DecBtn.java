
package fr.istic.aocproject.adapter;

import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

@SuppressWarnings("restriction")
public class DecBtn implements IButton{


	Button dec;
	ICommand commandDec;
	
	public DecBtn(Button dec){
		this.dec = dec;
	}
	
	
	@Override
	public void setClickCommand(ICommand parameter) {
		commandDec = parameter;
		commandDec.execute(); 
		
	}

}