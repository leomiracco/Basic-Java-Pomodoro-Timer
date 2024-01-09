package utilities;

public class Pause extends Thread {

	public Pause() {
		
	}

	public static void runPause(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

}