package fr.istic.aocproject.adapter;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.ihm.IiHMController;

/**
 * the IHM 
 * @author amhachi & chaabi
 * @version 1.0 2015-01-10 T 20:00
 */
public class View implements IView{

	private IiHMController ihm;
	
	private IButton start;
	private IButton stop;
	private IButton inc;
	private IButton dec;
	
	private ILed led1;
	private ILed led2;
	
	public View() {
	}

	public View(IiHMController ihm) {
		this.ihm = ihm;
	}

	@Override
	public void setController(Controller controller) {
		ihm.setController(controller);
	}
	
	/*
	 * issue a flash the led 1
	 * @see fr.istic.aocproject.adapter.IView#flashLed1()
	 */
	@Override
	public void flashLed1() {
		ihm.flashLed1();		
	}

	/*
	 * issue a flash the led 2
	 * @see fr.istic.aocproject.adapter.IView#flashLed2()
	 */
	@Override
	public void flashLed2() {
		ihm.flashLed2();
	}
	
	/*
	 * start the metronome 
	 * @see fr.istic.aocproject.adapter.IView#start()
	 */
	@Override
	public void start() {
		ihm.start();
	}

	/*
	 * Stop the metronome
	 * @see fr.istic.aocproject.adapter.IView#stop()
	 */
	@Override
	public void stop() {
		ihm.stop();
	}
	
	/*
	 * incress the number of beats in a measure unit
	 * @see fr.istic.aocproject.adapter.IView#inc()
	 */

	@Override
	public void inc() {
		ihm.inc();
	}
	/*
	 * decreases the number of beats in a measure unit
	 * @see fr.istic.aocproject.adapter.IView#dec()
	 */

	@Override
	public void dec() {
		ihm.dec();
	}
	
}
