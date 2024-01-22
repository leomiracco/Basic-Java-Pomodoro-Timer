package model;

import java.util.concurrent.TimeUnit;

public class StartedMainTimerState implements ITimerState{

	private PomodoroTimer pomodoroTimer;
	private int hours, minutes, seconds, milliSeconds;
	private long totalNanoSeconds, totalMilliSeconds, start_time, future_time, elapsed_time;
	private boolean once;
	
	public StartedMainTimerState(PomodoroTimer timer) {
		this.pomodoroTimer = timer;
		this.hours = this.pomodoroTimer.getHours();
		this.minutes = this.pomodoroTimer.getMinutes();
		this.seconds = this.pomodoroTimer.getSeconds();
		this.milliSeconds = this.pomodoroTimer.getMilliSeconds();
		this.once = true;
	}
	
	@Override
	public void waitingInstructionsState() {
		this.pomodoroTimer.setState(new WaitingInstructionsState(this.pomodoroTimer));
	}
	
	@Override
	public void startedMainTimerState() {
		System.out.println("Estado: en cuenta regresiva del Timer principal");
	}

	@Override
	public void pausedMainTimerState() {		this.pomodoroTimer.setState(new PausedMainTimerState(this.pomodoroTimer));
	}
	
	@Override
	public void mainAlarmRingingState() {
		this.pomodoroTimer.setState(new MainAlarmRingRingState(this.pomodoroTimer));
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
		//System.out.println("Estado: Temporizador principal en marcha...");
	}

	public void task() {
		if(this.once) {
			// 1 seg = 1000000000 (mil millones de nanosegundos).
			this.once = !this.once;
			this.totalMilliSeconds = (this.hours * 3600000) + (this.minutes * 60000) + (this.seconds * 1000) + this.milliSeconds;
			//this.totalNanoSeconds = (this.hours * 3600000000000L) + (this.minutes * 60000000000L) + (this.seconds * 1000000000) + (this.milliSeconds * 1000000);
			
			this.start_time = System.currentTimeMillis();
			//this.start_time = System.nanoTime();
			
			//this.future_time = this.start_time + TimeUnit.MILLISECONDS.toMillis(this.totalMilliSeconds);
			this.future_time = Math.addExact(this.start_time, this.totalMilliSeconds);
			//this.future_time = Math.addExact(this.start_time, this.totalNanoSeconds);
			
			this.elapsed_time = 23;
		}
		
		if(this.elapsed_time > 0) {
			this.start_time = System.currentTimeMillis();
			//this.start_time = System.nanoTime();
			//this.elapsed_time = (this.future_time - this.start_time) / 1000;
			this.elapsed_time = (this.future_time - this.start_time);
			
			this.pomodoroTimer.setMilliSeconds((int) (this.elapsed_time % 1000));
			this.pomodoroTimer.setSeconds((int) ((this.elapsed_time / 1000) % 60));
			this.pomodoroTimer.setMinutes((int) ((this.elapsed_time / 60000) % 60));
			this.pomodoroTimer.setHours((int) (this.elapsed_time / 3600000));
//			this.pomodoroTimer.setMilliSeconds((int) ((this.elapsed_time / 1000000) % 1000));
//			this.pomodoroTimer.setSeconds((int) ((this.elapsed_time / 1000000000) % 60));
//			this.pomodoroTimer.setMinutes((int) ((this.elapsed_time / 60000000000L) % 60));
//			this.pomodoroTimer.setHours((int) (this.elapsed_time / 3600000000000L));
			this.pomodoroTimer.updateTimer("MainTimer");
		}else {
			this.pomodoroTimer.updateTimer("TimerFinished");
		}
	}
	
	@Override
	public String toString() {
		return "StartedMainTimerState";
	}
}