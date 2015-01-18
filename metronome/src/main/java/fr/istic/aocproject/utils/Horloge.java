package fr.istic.aocproject.utils;

import fr.istic.aocproject.metronomeEngine.command.ICommand;


public interface Horloge {

	/**
	 * Appel periodique de l'operation execute() de cmd, toutes les
	 * perdiodInMiliSeconds, avec une precision d'une milliseconde
	 * 
	 * @param cmd
	 * @param perdiodInSeconds
	 */
	public void periodicallyActivate(ICommand cmd, double perdiodInMiliSeconds);

	/**
	 * Desactivation de la commande
	 */
	public void desactivate(ICommand cmd);
}