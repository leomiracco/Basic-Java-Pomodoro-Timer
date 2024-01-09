package model;

public class ResetMainTimerState implements ITimerState {

	private PomodoroTimer timer;
	
	public ResetMainTimerState(PomodoroTimer timer) {
		this.timer = timer;
	}

	@Override
	public void waitingInstructionsState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startedMainTimerState() {
		this.timer.setState(new StartedMainTimerState(this.timer));
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