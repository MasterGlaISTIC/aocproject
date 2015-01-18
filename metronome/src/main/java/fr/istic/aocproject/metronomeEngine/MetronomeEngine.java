package fr.istic.aocproject.metronomeEngine;

import fr.istic.aocproject.metronomeEngine.command.ICommand;
import fr.istic.aocproject.utils.Horloge;
import fr.istic.aocproject.utils.HorlogeImpl;




public class MetronomeEngine implements IMetronomeEngine
{
	
	private Integer bpm;
	
	/* nombre de temps dans une mesure */
	private Integer ntm;
	
	private Horloge horlogeBar;
	private Horloge horlogeBeat;
	
	private boolean running;
	
	private ICommand barCmd;
	private ICommand beatCmd;
	
	public MetronomeEngine(){
		super();
		bpm = BPM_INITIAL_VALUE;
		ntm = NTM_INITIAL_VALUE;
		
		horlogeBar = new HorlogeImpl();
		horlogeBeat= new HorlogeImpl();
		
		
		}

	
	@Override
	public boolean isRunning() {
		
		return running;
	}

	public Integer getTempo() {
		return bpm;
	}

	public void setBarCmd(ICommand parameter) {
		barCmd = parameter;
		
	}

	public void setBeatCmd(ICommand parameter) {
		beatCmd = parameter;
		
	}

	public void setRunning(boolean running) {
		
		System.out.println("9- Running");
		this.running = running;
		if (running) {
			System.out.println("SetRunning : true");
			double delayStep = (60.0 / bpm) * 1000;
			horlogeBeat.periodicallyActivate(beatCmd, delayStep);
			horlogeBar.periodicallyActivate(barCmd, delayStep*ntm);
			
		} else {
			horlogeBar.desactivate(barCmd);
			horlogeBeat.desactivate(beatCmd);
		}
		
	}

	public void setTempo(int bmp) {
		this.bpm = bmp;
		
	}

	public Integer getBpm() {
		return bpm;
	}

	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}




	@Override
	public void incNTM() {
		if (ntm < NTM_MAX_VALUE )
		ntm++;
		}

	@Override
	public void decNTM() {
		if(ntm > NTM_MIN_VALUE)
		ntm--;
		
	}

	@Override
	public String getBPM() {
		return bpm+"";
		
	}

	public Integer getNtm() {
		return ntm;
	}

	public void setNtm(Integer ntm) {
		this.ntm = ntm;
	}


}

