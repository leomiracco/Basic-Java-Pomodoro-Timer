package model;

import utilities.Alarm;

public class MainAlarmRingRingState implements ITimerState {

	private PomodoroTimer pomodoroTimer;
	private boolean alarm;
	
	public MainAlarmRingRingState(PomodoroTimer timer) {
		this.pomodoroTimer = timer;
		this.alarm = true;
	}
	
	@Override
	public void waitingInstructionsState() {
		this.pomodoroTimer.setState(new WaitingInstructionsState(this.pomodoroTimer));
	}

	@Override
	public void startedMainTimerState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startedRestTimerState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pausedMainTimerState() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mainAlarmRingingState() {
		
	}

	@Override
	public void pausedRestTimerState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void alarmStoppedMainTimerState() {
		this.pomodoroTimer.setState(new AlarmStoppedMainTimerState(this.pomodoroTimer));
	}

	@Override
	public void alarmStoppedRestTimerState() {
		// TODO Auto-generated method stub

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
		//System.out.println("Estado: Alarma temporizador principal sonando...");
	}
	
	@Override
	public void task() {
		if(this.alarm) {
			Alarm.getInstance().soundAlarm();
			this.alarm = !this.alarm;
		}
		this.pomodoroTimer.updateTimer("AlarmRingRing");
	}
	
	@Override
	public String toString() {
		return "MainAlarmRingRingState";
	}

}