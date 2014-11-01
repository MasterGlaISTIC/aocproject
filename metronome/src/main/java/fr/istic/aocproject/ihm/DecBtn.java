
package fr.istic.aocproject.ihm;

import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.ICommand;

public class DecBtn implements IButton{

	Button dec;
	ICommand commandDec;
	
	public DecBtn(Button dec){
		this.dec = dec;
	}
	
	public void setCommand(ICommand parameter) {
		commandDec = parameter;
		commandDec.execute(); 
		
	}

}