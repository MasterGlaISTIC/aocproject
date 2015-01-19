package fr.istic.aocproject.adapter;


import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

/*
 * @author amhachi & chaabi
 * Class of the  Stop adpter  
 */

public class StopBtn implements IButton
{
	Button stop;
	ICommand commandStop;
	
	public StopBtn(Button stop){
		this.stop = stop;
	}

	/*
	 * @see fr.istic.aocproject.adapter.IButton#setClickCommand(fr.istic.aocproject.metronomeEngine.command.ICommand)
	 */
	
	public void setClickCommand(ICommand parameter) {
		commandStop = parameter;
	}	
}

