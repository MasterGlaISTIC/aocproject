package fr.istic.aocproject.metronomeEngine;

//import java.util.Observable;
import java.util.Timer;

public class MetronomieEngine implements IMetronomieEngine {

	// extends Observable
	//private Integer bpm;
	/* nombre de temps dans une mesure */
	private Integer ntm;

	private boolean running;

	Timer timer = new Timer();
	//
	// private List<Observer> observers;

	// private boolean changed;
	private int tempo;
	// horloge
	private Horloge horloge = new Horloge();
	private ICommand BeatCmd ;
	private ICommand BarCmd;

	public MetronomieEngine() {
		super();
		// observers = new ArrayList<Observer>();
		tempo = BPM_INITIAL_VALUE;
		ntm = NTM_INITIAL_VALUE;
	}

//	public void startOrStop() {
//
//		TimerTask timerTask = new TimerTask() {
//			@Override
//			public void run() {
//
//				beatEvent();
//			}
//		};
//		timer.scheduleAtFixedRate(timerTask, 0, timerepeat());
//	}

	public void setRuning(boolean running) {
		this.running = running;
		BarCmd = new BarCmd();
		BeatCmd = new BeatCmd();
		if (running) {
			double delayStep = (60.0 / tempo) * 1000;	
			if(BarCmd == null) System.out.println("BarCmd == null");
			horloge.periodicallyActivate(BarCmd, delayStep);
			horloge.periodicallyActivate(BeatCmd, delayStep);
		} else {
			horloge.descativate(BarCmd);
			horloge.descativate(BeatCmd);
		}
		// startOrStop();
	}

	public void setBeatCmd(ICommand cmd) {
		BeatCmd = cmd;
	}

	public ICommand getBeatCmd() {
		return BeatCmd;
	}

	public void setBarCmd(ICommand cmd) {
		BarCmd = cmd;
	}

	public ICommand getBarCmd() {
		return BarCmd;
	}

	public Horloge getHorloge() {
		return horloge;
	}

	public void setHorloge(Horloge horloge) {
		this.horloge = horloge;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
		if (running) {
			double delaystep = (60.0 / tempo) * 1000;
			horloge.descativate(BarCmd);
			horloge.descativate(BeatCmd);

			horloge.periodicallyActivate(BarCmd, delaystep);
			horloge.periodicallyActivate(BeatCmd, delaystep);
		}
	}

	public int getTempo() {
		return tempo;
	}

	public boolean isRunning() {
		return running;
	}

	 @Override
	 public void incBPM() {
	
	 if (ntm < 7 )
	 ntm++;
	
	 // notifyObservers();
	 }
	
	 @Override
	 public void decBPM() {
	 if(ntm > 2)
	 ntm--;
	 // notifyObservers();
	
	 }

	public Integer getNtm() {
		return ntm;
	}

	public void setNtm(Integer ntm) {
		this.ntm = ntm;
	}


//	public void beatEvent() {
//	if(tempo <= ntm){
//	tempo++;
//	}
//	else{
//	 tempo = 0;
//	}
//	//setChanged();
//	//notifyObservers(tempo);
//	 System.out.println(tempo);
//	}


	

//	public int timerepeat() {
//		// il faut ajouter ici la formule
//		return 2000;
//	}

}
