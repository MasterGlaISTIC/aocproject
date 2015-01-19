package fr.istic.aocproject.controller;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.adapter.IView;
import fr.istic.aocproject.adapter.View;
import fr.istic.aocproject.ihm.IiHMController;
import fr.istic.aocproject.metronomeEngine.IMetronomeEngine;
import fr.istic.aocproject.metronomeEngine.MetronomeEngine;
import fr.istic.aocproject.metronomeEngine.command.BarCommand;
import fr.istic.aocproject.metronomeEngine.command.BeatCommand;

public class Controller implements IController {

	private IMetronomeEngine metronomeEngine;

	private IView view;

	private static IController controller = null;
	
	public static IController getControllerInstance(){
		if(controller == null) controller = new Controller();
		return controller;
	}
	
	private Controller() {
		metronomeEngine = MetronomeEngine.getControllerInstance();
	}
	
	@Override
	public void start() { 
		
		if(view != null)
		view.setController(this);
		
		if (!metronomeEngine.isRunning()) {
			
			BeatCommand beatCommand = new BeatCommand();
			beatCommand.setController(this);
			metronomeEngine.setBeatCmd(beatCommand);
			
			BarCommand barCommand = new BarCommand();
			barCommand.setController(this);
			metronomeEngine.setBarCmd(barCommand);
			
			metronomeEngine.setRunning(true);
		}
	}

	@Override
	public void stop() {
		System.out.println("Stop !");
		metronomeEngine.setRunning(false);
	}

	@Override
	public String initBPM() {
		return IMetronomeEngine.BPM_INITIAL_VALUE + "";
	}

	@Override
	public void inc() {
		metronomeEngine.incNTM();

	}

	@Override
	public void dec() {
		metronomeEngine.decNTM();

	}
	
	@Override
	public void display() {

	}

	@Override
	public void displayLed1() throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		view.flashLed1();
	}

	@Override
	public void displayLed2() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		System.out.println("12- Bar displayLed2");
		view.flashLed2();
	}

	public IMetronomeEngine getMetronomieEngine() {
		return metronomeEngine;
	}

	public void setMetronomieEngine(IMetronomeEngine metronomieEngine) {
		this.metronomeEngine = metronomieEngine;
	}

	public IView getView() {
		return view;
	}


	public void createViewAdapter(IiHMController ihmController) {
		view = new View(ihmController);
	}

	@Override
	public void notifyMetronomeSlidePosition(int position) {
		metronomeEngine.setTempo(position);
		
	}


}
