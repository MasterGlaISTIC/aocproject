package fr.istic.aocproject.ihm;

import fr.istic.aocproject.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Led implements Iled {

	Circle circle;
	
	@FXML
	private Circle ledd;
	IHMControler view = new IHMControler();
	private Controller controller;
	public Led() {		
		super();
		
	
	}

	@Override
	public void ledflash(){
		
		System.out.println("led test");
		
		//led.setFill(javafx.scene.paint.Color.RED);
		//System.out.println("test");
		//Transition
	}


}
