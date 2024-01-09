package model;

public class ResetMainTimerState implements ITimerState {

	private PomodoroTimer pomodoroTimer;
	
	public ResetMainTimerState(PomodoroTimer timer) {
		this.pomodoroTimer = timer;
	}

	@Override
	public void waitingInstructionsState() {
		this.pomodoroTimer.setState(new WaitingInstructionsState(this.pomodoroTimer));
	}

	@Override
	public void startedMainTimerState() {
		this.pomodoroTimer.setState(new StartedMainTimerState(this.pomodoroTimer));
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
		// TODO Auto-generated method stub

	}

	@Override
	public void resetMainTimerState() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resetRestTimerState() {
		
	}
	
	@Override
	public void restAlarmRingingState() {
		
	}

	@Override
	public void showState() {
		//System.out.println("Estado: Temporizador principal reseteado...");
	}

	@Override
	public void task() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "ResetMainTimerState";
	}
}