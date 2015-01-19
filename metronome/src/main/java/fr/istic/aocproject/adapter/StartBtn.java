package fr.istic.aocproject.adapter;


import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

@SuppressWarnings("restriction")
public class StartBtn implements IButton
{
	Button start;
	ICommand commandStart;
	
	public StartBtn(Button start){
		this.start = start;
	}

	
	
	public void setClickCommand(ICommand parameter) {
		commandStart = parameter;
	}	

	
}

