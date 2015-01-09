package fr.istic.aocproject.controller;


import fr.istic.aocproject.ihm.IiHMController;


public interface IController {

	public void start();
	public void stop();
	public String initBPM();
	public void inc();
	public void dec();
	
	public void display();
	
	public void createViewAdapter(IiHMController ihmController);
	
	public void displayLed1();
	public void displayLed2();

}
