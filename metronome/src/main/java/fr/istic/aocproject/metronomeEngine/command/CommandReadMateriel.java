package fr.istic.aocproject.metronomeEngine.command;

import fr.istic.aocproject.controller.IController;
import fr.istic.aocproject.v2.adapter.Adapter;

public class CommandReadMateriel implements ICommand{

	private IController controleur;
	public CommandReadMateriel(IController c) {
	this.controleur = c;
	}
	@Override
	public void execute() {
		((Adapter)controleur).lireMateriel();
	}
	/**
	* @return le contrôleur
	*/
	public IController getController() {
	return controleur;
	}

}
