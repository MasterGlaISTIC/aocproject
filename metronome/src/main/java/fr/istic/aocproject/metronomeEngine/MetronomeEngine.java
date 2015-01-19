package fr.istic.aocproject.metronomeEngine;

import fr.istic.aocproject.metronomeEngine.command.ICommand;
import fr.istic.aocproject.utils.Horloge;
import fr.istic.aocproject.utils.HorlogeImpl;

/**
 * @author amhachi & chaabi
 * This class describes the Model of Metronome Engine application
 */


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

	static IMetronomeEngine instance = null;
	

	/*
	 * initialize the bpm ntm and 
	 * instantiate the horlogeBar and horlogeBeat Object
	 */
	public MetronomeEngine(){
		super();
		bpm = BPM_INITIAL_VALUE;
		ntm = NTM_INITIAL_VALUE;



		initHorloge();

	}

	private void initHorloge() {

		// Set up
		horlogeBar = new HorlogeImpl();
		horlogeBeat = new HorlogeImpl();

	}


	/*
	 * Returns <code>true</code> if the state of the metronome is On
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#isRunning()
	 */

	@Override
	public boolean isRunning() {

		return running;
	}
	
	/*
	 * Returns the  bpm 
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#getTempo()
	 */
	public Integer getTempo() {
		return bpm;
	}
	
	/*
	 * Sets the barCmd 
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#setBarCmd(fr.istic.aocproject.metronomeEngine.command.ICommand)
	 */
 
	public void setBarCmd(ICommand parameter) {
		barCmd = parameter;

	}

	/*
	 * Sets the beat Command 
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#setBeatCmd(fr.istic.aocproject.metronomeEngine.command.ICommand)
	 */
	public void setBeatCmd(ICommand parameter) {
		beatCmd = parameter;

	}
	
	/*
	 * Sets the state of the metronome 
	 * @param running the state (boolean)of the metronome 
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#setRunning(boolean)
	 */
	public void setRunning(boolean running) {

		this.running = running;
		if (running) {
			double delayStep = (60.0 / bpm) * 1000;
			horlogeBeat.periodicallyActivate(beatCmd, delayStep);
			horlogeBar.periodicallyActivate(barCmd, delayStep * ntm);

		} else {
			horlogeBar.desactivate(barCmd);
			horlogeBeat.desactivate(beatCmd);
		}

	}
    
	/*
	 * Sets the tempo 
	 * @param bmp the value of the tempo 
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#setTempo(int)
	 */
	
	public void setTempo(int bmp) {
		this.bpm = bmp;

		// restart of the metronome
		initHorloge();

		setRunning(false);
		setRunning(true);

	}
	
	/*
	 * Returns  the bpm
	 */

	public Integer getBpm() {
		return bpm;
	}

	/*
	 * Sets the Bpm 
	 */
	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}

	/*
	 * increases the number of NTM
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#incNTM()
	 */

	@Override
	public void incNTM() {
		if (ntm < NTM_MAX_VALUE) {
			ntm++;

			// restart of the metronome
			initHorloge();

			setRunning(false);
			setRunning(true);
		}
	}

	/*
	 * decreases the value of NTM
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#decNTM()
	 */
	@Override
	public void decNTM() {
		if (ntm > NTM_MIN_VALUE) {
			ntm--;
			// restart of the metronome
			initHorloge();

			setRunning(false);
			setRunning(true);
		}
	}

	/*
	 * Returns the value of Bpm
	 * @see fr.istic.aocproject.metronomeEngine.IMetronomeEngine#getBPM()
	 */
	@Override
	public String getBPM() {
		return bpm + "";

	}


	@Override

	/*
	 * Returns the value of Ntm
	 */

	public Integer getNtm() {
		return ntm;
	}


	@Override

	
	/*
	 * Sets the value of the Ntm
	 */

	public void setNtm(Integer ntm) {
		this.ntm = ntm;
		// restart of the metronome
		initHorloge();

		setRunning(false);
		setRunning(true);
	}

	public static IMetronomeEngine getControllerInstance() {

		if(instance == null) instance = new MetronomeEngine();
		return instance;
	}

}
