package fr.istic.aocproject.ihm;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import fr.istic.aocproject.metronomeEngine.StartCommand;import fr.istic.aocproject.metronomeEngine.StopCommand;


public class IHMControler implements IiHMControler, Initializable
{
	
	
	@FXML
	private Button start;
	
	@FXML
	private Button stop;
	
	
	private IButton startBtn;
	private IButton stopBtn;
	
	public IHMControler(){
		super();
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		Logger.getGlobal().info(
                String.format("Initialized with a button start",
                        start.toString()));
		
		setStartBtn(new StartBtn(start));
		setStopBtn(new StopBtn(stop));
		start.setOnAction((e) -> {startBtn.setCommand(new StartCommand());});
		stop.setOnAction((e) -> {stopBtn.setCommand(new StopCommand());});
		/*start.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				startBtn.setCommand(new StartCommand());
				
			}
		});*/
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


	
	
	

}

