package model;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import utilities.Alarm;

public class RestAlarmRingRingState implements ITimerState, ItemListener {

	private PomodoroTimer timer;
	private boolean alarm;
	
	public RestAlarmRingRingState(PomodoroTimer timer) {
		this.timer = timer;
		this.alarm = true;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitingInstructionsState() {
		// TODO Auto-generated method stub

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
	public void pausedRestTimerState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mainAlarmRingingState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void alarmStoppedMainTimerState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void alarmStoppedRestTimerState() {
		this.timer.setState(new AlarmStoppedRestTimerState(this.timer));
	}

	@Override
	public void resetMainTimerState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetRestTimerState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void restAlarmRingingState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void task() {
		if(this.alarm) {
			Alarm.getInstance().soundAlarm();
			this.alarm = !this.alarm;
		}
		this.timer.updateTimer("AlarmRingRing");
	}
	
	@Override
	public String toString() {
		return "RestAlarmRingRingState";
	}
}