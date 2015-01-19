package fr.istic.aocproject.metronomeEngine.command;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

/*
 *  @author chaabi & amhachi
 *  Classe of the bar concret command   
 */

public class BarCommand implements ICommand {

	IController controller; 

	public void setController(Controller controller){

		this.controller = controller;
	}
	public BarCommand() {

	}
	
	/*
	 *Execute bar command  
	 *display led 2
	 */

	public void execute() {

		
		try {
			controller.displayLed2();
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
