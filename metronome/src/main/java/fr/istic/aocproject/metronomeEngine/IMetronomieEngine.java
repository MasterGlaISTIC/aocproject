package fr.istic.aocproject.metronomeEngine;



public  interface IMetronomieEngine 
{
	Integer BPM_INITIAL_VALUE = 120;		
	Integer NTM_INITIAL_VALUE = 4;

	public boolean isRunning() ;

	public int getTempo() ;

	public void setBarCmd(ICommand parameter) ;

	public void setBeatCmd(ICommand parameter) ;

	public void setRuning(boolean parameter) ;
	
	//public int timerepeat();  

	public void setTempo(int parameter) ;

	public void incBPM();

	public void decBPM();

	
	

	



}

