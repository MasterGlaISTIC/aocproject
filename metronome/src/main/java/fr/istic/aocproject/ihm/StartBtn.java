package fr.istic.aocproject.ihm;


import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.ICommand;
import fr.istic.aocproject.metronomeEngine.StartCommand;


public class StartBtn implements IButton
{
	Button start;
	ICommand commandStart;
	
	public StartBtn(Button start){
		this.start = start;
		commandStart = new StartCommand();
	}

	public StartBtn() {
	}

	public void setCommand(ICommand parameter) {
		commandStart = parameter;
	}

	@Override
	public ICommand getCommand() {
		return commandStart;
	}




	
}

