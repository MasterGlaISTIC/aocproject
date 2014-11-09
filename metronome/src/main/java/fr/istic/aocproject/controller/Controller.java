package fr.istic.aocproject.controller;

import fr.istic.aocproject.metronomeEngine.IMetronomieEngine;
import fr.istic.aocproject.metronomeEngine.MetronomieEngine;

public class Controller implements IController {

	private IMetronomieEngine metronomieEngine;

	public Controller() {
		metronomieEngine = new MetronomieEngine();
	}

	@Override
	public void inStart() {
		System.out.println("Start !");
		metronomieEngine.setRuning(true);
	}

	@Override
	public void inStop() {
		System.out.println("Stop !");
		metronomieEngine.setRuning(false);
	}

	@Override
	public String initBPM() {
		return IMetronomieEngine.BPM_INITIAL_VALUE+"";
	}


	@Override
	public void incBPM() {
		metronomieEngine.incBPM();
		
	}

	@Override
	public void decBPM() {
		metronomieEngine.decBPM();
		
	}

	@Override
	public String getBPM() {
		return metronomieEngine.getBPM();
	}
	
	public IMetronomieEngine getMetronomieEngine() {
		return metronomieEngine;
	}

	public void setMetronomieEngine(IMetronomieEngine metronomieEngine) {
		this.metronomieEngine = metronomieEngine;
	}


}
