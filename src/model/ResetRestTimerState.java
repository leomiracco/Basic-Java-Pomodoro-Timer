package model;

public class ResetRestTimerState implements ITimerState {

	private PomodoroTimer pomodoroTimer;
	
	public ResetRestTimerState(PomodoroTimer timer) {
		this.pomodoroTimer = timer;
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
		this.pomodoroTimer.setState(new StartedRestTimerState(this.pomodoroTimer));
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