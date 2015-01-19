package fr.istic.aocproject.ihm;

import java.io.File;
import java.io.IOException;
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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.istic.aocproject.adapter.DecBtn;
import fr.istic.aocproject.adapter.IButton;
import fr.istic.aocproject.adapter.IncBtn;
import fr.istic.aocproject.adapter.StartBtn;
import fr.istic.aocproject.adapter.StopBtn;
import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.metronomeEngine.MetronomeEngine;
import fr.istic.aocproject.metronomeEngine.command.DecCommand;
import fr.istic.aocproject.metronomeEngine.command.IncCommand;
import fr.istic.aocproject.metronomeEngine.command.SlideCommand;
import fr.istic.aocproject.metronomeEngine.command.StartCommand;
import fr.istic.aocproject.metronomeEngine.command.StopCommand;


@SuppressWarnings("restriction")


/**
 * FXML Controller class
 * @author amhachi & chaabi
 * @version 1.0 2015-01-10 T 20:00
 */

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

	@FXML
	private TextField textfield1;

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

	/**
	 * Default constructor.
	 */

	public IHMController() {
		super();
	}

	/*
	 * Methode called to initialize a controller after its root element 
	 * has been completely processed.
	 * @param URL used to resolve relative paths for the root object
	 * @param ResourceBundle used to localize the root object
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */

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

		final IHMController pere = this;

		// Slider
		slider.setMin(MetronomeEngine.BPM_MIN_VALUE);
		slider.setMax(MetronomeEngine.BPM_MAX_VALUE);
		slider.setValue(MetronomeEngine.BPM_INITIAL_VALUE);
		slider.valueProperty().addListener((ov, old_val, new_val) -> {
			int position = (int) new_val.doubleValue();
			textfield.setText(position + "");
			pere.notifyMetronomeSlidePosition(position);
		});


	}

	/*
	 * Returns the Button start
	 */
	
	public IButton getStartBtn() {
		return startBtn;
	}

	/*
	 * Sets the Button start
	 */
	public void setStartBtn(IButton startBtn) {
		this.startBtn = startBtn;
	}

	/*
	 * Returns the Button stop
	 */

	public IButton getStopBtn() {
		return stopBtn;
	}
	
	/*
	 * Sets the Button stop
	 */

	public void setStopBtn(IButton stopBtn) {
		this.stopBtn = stopBtn;
	}
	
	/*
	 * Returns the Button increment 
	 */
	
	public IButton getIncBtn() {
		return incBtn;
	}
	
	/*
	 * Sets the Button decrement 
	 */

	public void setIncBtn(IButton incBtn) {
		this.incBtn = incBtn;
	}
	
	/*
	 * Returns the Button decrement 
	 */

	public IButton getDecBtn() {
		return decBtn;
	}
	
	/*
	 * Sets the Button decrement 
	 */

	public void setDecBtn(IButton decBtn) {
		this.decBtn = decBtn;
	}

	TranslateTransition transition;
	boolean theFistTimeBeat = true;

	AudioInputStream audioInputStream;
	Clip clip;


	@Override

	public void flashLed1() throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		if (!theFistTimeBeat) {
			FillTransition st = new FillTransition(Duration.millis(100), led1,
					Color.WHITE, Color.RED);
			st.setCycleCount(4);
			st.setAutoReverse(true);

			st.play();

			audioInputStream = AudioSystem.getAudioInputStream(new File(
					"resources/beep.wav").getAbsoluteFile());

			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} else
			theFistTimeBeat = false;
	}

	boolean theFistTimeBar = true;

	@Override
	public void flashLed2() throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		if (!theFistTimeBar) {
			FillTransition st = new FillTransition(Duration.millis(100), led2,
					Color.WHITE, Color.RED);
			st.setCycleCount(4);

			st.setAutoReverse(true);

			st.play();

			audioInputStream = AudioSystem.getAudioInputStream(new File(
					"resources/bar.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} else
			theFistTimeBar = false;


	}

	/*
	 * Sets the Controller Object 
	 * @param controller controller architecture
	 * @see fr.istic.aocproject.ihm.IiHMController#setController(fr.istic.aocproject.controller.Controller)
	 */

	@Override
	public void setController(Controller controller) {
		this.controller = controller;

	}
	/*
	 * active pressure issuance of clicks each time and eclaire of the led
	 * @see fr.istic.aocproject.ihm.IiHMController#start()
	 */

	@Override
	public void start() {
		StartCommand startCmd = new StartCommand();
		startCmd.setController(controller);
		start.setOnAction((e) -> {
			startCmd.execute();
		});


	}

	@Override
	public void notifyMetronomeSlidePosition(int position) {
		SlideCommand slideCmd = new SlideCommand();
		slideCmd.setController(controller);
		slideCmd.setPosition(position);
		start.setOnAction((e) -> {
			slideCmd.execute();
		});


	}

	/*
	 * disables sound and light signals
	 * @see fr.istic.aocproject.ihm.IiHMController#stop()
	 */

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

	/*
	 * disables sound and light signals for each pressure increases the number 
	 * of beats in a measure of a unit
	 * @see fr.istic.aocproject.ihm.IiHMController#inc()
	 */

	@Override
	public void inc() {
		IncCommand incCmd = new IncCommand();
		incCmd.setController(controller);
		inc.setOnAction((e) -> {
			incCmd.execute();
		});

	}

	/*
	 * decreases the number of beats in a measure unit
	 * @see fr.istic.aocproject.ihm.IiHMController#dec()
	 */

	@Override
	public void dec() {
		DecCommand decCmd = new DecCommand();
		decCmd.setController(controller);

		dec.setOnAction((e) -> {
			decCmd.execute();
		});

	}

}
