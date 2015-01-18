package fr.istic.aocproject.ihm;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import fr.istic.aocproject.adapter.DecBtn;
import fr.istic.aocproject.adapter.IButton;
import fr.istic.aocproject.adapter.IncBtn;
import fr.istic.aocproject.adapter.StartBtn;
import fr.istic.aocproject.adapter.StopBtn;
import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.metronomeEngine.MetronomeEngine;
import fr.istic.aocproject.metronomeEngine.command.DecCommand;
import fr.istic.aocproject.metronomeEngine.command.IncCommand;
import fr.istic.aocproject.metronomeEngine.command.StartCommand;
import fr.istic.aocproject.metronomeEngine.command.StopCommand;

public class IHMController implements IiHMController, Initializable {

	@FXML
	private Button start;

	@FXML
	private Button stop;

	@FXML
	private Button inc;

	@FXML
	private Button dec;

	@FXML
	private Circle led1;

	@FXML
	private Circle led2;

	@FXML
	private TextField textfield;

	/* Molette */
	@FXML
	private Slider slider;

	private IButton startBtn;
	private IButton stopBtn;
	private IButton incBtn;
	private IButton decBtn;

	// Controller
	private Controller controller;

	// GEL

	public IHMController() {
		super();
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Logger.getGlobal().info(
				String.format("Initialized with a button start",
						start.toString()));

		// BPM Initialisation
		textfield.setText(String.valueOf(MetronomeEngine.BPM_INITIAL_VALUE));

		setStartBtn(new StartBtn(start));
		setStopBtn(new StopBtn(stop));
		setIncBtn(new IncBtn(inc));
		setDecBtn(new DecBtn(dec));

		controller = (Controller) Controller.getControllerInstance();
		controller.createViewAdapter(this);

		start();
		
		stop();
		
		inc();
		
		
		dec();
		
		
		// Slider
		slider.setMin(0);
		slider.setMax(200);
		slider.setValue(120);
		slider.valueProperty().addListener((ov, old_val, new_val) -> {
			textfield.setText((int) new_val.doubleValue() + "");
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

	TranslateTransition transition;
	boolean theFistTimeBeat = true;
	@Override
	public void flashLed1() {
		if(!theFistTimeBeat)
		{
		FillTransition st = new FillTransition(Duration.millis(100), led1,
				Color.WHITE,Color.RED);
		st.setCycleCount(4);
		st.setAutoReverse(true);

		st.play();
		}else theFistTimeBeat = false;
	}
	
	boolean theFistTimeBar = true;
	@Override
	public void flashLed2() {
		if(!theFistTimeBar){
		FillTransition st = new FillTransition(Duration.millis(100), led2,
		Color.WHITE,Color.RED);
		st.setCycleCount(4);
		
		st.setAutoReverse(true);
		
		st.play();
		}else theFistTimeBar = false;
		

	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;

	}

	@Override
	public void start() {
		StartCommand startCmd = new StartCommand();
		startCmd.setController(controller);
		start.setOnAction((e) -> {
			startCmd.execute();
		});
		
	}

	@Override
	public void stop() {
		StopCommand stopCmd = new StopCommand();
		stopCmd.setController(controller);
		theFistTimeBar = true;
		theFistTimeBeat = true;
		stop.setOnAction((e) -> {
			stopCmd.execute();
			led1.setFill(Color.WHITE);
			led2.setFill(Color.WHITE);
		});
		
	}

	@Override
	public void inc() {
		IncCommand incCmd = new IncCommand();
		incCmd.setController(controller);
		inc.setOnAction((e) -> {
			incCmd.execute();
		});
		
	}

	@Override
	public void dec() {
		DecCommand decCmd = new DecCommand();
		decCmd.setController(controller);

		dec.setOnAction((e) -> {
			decCmd.execute();
		});
		
	}

}
