package fr.istic.aocproject.ihm;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Logger;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.controller.IController;
import fr.istic.aocproject.metronomeEngine.DecCommand;
import fr.istic.aocproject.metronomeEngine.IncCommand;

@SuppressWarnings("restriction")
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

	/* Molette */
	@FXML
	private Slider slider;
	
	private IController controller;

	// GEL
	private IButton startBtn;
	private IButton stopBtn;
	private IButton incBtn;
	private IButton decBtn;

	// GEL

	public IHMControler() {
		super();
		controller = new Controller();
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Logger.getGlobal().info(
				String.format("Initialized with a button start",
						start.toString()));

		// BPM Initialisation
		textfield.setText(String.valueOf(controller.initBPM()));

		setStartBtn(new StartBtn(start));

		setStopBtn(new StopBtn(stop));
		setIncBtn(new IncBtn(inc));
		setDecBtn(new DecBtn(dec));

		start.setOnAction((e) -> {
			controller.inStart();/* startBtn.setCommand(new StartCommand()); */
		});
		stop.setOnAction((e) -> {
			controller.inStop();/* stopBtn.setCommand(new StopCommand()); */
		});

		inc.setOnAction((e) -> {
			incBtn.setCommand(new IncCommand());
			/*
			 * Integer val =Integer.parseInt(textfield.getText()); val = val +1;
			 */
			controller.incBPM();
			textfield.setText(controller.getBPM());
		});

		dec.setOnAction((e) -> {
			decBtn.setCommand(new DecCommand());
			/*
			 * Integer val =Integer.parseInt(textfield.getText()); val = val-1;
			 */
			controller.decBPM();
			textfield.setText(controller.getBPM());
		});

		// Slider
		slider.setMin(0);
		slider.setMax(200);
		slider.setValue(120);
		slider.valueProperty().addListener((ov,old_val,new_val) -> {
			textfield.setText((int)new_val.doubleValue()+"");
		});
		/*
		 * start.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { startBtn.setCommand(new
		 * StartCommand());
		 * 
		 * } });
		 */

		// Listen for TextField text changes
		/*
		 * textfield.textProperty().addListener(new ChangeListener<String>() {
		 * 
		 * @Override public void changed(ObservableValue<? extends String>
		 * observable, String oldValue, String newValue) {
		 * 
		 * textfield.appendText("1"); } });
		 */

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

}
