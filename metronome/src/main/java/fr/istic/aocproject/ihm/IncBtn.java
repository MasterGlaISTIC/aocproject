package fr.istic.aocproject.ihm;

import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.ICommand;


public class IncBtn implements IButton{

	Button inc;
	ICommand commandInc;

	public IncBtn(Button inc){
		this.inc = inc;
	}

	public void setCommand(ICommand parameter) {
		commandInc = parameter;
		commandInc.execute(); 

	}

	@Override
	public ICommand getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
