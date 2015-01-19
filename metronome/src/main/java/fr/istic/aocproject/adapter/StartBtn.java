package fr.istic.aocproject.adapter;


import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

/*
 * @author amhachi & chaabi
 * Class of the  Start adpter  
 */

public class StartBtn implements IButton
{
	Button start;
	ICommand commandStart;
	
	public StartBtn(Button start){
		this.start = start;
	}

	/*
	 * @see fr.istic.aocproject.adapter.IButton#setClickCommand(fr.istic.aocproject.metronomeEngine.command.ICommand)
	 */
	
	public void setClickCommand(ICommand parameter) {
		commandStart = parameter;
	}	

	
}

