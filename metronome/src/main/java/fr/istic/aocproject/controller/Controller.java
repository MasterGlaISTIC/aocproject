package fr.istic.aocproject.controller;

//import java.util.Observable;
//import java.util.Observer;
import javafx.scene.shape.Circle;

import javax.swing.text.View;

import fr.istic.aocproject.ihm.IHMControler;
import fr.istic.aocproject.ihm.Iled;
import fr.istic.aocproject.ihm.Led;
import fr.istic.aocproject.metronomeEngine.ICommand;
import fr.istic.aocproject.metronomeEngine.IMetronomieEngine;
import fr.istic.aocproject.metronomeEngine.MetronomieEngine;




public class Controller implements IController{

	private MetronomieEngine metronomieEngine;
	//private Circle led2;
    //private Iled myLed;
	private ICommand BCmd;
	private ICommand BeCmd;
	private IHMControler view;
	private Led ledAdapter = new Led();

	public Controller() {

		metronomieEngine = new MetronomieEngine();

        //metronomieEngine.addObserver(this);
		//command.setControl(this);
	}

	public void inStart() {
		
		metronomieEngine.setBarCmd(BCmd);
		metronomieEngine.setBeatCmd(BeCmd);
		metronomieEngine.setRuning(true);
		
	}

	public void inStop() {
		metronomieEngine.setRuning(false);
	}

	public String initBPM() {
		return IMetronomieEngine.BPM_INITIAL_VALUE+"";
	}


	public void incBPM() {
		metronomieEngine.incBPM();
	}

	public void decBPM() {
		metronomieEngine.decBPM();

	}

	public String getBPM() {
//		return metronomieEngine.getBpm()+"";
		return("toto");
	}

	public IMetronomieEngine getMetronomieEngine() {
		return metronomieEngine;
	}

	public void setMetronomieEngine(IMetronomieEngine metronomieEngine) {
		this.metronomieEngine = (MetronomieEngine) metronomieEngine;
	}


	public IMetronomieEngine getModel() {
		return metronomieEngine;
	}

//	@Override
//	public void update(Observable o, Object arg) {
//
//		if(o instanceof MetronomieEngine){
//
//			myLed.flash();
//
//		}
//
//	}



	@Override
	public void setLedBar(Iled ledBar) {
		// TODO Auto-generated method stub

	}

	public void flash() {
		ledAdapter.ledflash();
			
	}

	@Override
	public void setLedBeat(Led ledAdpter) {
		// TODO Auto-generated method stub
		
	}


		
	

}
