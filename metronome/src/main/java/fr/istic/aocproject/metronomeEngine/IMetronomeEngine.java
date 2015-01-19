package fr.istic.aocproject.metronomeEngine;

import fr.istic.aocproject.metronomeEngine.command.ICommand;

/*
 * @author amhachi & chaabi
 * Interface of the  Metronome Engine (Model of the application) 
 */

public  interface IMetronomeEngine 
{
		/*
		 * Returns <code>true</code> if the state of the metronome is On
		 */
		public boolean isRunning() ;
		
		/*
		 * Returns the value of tempo 
		 */
		public Integer getTempo() ;
		
		/*
		 * Sets the Bar Command 
		 */
		public void setBarCmd(ICommand parameter) ;
				
		/*
		 * Sets the Beat Command 
		 */
		public void setBeatCmd(ICommand parameter) ;
		
		/*
		 * Sets the State of the Metronome 
		 */
		public void setRunning(boolean parameter) ;
				
		/*
		 * Sets the Tempo value 
		 */
		public void setTempo(int parameter) ;
		
		Integer BPM_INITIAL_VALUE = 30;
		
		Integer NTM_INITIAL_VALUE = 4;
		
		Integer NTM_MIN_VALUE = 2;
		
		Integer NTM_MAX_VALUE = 7;

		/*
		 * increases the NTM value 
		 */
		public void incNTM();

		/*
		 * decreases the NTM value
		 */
		public void decNTM();

		/*
		 * Returns the Bpm value 
		 */
		public String getBPM();

		}

