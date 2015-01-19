package fr.istic.aocproject.utils;

import fr.istic.aocproject.metronomeEngine.command.ICommand;


public interface Horloge {

	/**
	 * Periodic call the operation execute () cmd, all
  	 * perdiodInMiliSeconds, with an accuracy of one millisecond
	 * 
	 * @param cmd
	 * @param perdiodInSeconds
	 */
	public void periodicallyActivate(ICommand cmd, double perdiodInMiliSeconds);

	/**
	 * Command desactivation
	 */
	public void desactivate(ICommand cmd);
}