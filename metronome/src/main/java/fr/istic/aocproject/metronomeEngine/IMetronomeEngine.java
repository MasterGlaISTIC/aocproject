package fr.istic.aocproject.metronomeEngine;

import fr.istic.aocproject.metronomeEngine.command.ICommand;


public  interface IMetronomeEngine 
{
		 
		public boolean isRunning() ;
				
		public Integer getTempo() ;
		
		public Integer getNtm(); 
		
		public void setNtm(Integer ntm); 
			
		public void setBarCmd(ICommand parameter) ;
						
		public void setBeatCmd(ICommand parameter) ;
						
		public void setRunning(boolean parameter) ;
				
		public void setTempo(int parameter) ;
		
		Integer BPM_INITIAL_VALUE = 30;
		
		Integer NTM_INITIAL_VALUE = 4;
		
		Integer NTM_MIN_VALUE = 2;
		
		Integer NTM_MAX_VALUE = 7;
		
		public static final double BPM_MIN_VALUE = 0;
		
		public static final double BPM_MAX_VALUE = 200;

		public void incNTM();

		public void decNTM();

		public String getBPM();

		}

