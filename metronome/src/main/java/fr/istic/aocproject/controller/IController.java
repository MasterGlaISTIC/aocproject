package fr.istic.aocproject.controller;


import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.ihm.IiHMController;


public interface IController {

	public void start();
	public void stop();
	public String initBPM();
	public void inc();
	public void dec();
	
	public void display();
	
	public void createViewAdapter(IiHMController ihmController);
	
	public void displayLed1() throws UnsupportedAudioFileException, IOException, LineUnavailableException ;
	public void displayLed2() throws UnsupportedAudioFileException, IOException, LineUnavailableException ;
	public void notifyMetronomeSlidePosition(int position);

}
