package fr.istic.aocproject.metronomeEngine;


public  interface IMetronomieEngine 
{
		 
		public boolean getRunning() ;
				
		public Integer getTempo() ;
			
		public void setBarCmd(ICommand parameter) ;
						
		public void setBeatCmd(ICommand parameter) ;
						
		public void setRuning(boolean parameter) ;
				
		public void setTempo(int parameter) ;
		
		Integer BPM_INITIAL_VALUE = 120;
		
		Integer NTM_INITIAL_VALUE = 4;

		public void incBPM();

		public void decBPM();

		public String getBPM();

		}

