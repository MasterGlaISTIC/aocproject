package fr.istic.aocproject.metronomeEngine;




public class StartCommand implements ICommand
{
	
	
	IMetronomieEngine theMetronome;
	
	public StartCommand(IMetronomieEngine newMetronome){
		theMetronome = newMetronome;
	}

	public void execute() {
		theMetronome.startCmd();		
	}

}

