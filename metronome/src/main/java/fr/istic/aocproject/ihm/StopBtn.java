package fr.istic.aocproject.ihm;


import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.ICommand;


public class StopBtn implements IButton
{
	Button stop;
	ICommand commandStop;
	
	public StopBtn(Button stop){
		this.stop = stop;
	}

	
	
	public void setCommand(ICommand parameter) {
		commandStop = parameter;
		commandStop.execute(); 


	}
	

	
}

