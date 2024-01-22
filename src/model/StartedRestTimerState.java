package model;

import java.util.concurrent.TimeUnit;

public class StartedRestTimerState implements ITimerState {

	private PomodoroTimer pomodoroTimer;
	private int minutesRest, secondsRest, milliSecondsRest;
	private long totalMilliSeconds, start_time, future_time, elapsed_time;
	private boolean once;
	
	public StartedRestTimerState(PomodoroTimer timer) {
		this.pomodoroTimer = timer;
		this.minutesRest = this.pomodoroTimer.getMinutesRest();
		this.secondsRest = this.pomodoroTimer.getSecondsRest();
		this.milliSecondsRest = this.pomodoroTimer.getMilliSecondsRest();
		this.once = true;
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
		System.out.println("Estado: en cuenta regresiva del Timer de descanso");
	}

	@Override
	public void pausedMainTimerState() {
		//this.timer.setState(new PausedMainTimerState(this.timer));
	}


	@Override
	public void pausedRestTimerState() {
		this.pomodoroTimer.setState(new PausedRestTimerState(this.pomodoroTimer));
	}

	@Override
	public void mainAlarmRingingState() {
		this.pomodoroTimer.setState(new MainAlarmRingRingState(this.pomodoroTimer));
	}
	
	@Override
	public void alarmStoppedMainTimerState() {
		//this.timer.setState(new AlarmStoppedMainTimerState(this.timer));
	}

	@Override
	public void alarmStoppedRestTimerState() {
		this.pomodoroTimer.setState(new AlarmStoppedRestTimerState(this.pomodoroTimer));
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
		this.pomodoroTimer.setState(new RestAlarmRingRingState(this.pomodoroTimer));
	}
	
	@Override
	public void showState() {
		//System.out.println("Estado: Temporizador de descanso en marcha...");
	}

	@Override
	public void task() {
		if(this.once) {
			this.once = !this.once;
			this.totalMilliSeconds = (this.minutesRest * 60000) + (this.secondsRest * 1000) + this.milliSecondsRest;
			this.start_time = System.currentTimeMillis();
			//this.future_time = this.start_time + TimeUnit.MILLISECONDS.toMillis(this.totalMilliSeconds);
			this.future_time = Math.addExact(this.start_time, this.totalMilliSeconds);
			this.elapsed_time = 23;
		}
		
		if(this.elapsed_time > 0) {
			this.start_time = System.currentTimeMillis();
			//this.elapsed_time = (this.future_time - this.start_time) / 1000;
			this.elapsed_time = (this.future_time - this.start_time);
			
			this.pomodoroTimer.setMilliSecondsRest((int) (this.elapsed_time % 1000));
			this.pomodoroTimer.setSecondsRest((int) ((this.elapsed_time / 1000) % 60));
			this.pomodoroTimer.setMinutesRest((int) ((this.elapsed_time / 60000) % 60));
			this.pomodoroTimer.updateTimer("RestTimer");
		}else {
			this.pomodoroTimer.updateTimer("RestTimerFinished");
		}
	}
	
	@Override
	public String toString() {
		return "StartedRestTimerState";
	}
	
}