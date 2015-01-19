package fr.istic.aocproject.controller;


import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.ihm.IiHMController;

/*
 * @author amhachi & chaabi
 * Interface of the  Controller application 
 */


public interface IController {

	/*
	 * Sets the state of the metronome to true if the metronome is not
	 * running 
	 */
	public void start();
	
	/*
	 * Sets the state of the metronome to false if the metronome is running 
	 */
	public void stop();
	
	/*
	 * initialization of the BPM 
	 */
	public String initBPM();
	
	/*
	 * Increases the number of NTM
	 */
	public void inc();
	
	/*
	 * decreases the number NTM
	 */
	public void dec();

	
	public void display();
	
	/*
	 * create view adapter 
	 */

	public void createViewAdapter(IiHMController ihmController);
	

	/*
	 * disables and stops the led1 
	 */
	public void displayLed1() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	/*
	 * disables and stops the led2
	 */
	public void displayLed2() throws UnsupportedAudioFileException, IOException, LineUnavailableException;

	void notifyMetronomeSlidePosition(int position);


}
