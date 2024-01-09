package model;

public class PausedRestTimerState implements ITimerState {

	private PomodoroTimer pomodoroTimer;
	
	public PausedRestTimerState(PomodoroTimer timer) {
		this.pomodoroTimer = timer;
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
	public void startedRestTimerState() {
		this.pomodoroTimer.setState(new StartedRestTimerState(this.pomodoroTimer));
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
		System.out.println("Estado: en pausa cuenta regresiva del Timer de descanso");
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
		this.pomodoroTimer.setState(new ResetRestTimerState(this.pomodoroTimer));
	}
	
	@Override
	public void restAlarmRingingState() {
		
	}
	
	@Override
	public void showState() {
		//System.out.println("Estado: Temporizador de descanso en pausa...");
	}
	
	@Override
	public void task() {
		
	}
	
	@Override
	public String toString() {
		return "PausedRestTimerState";
	}

}