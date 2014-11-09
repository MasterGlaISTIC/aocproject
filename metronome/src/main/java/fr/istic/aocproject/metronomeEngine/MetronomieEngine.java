package fr.istic.aocproject.metronomeEngine;




public class MetronomieEngine implements IMetronomieEngine
{
	
	private Integer bpm;
	
	/* nombre de temps dans une mesure */
	private Integer ntm;
	
	private boolean running;
	
	public MetronomieEngine(){
		super();
		bpm = BPM_INITIAL_VALUE;
		ntm = NTM_INITIAL_VALUE;
		
	}

	public boolean getRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	public Integer getTempo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBarCmd(ICommand parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setBeatCmd(ICommand parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setRuning(boolean parameter) {
		setRunning(parameter);
		
	}

	public void setTempo(int parameter) {
		// TODO Auto-generated method stub
		
	}

	public Integer getBpm() {
		return bpm;
	}

	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void incBPM() {
		if (ntm < 7 )
		ntm++;
		}

	@Override
	public void decBPM() {
		if(ntm > 2)
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

