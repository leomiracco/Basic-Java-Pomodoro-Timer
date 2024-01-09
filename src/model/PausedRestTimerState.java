package model;

public class PausedRestTimerState implements ITimerState {

	private PomodoroTimer timer;
	
	public PausedRestTimerState(PomodoroTimer timer) {
		this.timer = timer;
	}

	@Override
	public void waitingInstructionsState() {
		//this.timer.setState(new WaitingInstructionsState(this.timer));
	}

	@Override
	public void startedMainTimerState() {
		//this.timer.setState(new StartedMainTimerState(this.timer));
	}

	@Override
	public void startedRestTimerState() {
		this.timer.setState(new StartedRestTimerState(this.timer));
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
		this.timer.setState(new ResetRestTimerState(this.timer));
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