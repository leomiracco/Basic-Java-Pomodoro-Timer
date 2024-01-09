package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;

public class View extends JFrame implements IView{

	private static final long serialVersionUID = 1L;
	private JPanel panelNorth;
	private JPanel panelCentral;
	private JPanel panelTimer;
	private JPanel panelControllers;
	private JLabel lblHour;
	private JLabel lblTwoPoints;
	private JLabel lblMinutes;
	private JLabel lblTwoPoints2;
	private JLabel lblSeconds;
	private JButton btnPlay;
	private JButton btnReset;
	private JPanel panelRestTimer;
	private JPanel panelControllersRestTimer;
	private JLabel lblSecondsOfRest;
	private JLabel lblTwoPointsRest;
	private JLabel lblMinutesOfRest;
	private JButton btnAlarm;
	private JButton btnAlarmRest;
	private JButton btnPlayRest;
	private JButton btnResetRest;
	private JLabel lblPointMilliSeconds;
	private JLabel lblMilliSeconds;
	private JLabel lblMilliSecondsRest;
	private JPanel panelSouth;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblStateTittle;
	private JLabel lblInfoState;
	private JLabel lblNewLabel;

	public View() {
		setResizable(false);
		setTitle("Pomodoro");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panelNorth = new JPanel();
		contentPane.add(this.panelNorth);
		this.panelNorth.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panelTimer = new JPanel();
		this.panelNorth.add(this.panelTimer);
		this.panelTimer.setLayout(new GridLayout(1, 7, -225, 0));
		
		this.lblHour = new JLabel("00");
		this.lblHour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblHour.setVerticalAlignment(SwingConstants.CENTER);
		this.panelTimer.add(this.lblHour);
		
		this.lblTwoPoints = new JLabel(":");
		this.lblTwoPoints.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblTwoPoints.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblTwoPoints.setVerticalAlignment(SwingConstants.CENTER);
		this.panelTimer.add(this.lblTwoPoints);
		
		this.lblMinutes = new JLabel("00");
		this.lblMinutes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMinutes.setVerticalAlignment(SwingConstants.CENTER);
		this.panelTimer.add(this.lblMinutes);
		
		this.lblTwoPoints2 = new JLabel(":");
		this.lblTwoPoints2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblTwoPoints2.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelTimer.add(this.lblTwoPoints2);
		
		this.lblSeconds = new JLabel("00");
		this.lblSeconds.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelTimer.add(this.lblSeconds);
		
		this.lblPointMilliSeconds = new JLabel(".");
		this.lblPointMilliSeconds.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblPointMilliSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelTimer.add(this.lblPointMilliSeconds);
		
		this.lblMilliSeconds = new JLabel("000");
		this.lblMilliSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMilliSeconds.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.panelTimer.add(this.lblMilliSeconds);
		
		this.panelControllers = new JPanel();
		this.panelNorth.add(this.panelControllers);
		this.panelControllers.setLayout(new GridLayout(1, 4, 0, 0));
		
		this.btnAlarm = new JButton("Stop Alarm");
		this.btnAlarm.addActionListener(Controller.getInstance());
		this.panelControllers.add(this.btnAlarm);
		
		this.btnPlay = new JButton("Play");
		this.btnPlay.addActionListener(Controller.getInstance());
		this.btnPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		this.panelControllers.add(this.btnPlay);
		
		this.btnReset = new JButton("Reset");
		this.btnReset.addActionListener(Controller.getInstance());
		this.panelControllers.add(this.btnReset);
		
		this.panelCentral = new JPanel();
		contentPane.add(this.panelCentral);
		this.panelCentral.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panelRestTimer = new JPanel();
		this.panelCentral.add(this.panelRestTimer);
		this.panelRestTimer.setLayout(new GridLayout(1, 3, -300, 0));
		
		this.lblMinutesOfRest = new JLabel("00");
		this.lblMinutesOfRest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.lblMinutesOfRest.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelRestTimer.add(this.lblMinutesOfRest);
		
		this.lblTwoPointsRest = new JLabel(":");
		this.lblTwoPointsRest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.lblTwoPointsRest.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelRestTimer.add(this.lblTwoPointsRest);
		
		this.lblSecondsOfRest = new JLabel("00");
		this.lblSecondsOfRest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.lblSecondsOfRest.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelRestTimer.add(this.lblSecondsOfRest);
		
		JLabel lblPointRest = new JLabel(".");
		lblPointRest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPointRest.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelRestTimer.add(lblPointRest);
		
		this.lblMilliSecondsRest = new JLabel("000");
		this.lblMilliSecondsRest.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMilliSecondsRest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.panelRestTimer.add(this.lblMilliSecondsRest);
		
		this.panelControllersRestTimer = new JPanel();
		this.panelCentral.add(this.panelControllersRestTimer);
		this.panelControllersRestTimer.setLayout(new GridLayout(1, 4, 0, 0));
		
		this.btnAlarmRest = new JButton("Stop Alarm");
		this.btnAlarmRest.addActionListener(Controller.getInstance());
		this.btnAlarmRest.setHorizontalTextPosition(SwingConstants.CENTER);
		this.panelControllersRestTimer.add(this.btnAlarmRest);
		
		this.btnPlayRest = new JButton("Play");
		this.btnPlayRest.addActionListener(Controller.getInstance());
		this.btnPlayRest.setHorizontalTextPosition(SwingConstants.CENTER);
		this.panelControllersRestTimer.add(this.btnPlayRest);
		
		this.btnResetRest = new JButton("Reset");
		this.btnResetRest.addActionListener(Controller.getInstance());
		this.btnResetRest.setHorizontalTextPosition(SwingConstants.CENTER);
		this.panelControllersRestTimer.add(this.btnResetRest);
		
		this.panelSouth = new JPanel();
		contentPane.add(this.panelSouth);
		this.panelSouth.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel = new JPanel();
		this.panelSouth.add(this.panel);
		this.panel.setLayout(new GridLayout(1, 2, -300, 0));
		
		this.lblStateTittle = new JLabel("Estado:");
		this.lblStateTittle.setHorizontalTextPosition(SwingConstants.CENTER);
		this.lblStateTittle.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel.add(this.lblStateTittle);
		
		this.lblInfoState = new JLabel("En espera...");
		this.lblInfoState.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel.add(this.lblInfoState);
		
		this.panel_1 = new JPanel();
		this.panelSouth.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.lblNewLabel = new JLabel("By Leo");
		this.lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_1.add(this.lblNewLabel);
	}

