package fr.istic.aocproject.adapter;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.controller.Controller;

public interface IView {

	void setController(Controller controller);

	void flashLed1() throws UnsupportedAudioFileException, IOException, LineUnavailableException ;

	void flashLed2() throws UnsupportedAudioFileException, IOException, LineUnavailableException ;
	
	void start();
	
	void stop();
	
	void inc();
	
	void dec();

}
