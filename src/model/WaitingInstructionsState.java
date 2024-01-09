package model;

public class WaitingInstructionsState implements ITimerState {

	private PomodoroTimer timer;
	
	public WaitingInstructionsState(PomodoroTimer timer) {
		this.timer = timer;
	}

	@Override
	public void waitingInstructionsState() {
		System.out.println("Estado NO cambia: Ya esta en espera...");
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
	public void mainAlarmRingingState() {
		
	}
	
	@Override
	public void pausedRestTimerState() {
		//this.timer.setState(new PausedRestTimerState(this.timer));
	}

	@Override
	public void alarmStoppedMainTimerState() {
		//this.timer.setState(new AlarmStoppedMainTimerState(this.timer));
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
		//System.out.println("Estado: No iniciado, en espera...");
	}
	
	@Override
	public void task() {
		
	}
	
	@Override
	public String toString() {
		return "WaitingInstructionsState";
	}
}