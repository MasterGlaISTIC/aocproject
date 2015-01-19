package fr.istic.aocproject.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import fr.istic.aocproject.metronomeEngine.command.ICommand;

@SuppressWarnings("restriction")
public class HorlogeImpl implements Horloge {

	private Timer timer = new Timer();
	private Map<ICommand, TimerTask> tasks = new HashMap<ICommand, TimerTask>();

	public void periodicallyActivate(final ICommand cmd,
			double perdiodInMiliSeconds) {
		TimerTask task = new TimerTask() {
			
			public void run() {
				Platform.runLater(new Runnable() {
				       public void run() {
				    	   cmd.execute();
				      }
				    });
				}
		};
		if (cmd != null)
			timer.schedule(task, 0, (long) perdiodInMiliSeconds);
		
		tasks.put(cmd, task);
	}

	public void desactivate(ICommand cmd) {
		if(!tasks.isEmpty())
		tasks.get(cmd).cancel();
	}
}
