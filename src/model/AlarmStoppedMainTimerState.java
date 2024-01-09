package model;

import utilities.Alarm;

public class AlarmStoppedMainTimerState implements ITimerState{

	private PomodoroTimer pomodoroTimer;
	private boolean stop;
	
	public AlarmStoppedMainTimerState(PomodoroTimer timer) {
		this.pomodoroTimer = timer;
		this.stop = true;
	}

	@Override
	public void waitingInstructionsState() {
		this.pomodoroTimer.setState(new WaitingInstructionsState(this.pomodoroTimer));
	}
	
	@Override
	public void startedMainTimerState() {
		//this.timer.setState(new StartedMainTimerState(this.timer));
	}
	
	@Override
	public void pausedMainTimerState() {		//this.timer.setState(new PausedMainTimerState(this.timer));
	}

	@Override
	public void mainAlarmRingingState() {
		
	}
	
	@Override
	public void alarmStoppedMainTimerState() {		System.out.println("Estado: hemos detenido la alarma del Timer principal");
	}

	@Override
	public void startedRestTimerState() {
		this.pomodoroTimer.setState(new StartedRestTimerState(this.pomodoroTimer));
	}

	@Override
	public void pausedRestTimerState() {
		//this.timer.setState(new PausedRestTimerState(this.timer));
	}

	@Override
	public void alarmStoppedRestTimerState() {
		//this.timer.setState(new AlarmStoppedRestTimerState(this.timer));
	}
	
	@Override
	public void resetMainTimerState() {
		
	}

	@Override
	public void resetRestTimerState() {
		
	}

	@Override
	public void restAlarmRingingState() {
		
	}
	
	@Override
	public void showState() {
		//System.out.println("Estado: Alarma temporizador principal apagada...");
	}
	
	@Override
	public void task() {
		if(this.stop) {
			this.stop = !this.stop;
			Alarm.getInstance().turnOffAlarm();
			this.pomodoroTimer.updateTimer("AlarmMainStopped");			
		}
	}

	@Override
	public String toString() {
		return "AlarmStoppedMainTimerState";
	}
	
}