package fr.istic.aocproject.adapter;

import fr.istic.aocproject.controller.Controller;

public interface IView {

	void setController(Controller controller);

	void flashLed1();

	void flashLed2();
	
	void start();
	
	void stop();
	
	void inc();
	
	void dec();

}
