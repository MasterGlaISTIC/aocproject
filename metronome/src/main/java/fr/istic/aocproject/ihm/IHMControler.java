package fr.istic.aocproject.ihm;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;
import fr.istic.aocproject.metronomeEngine.StartCommand;


public class IHMControler implements IiHMControler, Initializable {

	@FXML
	private Button start;

	@FXML
	private Button stop;

	@FXML
	private Button inc;

	@FXML
	private Button dec;

	@FXML
	private TextField textfield;

	@FXML
	private Circle led2;

	@FXML
	private Slider slider;

	//le controlleur 
	private IController controller;
	private IButton startBtn;
	private IButton stopBtn;
	private IButton incBtn;
	private IButton decBtn;

	//led adapter 
	private Led ledAdpter;

	public IHMControler() {

		//this.controller = controller;
		controller = new Controller();
		//model.register(this); */
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Logger.getGlobal().info(String.format("Initialized with a button start",start.toString()));
		ledAdpter = new Led();
		// BPM Initialisation
		//textfield.setText(String.valueOf(controller.initBPM()));
		setStartBtn(new StartBtn(start));
		setStopBtn(new StopBtn(stop));
		setIncBtn(new IncBtn(inc));
		setDecBtn(new DecBtn(dec));

		// ajout d'adapter pour le led 
		controller.setLedBeat(ledAdpter);
		
		StartCommand startCmd = new StartCommand(); ;
		start.setOnAction((e) -> {
			
			startCmd.setControl(controller);
			//startBtn.getCommand().execute();
			//startBtn.setCommand(new StartCommand());
//			controller.inStart();
			startCmd.execute();
			//led.setFill(javafx.scene.paint.Color.RED);
			
			
		});
		stop.setOnAction((e) -> {
			//stopBtn.getCommand().execute();
			//stopBtn.setCommand(new StartCommand());
		});

//		inc.setOnAction((e) -> {
//			incBtn.setCommand(new IncCommand());
//			controller.incBPM();
//			textfield.setText(controller.getBPM());
//		});
//
//		dec.setOnAction((e) -> {
//			decBtn.setCommand(new DecCommand());
//			controller.decBPM();
//			textfield.setText(controller.getBPM());
//		});

		// Slider
		slider.setMin(0);
		slider.setMax(200);
		slider.setValue(120);
		slider.valueProperty().addListener((ov,old_val,new_val) -> {
			textfield.setText((int)new_val.doubleValue()+"");
		});		
	}


	public IButton getStartBtn() {
		return startBtn;
	}

	public void setStartBtn(IButton startBtn) {
		this.startBtn = startBtn;
	}

	public IButton getStopBtn() {
		return stopBtn;
	}

	public void setStopBtn(IButton stopBtn) {
		this.stopBtn = stopBtn;
	}

	public IButton getIncBtn() {
		return incBtn;
	}

	public void setIncBtn(IButton incBtn) {
		this.incBtn = incBtn;
	}

	public IButton getDecBtn() {
		return decBtn;
	}

	public void setDecBtn(IButton decBtn) {
		this.decBtn = decBtn;
	}
	/*
	@Override
	public void update() {
		if(model.isRunning()){
			textfield.setText(""+model.getBpm());
			if(model.getTempo() == 0 ){
				led2.setFill(javafx.scene.paint.Color.RED);
			}
			else{
				led2.setFill(javafx.scene.paint.Color.BLACK);
			}
		}

	}*/
	



}
