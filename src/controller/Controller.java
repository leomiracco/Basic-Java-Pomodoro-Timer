package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;

import view.View;
import view.IView;
import model.PomodoroTimer;

public class Controller extends Thread implements ActionListener, Observer{

	private static Controller instance = null;
	private IView iview;
	//private Timer timerThread;
	private Thread threadPomodoro, threadUI;
	private boolean start;
	private String situation;
	
	public Controller() {
		PomodoroTimer.getInstance().addObserver(this);
		//this.timerThread = new Timer(1, PomodoroTimer.getInstance());
		this.threadPomodoro = new Thread(PomodoroTimer.getInstance());
		this.threadUI = new Thread(this);
		this.situation = "null";
		this.start = true;
		this.threadPomodoro.start();
	}

	public static Controller getInstance() {
		if(Controller.instance == null) {
			Controller.instance = new Controller();
		}
		return Controller.instance;
	}
	
	public void setView(View view) {
		this.iview = view;
		this.iview.setHoursTimer("00");
		this.iview.setMinutesTimer("25");
		this.iview.setSecondsTimer("00");
		this.iview.setMilliSecondsTimer("000");
		this.iview.setMinutesTimerRest("05");
		this.iview.setSecondsTimerRest("00");
		this.iview.setMilliSecondsTimerRest("000");
		view.setVisible(true);
		this.iview.disableHomeButtons();
		this.threadUI.start();
		this.iview.showState("En espera...");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton buttonPlayTimer = (JButton) e.getSource();
		
		if(e.getSource() == this.iview.getButtonAlarmTimer()) {
			if(PomodoroTimer.getInstance().getState().toString().equals("MainAlarmRingRingState")) {
				PomodoroTimer.getInstance().alarmStoppedMainTimerState();
				this.iview.activatePlayButtonRest();
				this.iview.setChangeNamePlayPauseButtonRest();
			}			
		}
		
		if(e.getSource() == this.iview.getButtonPlayTimer()) {
			
			// Cambiar de nombre el botón de "play" Temporizador a "Pause"
			// y/o viceversa.
			this.iview.setChangeNamePlayPauseButton();
			
			if(PomodoroTimer.getInstance().getState().toString().equals("WaitingInstructionsState") || PomodoroTimer.getInstance().getState().toString().equals("PausedMainTimerState") || PomodoroTimer.getInstance().getState().toString().equals("ResetMainTimerState")) {
				PomodoroTimer.getInstance().startedMainTimerState();
				this.iview.enableButtonsMainTimerStarted();
				this.iview.showState("Iniciado...");
			}else if(PomodoroTimer.getInstance().getState().toString().equals("StartedMainTimerState")) {
				PomodoroTimer.getInstance().pausedMainTimerState();
				this.iview.showState("Pausado...");
			}
		}
		
		if(e.getSource() == this.iview.getButtonResetTimer()) {
			this.iview.disableResetButton();
			if(PomodoroTimer.getInstance().getState().toString().equals("StartedMainTimerState")) {
				this.resetMainTimer();
				this.iview.setChangeNamePlayPauseButton();
			}else if(PomodoroTimer.getInstance().getState().toString().equals("PausedMainTimerState")) {
				this.resetMainTimer();
			}
		}
		
		if(e.getSource() == this.iview.getButtonAlarmRest()) {
			if(PomodoroTimer.getInstance().getState().toString().equals("RestAlarmRingRingState")) {
				PomodoroTimer.getInstance().alarmStoppedRestTimerState();
			}	
		}
		
		if(e.getSource() == this.iview.getButtonPlayRest()) {
			if(PomodoroTimer.getInstance().getState().toString().equals("StartedRestTimerState")) {
				this.iview.setChangeNamePlayPauseButtonRest();
				PomodoroTimer.getInstance().pausedRestTimerState();
				this.iview.showState("Pausa...");
			}else if(PomodoroTimer.getInstance().getState().toString().equals("PausedRestTimerState") || PomodoroTimer.getInstance().getState().toString().equals("ResetRestTimerState")){
				this.iview.activateResetButtonRest();
				PomodoroTimer.getInstance().startedRestTimerState();
				this.iview.setChangeNamePlayPauseButtonRest();
				this.iview.showState("Iniciado...");
			}
		}
		
		if(e.getSource() == this.iview.getButtonResetRest()) {
			this.iview.disableResetButtonRest();
			if(PomodoroTimer.getInstance().getState().toString().equals("StartedRestTimerState")) {
				this.resetRestTimer();
				this.iview.setChangeNamePlayPauseButtonRest();
			}else if(PomodoroTimer.getInstance().getState().toString().equals("PausedRestTimerState")) {
				this.resetRestTimer();
			}
		}
			
		if(e.getSource() == this.iview.getButtonResetAll()) {
			if(PomodoroTimer.getInstance().getState().toString().equals("StartedRestTimerState")) {
				this.iview.setChangeNamePlayPauseButtonRest();
			}else if(PomodoroTimer.getInstance().getState().toString().equals("StartedMainTimerState")) {
				this.iview.setChangeNamePlayPauseButton();
			}else if(PomodoroTimer.getInstance().getState().toString().equals("MainAlarmRingRingState")) {
				PomodoroTimer.getInstance().alarmStoppedMainTimerState();
			}else if(PomodoroTimer.getInstance().getState().toString().equals("RestAlarmRingRingState")) {
				PomodoroTimer.getInstance().alarmStoppedRestTimerState();
			}	
			PomodoroTimer.getInstance().waitingInstructionsState();
			this.resetAllTimer();
			this.iview.showState("En espera...");
			this.iview.disableStopButtonAlarmRestTimer();
			this.iview.disableHomeButtons();
		}
		
	}

