package fr.istic.aocproject.ihm;

import fr.istic.aocproject.metronomeEngine.ICommand;


public  interface IButton 
{
		
	public void setCommand(ICommand parameter);
	public ICommand getCommand();
	
}