	@Override
	public JButton getButtonAlarmTimer() {
		return this.btnAlarm;
	}
	
	@Override
	public JButton getButtonPlayTimer() {
		return this.btnPlay;
	}
	
	@Override
	public JButton getButtonResetTimer() {
		return this.btnReset;
	}
	
	@Override
	public JButton getButtonAlarmRest() {
		return this.btnAlarmRest;
	}
	
	@Override
	public JButton getButtonPlayRest() {
		return this.btnPlayRest;
	}

	@Override
	public JButton getButtonResetRest() {
		return this.btnResetRest;
	}

	@Override
	public void setChangeNamePlayPauseButton() {
		if(this.btnPlay.getText() == "Play") {
			this.btnPlay.setText("Pause");
		}else {
			this.btnPlay.setText("Play");
		}
	}

	@Override
	public void setHoursTimer(String hours) {
		this.lblHour.setText(hours);
	}

	@Override
	public void setMinutesTimer(String minutes) {
		this.lblMinutes.setText(minutes);
	}

	@Override
	public void setSecondsTimer(String seconds) {
		this.lblSeconds.setText(seconds);
	}

	@Override
	public void setMilliSecondsTimer(String milliSeconds) {
		this.lblMilliSeconds.setText(milliSeconds);
	}
	
	@Override
	public void setMinutesTimerRest(String minutesRest) {
		this.lblMinutesOfRest.setText(minutesRest);
	}

	@Override
	public void setSecondsTimerRest(String secondsRest) {
		this.lblSecondsOfRest.setText(secondsRest);
	}

	@Override
	public void setMilliSecondsTimerRest(String milliSecondsRest) {
		this.lblMilliSecondsRest.setText(milliSecondsRest);
	}

	@Override
	public void disableHomeButtons() {
		this.btnReset.setEnabled(false);
		this.btnAlarm.setEnabled(false);
		this.btnPlayRest.setEnabled(false);
		this.btnAlarmRest .setEnabled(false);
		this.btnResetRest.setEnabled(false);
	}

	@Override
	public void enableButtonsMainTimerStarted() {
		this.btnReset.setEnabled(true);
	}

	@Override
	public void disableButtonsMainTimerStarted() {
		
	}

	@Override
	public void activateStopButtonAlarmMainTimer() {
		this.btnPlay.setEnabled(false);
		this.btnReset.setEnabled(false);
		this.btnAlarm.setEnabled(true);
		this.btnPlayRest.setEnabled(false);
		this.btnAlarmRest .setEnabled(false);
		this.btnResetRest.setEnabled(false);
	}

	@Override
	public void showState(String state) {
		this.lblInfoState.setText(state);
	}

	@Override
	public void disableResetButton() {
		this.btnReset.setEnabled(false);
	}

	@Override
	public void activatePlayButtonRest() {
		this.btnAlarm.setEnabled(false);
		this.btnPlayRest.setEnabled(true);
	}
	
	@Override
	public void setChangeNamePlayPauseButtonRest() {
		if(this.btnPlayRest.getText() == "Play") {
			this.btnPlayRest.setText("Pause");
		}else {
			this.btnPlayRest.setText("Play");
		}
	}

	@Override
	public void activateResetButtonRest() {
		this.btnResetRest.setEnabled(true);
	}

	@Override
	public void disableResetButtonRest() {
		this.btnResetRest.setEnabled(false);
	}

	@Override
	public void activateStopButtonAlarmRestTimer() {
		this.btnAlarmRest.setEnabled(true);
	}

	@Override
	public void disableRestPlayButton() {
		this.btnPlayRest.setEnabled(false);
	}

	@Override
	public void disableStopButtonAlarmRestTimer() {
		this.btnAlarmRest.setEnabled(false);
	}

	@Override
	public void activatePlayButtonMain() {
		this.btnPlay.setEnabled(true);
	}
	
}
