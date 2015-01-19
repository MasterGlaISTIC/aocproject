package fr.istic.aocproject.ihm;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.controller.Controller;



public  interface IiHMController 
{

	void flashLed1() throws UnsupportedAudioFileException, IOException, LineUnavailableException;

	void flashLed2() throws UnsupportedAudioFileException, IOException, LineUnavailableException ;

	void setController(Controller controller);

	public void notifyMetronomeSlidePosition(int position) ;
	
	void start();

	void stop();

	void inc();

	void dec();
	
}

