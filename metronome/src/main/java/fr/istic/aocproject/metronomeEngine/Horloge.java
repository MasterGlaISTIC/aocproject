package fr.istic.aocproject.metronomeEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Horloge implements IHorloge {
	
	private Timer timer = new Timer(); 
	private Map<ICommand, TimerTask> tasks = new HashMap<ICommand, TimerTask>();

	@Override
	public void periodicallyActivate(ICommand cmd, double C) {
		TimerTask timerTask = new TimerTask() {
			public void run() {
				cmd.execute();
			}
		};
		timer.scheduleAtFixedRate(timerTask,0,2000);
		
	}

	@Override
	public void descativate(ICommand cmd) {
		tasks.get(cmd).cancel();
		
	}

}
