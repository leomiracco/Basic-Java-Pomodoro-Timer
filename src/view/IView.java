package view;

import javax.swing.JButton;

public interface IView {

	public JButton getButtonAlarmTimer();
	
	public JButton getButtonPlayTimer();
	
	public JButton getButtonResetTimer();
	
	public JButton getButtonAlarmRest();
	
	public JButton getButtonPlayRest();
	
	public JButton getButtonResetRest();
	
	public JButton getButtonResetAll();
	
	public void setChangeNamePlayPauseButton();
	
	public void setHoursTimer(String hours);
	
	public void setMinutesTimer(String minutes);
	
	public void setSecondsTimer(String seconds);
	
	public void setMilliSecondsTimer(String milliSeconds);
	
	public void setMinutesTimerRest(String minutesRest);
	
	public void setSecondsTimerRest(String secondsRest);
	
	public void setMilliSecondsTimerRest(String milliSecondsRest);

	public void disableHomeButtons();
	
	public void enableButtonsMainTimerStarted();
	
	public void disableButtonsMainTimerStarted();
	
	public void activateStopButtonAlarmMainTimer();
	
	public void activateStopButtonAlarmRestTimer();
	
	public void showState(String state);
	
	public void disableResetButton();
	
	public void activatePlayButtonRest();
	
	public void setChangeNamePlayPauseButtonRest();
	
	public void activateResetButtonRest();
	
	public void disableResetButtonRest();
	
	public void disableRestPlayButton();
	
	public void disableStopButtonAlarmRestTimer();
	
	public void activatePlayButtonMain();
}