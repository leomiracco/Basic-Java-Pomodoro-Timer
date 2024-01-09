package model;

public interface ITimerState {

	public void waitingInstructionsState();
	
	public void startedMainTimerState();
	
	public void startedRestTimerState();
	
	public void pausedMainTimerState();
	
	public void pausedRestTimerState();
	
	public void mainAlarmRingingState();
	
	public void alarmStoppedMainTimerState();
	
	public void alarmStoppedRestTimerState();
	
	public void resetMainTimerState();
	
	public void resetRestTimerState();
	
	public void restAlarmRingingState();
	
	public void showState();
	
	public void task();
}