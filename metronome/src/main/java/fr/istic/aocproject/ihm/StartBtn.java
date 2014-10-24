package fr.istic.aocproject.ihm;


import fr.istic.aocproject.metronomeEngine.ICommand;
import javafx.scene.control.Button;


@SuppressWarnings("restriction")
public class StartBtn implements IButton
{
	Button start;
	ICommand commandStart;
	
	public StartBtn(Button start){
		this.start = start;
	}

	
	
	public void setCommand(ICommand parameter) {
		commandStart = parameter;
	}

	
}

