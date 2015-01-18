package fr.istic.aocproject.ihm;

import fr.istic.aocproject.controller.Controller;



public  interface IiHMController 
{

	void flashLed1();

	void flashLed2();

	void setController(Controller controller);

	void start();

	void stop();

	void inc();

	void dec();
	
}

