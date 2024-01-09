package model;

public class ResetRestTimerState implements ITimerState {

	private PomodoroTimer timer;
	
	public ResetRestTimerState(PomodoroTimer timer) {
		this.timer = timer;
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
		this.timer.setState(new StartedRestTimerState(this.timer));
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
		// TODO Auto-generated method stub

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
		
	}

	@Override
	public void showState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void task() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "ResetRestTimerState";
	}
}