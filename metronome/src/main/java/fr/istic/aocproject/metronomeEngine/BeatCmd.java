package fr.istic.aocproject.metronomeEngine;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.ihm.IHMControler;
import fr.istic.aocproject.ihm.Led;

public class BeatCmd implements ICommand {
	
	
	
	public MetronomieEngine metronome;
	private Controller control = new Controller();
	private Led ledAdapter = new Led();
	

	public Controller getControl() {
		return control;
	}


	public void setControl(Controller control) {
		this.control = control;
	}


	@Override
	public void execute() {
		//ledAdapter.flash();
		control.flash();
	}

}
