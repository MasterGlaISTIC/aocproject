package fr.istic.aocproject.metronomeEngine.command;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;

/*
 *  @author amhachi & chaabi
 *  Command Interface 
 */

public class BeatCommand implements ICommand{
	

	IController controller;
	
	public void setController(Controller controller){
		this.controller = controller;
	} 
	
	public BeatCommand(){
	}

	public void execute() {

		try {
			controller.displayLed1();
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
