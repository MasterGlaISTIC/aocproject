
package fr.istic.aocproject.adapter;

import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

@SuppressWarnings("restriction")
public class SliderAdapter implements IButton{


	Button dec;
	ICommand commandDec;
	
	public SliderAdapter(Button dec){
		this.dec = dec;
	}
	
	
	@Override
	public void setClickCommand(ICommand parameter) {
		commandDec = parameter;
		commandDec.execute(); 
		
	}

}