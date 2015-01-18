package fr.istic.aocproject.adapter;


import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

public class StopBtn implements IButton
{
	Button stop;
	ICommand commandStop;
	
	public StopBtn(Button stop){
		this.stop = stop;
	}

	
	
	public void setClickCommand(ICommand parameter) {
		commandStop = parameter;
	}	
}

