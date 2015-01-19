package fr.istic.aocproject.ihm;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.controller.Controller;

/*
 * @author amhachi & chaabi
 * Interface of the  FXML Controller 
 */


public  interface IiHMController 
{

	/*
	 *  issue a flash the led 1 
	*/
	void flashLed1() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	 
		/*
	     *  issue a flash the led 2 
	    */
	void flashLed2() throws UnsupportedAudioFileException, IOException, LineUnavailableException ;


	/*
	 * Sets the Controller Object 
	 * @param controller controller architecture
	 */
	void setController(Controller controller);


	public void notifyMetronomeSlidePosition(int position) ;
	

	/*
	 * active pressure issuance of clicks each time and eclaire of the led 
	 */

	void start();

	/*
	 * disables sound and light signals
	 */
	void stop();
	
	/*
	 * disables sound and light signals for each pressure increases the number 
	 * of beats in a measure of a unit
	 */
	void inc();

	/*
	 * decreases the number of beats in a measure unit
	 */
	void dec();
	
}

