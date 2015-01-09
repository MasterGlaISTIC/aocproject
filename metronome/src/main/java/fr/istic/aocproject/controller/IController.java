package fr.istic.aocproject.controller;

import javafx.scene.shape.Circle;
import fr.istic.aocproject.ihm.Iled;
import fr.istic.aocproject.ihm.Led;
import fr.istic.aocproject.metronomeEngine.IMetronomieEngine;


public interface IController {

	public void inStart();
	public void inStop();
	public String initBPM();
	public void incBPM();
	public void decBPM();
	public String getBPM();

	public void setLedBar(Iled ledBar);
	
    
    public IMetronomieEngine getModel();
	
	public void setLedBeat(Led ledAdpter);


}
