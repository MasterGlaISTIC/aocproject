package fr.istic.aocproject.ihm;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import fr.istic.aocproject.metronomeEngine.StartCommand;
import fr.istic.aocproject.metronomeEngine.StopCommand;
import fr.istic.aocproject.metronomeEngine.IncCommand;
import fr.istic.aocproject.metronomeEngine.DecCommand;

public class IHMControler implements IiHMControler, Initializable
{
	
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
	
	private IButton startBtn;
	private IButton stopBtn;
	private IButton incBtn;
	private IButton decBtn;
	
	
	public IHMControler(){
		super();
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		Logger.getGlobal().info(
                String.format("Initialized with a button start",
                        start.toString()));
		
		setStartBtn(new StartBtn(start));
		setStopBtn(new StopBtn(stop));
		setIncBtn(new IncBtn(inc));
		setDecBtn(new DecBtn(dec));
		
		
		start.setOnAction((e) -> {startBtn.setCommand(new StartCommand());});
		stop.setOnAction((e) -> {stopBtn.setCommand(new StopCommand());});
				
		inc.setOnAction((e) -> {incBtn.setCommand(new IncCommand());
			Integer val =Integer.parseInt(textfield.getText()); 
			val = val +1;
			textfield.setText((val).toString());});
		
		dec.setOnAction((e) -> {decBtn.setCommand(new DecCommand());
			Integer val =Integer.parseInt(textfield.getText()); 
			val = val-1;
			textfield.setText((val).toString());});
		
	
		/*start.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				startBtn.setCommand(new StartCommand());
				
			}
		});*/
		
		// Listen for TextField text changes
		/*textfield.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						
						textfield.appendText("1");
					}
				});
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

