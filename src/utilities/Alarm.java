package utilities;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Alarm {

	private static Alarm instance = null;
	private static Clip clip;
	
	public Alarm() {
		
		try {
			
			BufferedInputStream bufferedInputStream = new BufferedInputStream(getClass().getResourceAsStream("/resources/toqueDeQueda.wav"));
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
			
			// Clip sonido = AudioSystem.getClip();
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException err) {
			err.printStackTrace();
		} catch (IOException err) {
			err.printStackTrace();
		} catch (LineUnavailableException err) {
			err.printStackTrace();
		}
	}
	
	public static Alarm getInstance() {
		if(Alarm.instance == null) {
			Alarm.instance = new Alarm();
		}
		return instance;
	}
	
	public void soundAlarm() {
		clip.setFramePosition(0);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void turnOffAlarm() {
		clip.stop();
	}
	
}