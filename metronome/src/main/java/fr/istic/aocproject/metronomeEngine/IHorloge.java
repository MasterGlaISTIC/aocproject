package fr.istic.aocproject.metronomeEngine;

public interface IHorloge {
	
	
	public void periodicallyActivate(ICommand cmd,double periodInMiliSeconds);
	
	public void descativate(ICommand cmd);

}
