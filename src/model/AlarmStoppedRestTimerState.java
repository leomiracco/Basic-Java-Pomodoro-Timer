package model;

import utilities.Alarm;

public class AlarmStoppedRestTimerState implements ITimerState {

	private PomodoroTimer timer;
	private boolean stop;
	
	public AlarmStoppedRestTimerState(PomodoroTimer timer) {
		this.timer = timer; 
		this.stop = true;
	}

	@Override
	public void waitingInstructionsState() {
		this.timer.setState(new WaitingInstructionsState(this.timer));
	}

	@Override
	public void startedMainTimerState() {
		this.timer.setState(new StartedMainTimerState(this.timer));
	}

	@Override
	public void startedRestTimerState() {
		//this.timer.setState(new StartedRestTimerState(this.timer));
	}

	@Override
	public void pausedMainTimerState() {
		//this.timer.setState(new PausedMainTimerState(this.timer));
	}

	@Override
	public void pausedRestTimerState() {
		//this.timer.setState(new PausedRestTimerState(this.timer));
	}

	@Override
	public void mainAlarmRingingState() {
		
	}
	
	@Override
	public void alarmStoppedMainTimerState() {
		//this.timer.setState(new AlarmStoppedMainTimerState(this.timer));
	}

	@Override
	public void alarmStoppedRestTimerState() {
		System.out.println("Estado: alarma detenida Timer de descanso");
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
		
	}
	
	@Override
	public void task() {
		if(this.stop) {
			this.stop = !this.stop;
			Alarm.getInstance().turnOffAlarm();
			this.timer.updateTimer("AlarmRestStopped");	
		}
	}

	@Override
	public String toString() {
		return "AlarmStoppedRestTimerState";
	}
	
}