	private void resetMainTimer() {
		PomodoroTimer.getInstance().resetMainTimerState();
		PomodoroTimer.getInstance().setHours(0);
		PomodoroTimer.getInstance().setMinutes(25);
		PomodoroTimer.getInstance().setSeconds(0);
		PomodoroTimer.getInstance().setMilliSeconds(0);
		this.iview.setHoursTimer("00");
		this.iview.setMinutesTimer("25");
		this.iview.setSecondsTimer("00");
		this.iview.setMilliSecondsTimer("000");
		this.iview.showState("Reset...");
	}
	
	private void resetRestTimer() {
		PomodoroTimer.getInstance().resetRestTimerState();
		PomodoroTimer.getInstance().setMinutesRest(5);
		PomodoroTimer.getInstance().setSecondsRest(0);
		PomodoroTimer.getInstance().setMilliSecondsRest(0);
		this.iview.setMinutesTimerRest("05");
		this.iview.setSecondsTimerRest("00");
		this.iview.setMilliSecondsTimerRest("000");
		this.iview.showState("Reset...");
	}

	@Override
	public void update(Observable observable, Object arg) {
		//PomodoroTimer timer = (PomodoroTimer) observable;
		
		this.situation = arg.toString();
		
		if(this.situation.equals("TimerFinished")) {
			PomodoroTimer.getInstance().mainAlarmRingingState();
			this.iview.setChangeNamePlayPauseButton();
			this.iview.activateStopButtonAlarmMainTimer();
			this.iview.showState("Alarma...");
		}else if(situation.equals("AlarmMainStopped")){
			PomodoroTimer.getInstance().startedRestTimerState();
			this.iview.showState("Iniciado...");
			this.iview.activateResetButtonRest();
		}else if(situation.equals("RestTimerFinished")) {
			PomodoroTimer.getInstance().restAlarmRingingState();
			this.iview.setChangeNamePlayPauseButtonRest();
			this.iview.activateStopButtonAlarmRestTimer();
			this.iview.disableResetButtonRest();
			this.iview.disableRestPlayButton();
			this.iview.showState("Alarma...");
		}else if(situation.equals("AlarmRestStopped")) {
			PomodoroTimer.getInstance().waitingInstructionsState();
			this.resetAllTimer();
			this.iview.showState("En espera...");
			this.iview.disableStopButtonAlarmRestTimer();
		}
		
	}

	@Override
	public synchronized void run() {
		final int NS_POR_SEGUNDO = 1000000000; // nanoSegundos
		final int MEDIO_MILLISECONDS = NS_POR_SEGUNDO / 17;
		long start_time = System.nanoTime();
		
		while(this.start) {
			if(System.nanoTime() - start_time >= MEDIO_MILLISECONDS) {
				if(this.situation.equals("MainTimer")) {
					this.mainTimer();
				}else {
					this.restTimer();			
				}
				start_time = System.nanoTime();
			}
		}
	}
	
	private void resetAllTimer() {
		PomodoroTimer.getInstance().setHours(0);
		PomodoroTimer.getInstance().setMinutes(25);
		PomodoroTimer.getInstance().setSeconds(0);
		PomodoroTimer.getInstance().setMilliSeconds(0);
		PomodoroTimer.getInstance().setMinutesRest(5);
		PomodoroTimer.getInstance().setSecondsRest(0);
		PomodoroTimer.getInstance().setMilliSecondsRest(0);
		this.iview.setHoursTimer("00");
		this.iview.setMinutesTimer("25");
		this.iview.setSecondsTimer("00");
		this.iview.setMilliSecondsTimer("000");
		this.iview.setMinutesTimerRest("05");
		this.iview.setSecondsTimerRest("00");
		this.iview.setMilliSecondsTimerRest("000");
		this.iview.activatePlayButtonMain();
	}
	
	private void mainTimer() {
		this.iview.setHoursTimer(String.format("%02d", PomodoroTimer.getInstance().getHours()));
		this.iview.setMinutesTimer(String.format("%02d", PomodoroTimer.getInstance().getMinutes()));
		this.iview.setSecondsTimer(String.format("%02d", PomodoroTimer.getInstance().getSeconds()));
		this.iview.setMilliSecondsTimer(String.format("%03d", PomodoroTimer.getInstance().getMilliSeconds()));
	}
	
	private void restTimer() {
		this.iview.setMinutesTimerRest(String.format("%02d", PomodoroTimer.getInstance().getMinutesRest()));
		this.iview.setSecondsTimerRest(String.format("%02d", PomodoroTimer.getInstance().getSecondsRest()));
		this.iview.setMilliSecondsTimerRest(String.format("%03d", PomodoroTimer.getInstance().getMilliSecondsRest()));
	}
}