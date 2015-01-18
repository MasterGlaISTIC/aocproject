package fr.istic.aocproject.adapter;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.ihm.IiHMController;

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

	@Override
	public void flashLed1() {
		ihm.flashLed1();		
	}

	@Override
	public void flashLed2() {
		ihm.flashLed2();
	}

	@Override
	public void start() {
		ihm.start();
	}

	@Override
	public void stop() {
		ihm.stop();
	}

	@Override
	public void inc() {
		ihm.inc();
	}

	@Override
	public void dec() {
		ihm.dec();
	}
	
}
