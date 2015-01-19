package fr.istic.aocproject.controller;

import fr.istic.aocproject.adapter.IView;
import fr.istic.aocproject.adapter.View;
import fr.istic.aocproject.ihm.IiHMController;
import fr.istic.aocproject.metronomeEngine.IMetronomeEngine;
import fr.istic.aocproject.metronomeEngine.MetronomeEngine;
import fr.istic.aocproject.metronomeEngine.command.BarCommand;
import fr.istic.aocproject.metronomeEngine.command.BeatCommand;

/**
 * @author amhachi & chaabi
 * This class describes the controller application
 * this is to implement the link
 *  Engine<-->Adapter
 */


public class Controller implements IController {

	private IMetronomeEngine metronomeEngine;

	private IView view;

	private static IController controller = null;
	
	public static IController getControllerInstance(){
		if(controller == null) controller = new Controller();
		return controller;
	}
	
	/*
	 * The Constructor 
	 */
	
	private Controller() {
		metronomeEngine = new MetronomeEngine();
	}
	
	/*
	 * Sets the state of the metronome to true if the metronome is not
	 * running 
	 * @see fr.istic.aocproject.controller.IController#start()
	 */
	
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
	
	/*
	 * Sets the state of the metronome to false 
	 * @see fr.istic.aocproject.controller.IController#stop()
	 */
	@Override
	public void stop() {
		metronomeEngine.setRunning(false);
	}
	
    /*
     * initialization of the BPM 
     * @see fr.istic.aocproject.controller.IController#initBPM()
     */
	@Override
	public String initBPM() {
		return IMetronomeEngine.BPM_INITIAL_VALUE + "";
	}
	
    /*
     * increases the value of NTM
     * @see fr.istic.aocproject.controller.IController#inc()
     */
	@Override
	public void inc() {
		metronomeEngine.incNTM();

	}
	
    /*
     * decreases the value of NTM
     * @see fr.istic.aocproject.controller.IController#dec()
     */
	@Override
	public void dec() {
		metronomeEngine.decNTM();

	}
	
	/*
	 * @see fr.istic.aocproject.controller.IController#display()
	 */
	@Override
	public void display() {

	}
	
	/*
	 * disables and stops the led1
	 * @see fr.istic.aocproject.controller.IController#displayLed1()
	 */

	@Override
	public void displayLed1() {
		view.flashLed1();
	}
	
	/*
	 * disables and stops the led2 
	 * @see fr.istic.aocproject.controller.IController#displayLed2()
	 */

	@Override
	public void displayLed2() {
		view.flashLed2();
	}

	/*
	 * Returns the metronomeEngine Object
	 */
	public IMetronomeEngine getMetronomieEngine() {
		return metronomeEngine;
	}

	/*
	 * Sets the MetronomeEngine 
	 * @param metronomieEngine 
	 */
	public void setMetronomieEngine(IMetronomeEngine metronomieEngine) {
		this.metronomeEngine = metronomieEngine;
	}

	/*
	 * Returns the View
	 */
	public IView getView() {
		return view;
	}

	/*
	 * create view adapter 
	 * @param ihmControler the FXML controller 
	 * @see fr.istic.aocproject.controller.IController#createViewAdapter(fr.istic.aocproject.ihm.IiHMController)
	 */
	public void createViewAdapter(IiHMController ihmController) {
		view = new View(ihmController);
	}


}
