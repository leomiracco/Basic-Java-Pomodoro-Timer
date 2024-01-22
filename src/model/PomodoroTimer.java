package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class PomodoroTimer extends Observable implements Runnable, ActionListener{

	private static PomodoroTimer instance = null;
	private ITimerState iTimerState;
	int hours, minutes, seconds, milliSeconds, minutesRest, secondsRest, milliSecondsRest;
	private boolean play;
	
	public PomodoroTimer(int hours, int minutes, int seconds, int milliSeconds, int minutesRest, int secondsRest, int milliSecondsRest) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliSeconds = milliSeconds;
		this.minutesRest = minutesRest;
		this.secondsRest = secondsRest;
		this.milliSecondsRest = milliSecondsRest;
		this.play = true;
		this.iTimerState = new WaitingInstructionsState(this);
		this.showState();
	}
	
	public static PomodoroTimer getInstance() {
		if(PomodoroTimer.instance == null) {
			PomodoroTimer.instance = new PomodoroTimer(0, 25, 0, 0, 5, 0, 0);
		}
		return PomodoroTimer.instance;
	}
	
	public ITimerState getState() {
		return this.iTimerState;
	}
	
	protected void setState(ITimerState iTimerState) {
		this.iTimerState = iTimerState;
		this.showState();
	}
	
	public int getHours() {
		return this.hours;
	}

	public int getMinutes() {
		return this.minutes;
	}

	public int getSeconds() {
		return this.seconds;
	}
	
	public int getMilliSeconds() {
		return this.milliSeconds;
	}
	
	public int getMinutesRest() {
		return this.minutesRest;
	}
	
	public int getSecondsRest() {
		return this.secondsRest;
	}
	
	public int getMilliSecondsRest() {
		return this.milliSecondsRest;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public void setMilliSeconds(int milliSeconds) {
		this.milliSeconds = milliSeconds;
	}

	public void setMinutesRest(int minutesRest) {
		this.minutesRest = minutesRest;
	}
	
	public void setSecondsRest(int secondsRest) {
		this.secondsRest = secondsRest;
	}

	public void setMilliSecondsRest(int milliSecondsRest) {
		this.milliSecondsRest = milliSecondsRest;
	}
	
	public void waitingInstructionsState() {
		this.iTimerState.waitingInstructionsState();
	}
	
	public void startedMainTimerState() {
		this.iTimerState.startedMainTimerState();
	}
	
	public void pausedMainTimerState() {
		this.iTimerState.pausedMainTimerState();
	}

	public void mainAlarmRingingState() {
		this.iTimerState.mainAlarmRingingState();
	}
	
	public void alarmStoppedMainTimerState() {
		this.iTimerState.alarmStoppedMainTimerState();
	}

	public void startedRestTimerState() {
		this.iTimerState.startedRestTimerState();
	}

	public void pausedRestTimerState() {
		this.iTimerState.pausedRestTimerState();
	}

	public void alarmStoppedRestTimerState() {
		this.iTimerState.alarmStoppedRestTimerState();
	}
	
	public void resetMainTimerState() {
		this.iTimerState.resetMainTimerState();
	}
	
	public void resetRestTimerState() {
		this.iTimerState.resetRestTimerState();
	}
	
	public void restAlarmRingingState() {
		this.iTimerState.restAlarmRingingState();
	}
	
	public void showState() {
		this.iTimerState.showState();
	}

	@Override
	public synchronized void run() {
		final int NS_POR_SEGUNDO = 1000000000; // nanoSegundos
		//final int NS_POR_SEGUNDO = 1000; // MiliSegundos
		//final int MEDIO_MILLISECONDS = NS_POR_SEGUNDO / 2;
		final int MEDIO_MILLISECONDS = NS_POR_SEGUNDO / 16;
		//final int APS_OBJETIVO = 1500;
		//final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long start_time = System.nanoTime();
		while(this.play) {
			//System.out.print("");
			if(System.nanoTime() - start_time >= MEDIO_MILLISECONDS) {
				this.iTimerState.task();
				start_time = System.nanoTime();
			}
		}
	}
	
	@Override
	public String toString() {
		return "";
	}

	public void updateTimer(String timerType) {
		this.setChanged();
		this.notifyObservers(timerType);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//this.iTimerState.task();
	}

}