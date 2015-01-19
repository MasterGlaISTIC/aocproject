package fr.istic.aocproject.v2.adapter;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;
import fr.istic.aocproject.ihm.IHMController;
import fr.istic.aocproject.ihm.IiHMController;

public class ConcreteAdapter implements Adapter{

	
	private IController controleur;
	private IHMController ihm;

	
	
	@Override
	public void flashLed1() throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		ihm.flashLed1();
		
	}

	@Override
	public void flashLed2() throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		ihm.flashLed2();
		
	}

	@Override
	public void setController(Controller controller) {
		this.controleur = controller;
		
	}

	@Override
	public void start() {
		controleur.start();
		
	}

	@Override
	public void stop() {
		controleur.stop();
		
	}

	@Override
	public void inc() {
		controleur.inc();
		
	}

	@Override
	public void dec() {
		controleur.dec();
		
	}

	@Override
	public String initBPM() {
		
		return controleur.initBPM();
	}

	@Override
	public void display() {
		controleur.display();
		
	}

	@Override
	public void createViewAdapter(IiHMController ihmController) {
		controleur.createViewAdapter(ihmController);
		
	}

	@Override
	public void displayLed1() throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		ihm.flashLed1();
		
	}

	@Override
	public void displayLed2() throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		ihm.flashLed2();
		
	}

	@Override
	public void lireMateriel() {
		
		
	}

	@Override
	public void notifyMetronomeSlidePosition(int position) {
		// TODO Auto-generated method stub
		
	}

}
