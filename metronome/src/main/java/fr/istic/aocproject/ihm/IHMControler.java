package fr.istic.aocproject.ihm;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


/**
 * 
 * 
 * 
 */

@SuppressWarnings("restriction")
public class IHMControler implements IiHMControler, Initializable
{
	
	
	@FXML
	Button start;
	
	private IButton startBtn;
	
	public IHMControler(){
		super();
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		Logger.getGlobal().info(
                String.format("Initialized with a button start",
                        start.toString()));
		
		
		setStartBtn(new StartBtn(start));
	}


	public IButton getStartBtn() {
		return startBtn;
	}


	public void setStartBtn(IButton startBtn) {
		this.startBtn = startBtn;
	}


	
	
	

}

