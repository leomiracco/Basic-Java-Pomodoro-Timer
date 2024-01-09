package model;

public class PausedMainTimerState implements ITimerState{

	private PomodoroTimer pomodoroTimer;
	
	public PausedMainTimerState(PomodoroTimer timer) {
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
	public void pausedMainTimerState() {
		System.out.println("Estado: en pausa del Timer principal");	}
	
	@Override
	public void mainAlarmRingingState() {
		
	}

	@Override
	public void alarmStoppedMainTimerState() {		//this.timer.setState(new AlarmStoppedMainTimerState(this.timer));
	}

	@Override
	public void startedRestTimerState() {
		//this.timer.setState(new StartedRestTimerState(this.timer));
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
		this.pomodoroTimer.setState(new ResetMainTimerState(this.pomodoroTimer));
	}
	
	@Override
	public void resetRestTimerState() {
		
	}
	
	@Override
	public void restAlarmRingingState() {
		
	}
	
	@Override
	public void showState() {
		//System.out.println("Estado: Pausado...");
	}
	
	@Override
	public void task() {
		//System.out.println("Pausando?");
	}

	@Override
	public String toString() {
		return "PausedMainTimerState";
	}
	
}