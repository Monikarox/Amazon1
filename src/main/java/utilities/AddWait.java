package utilities;

public class AddWait {

	private AddWait() {
		
	}
	
	public static void forTime(long millisecond) {
		try {
			Thread.sleep(millisecond*1000);
		} catch (InterruptedException e) {
			Log.inFatalAdd("EXCEPTION OCCURED WHILE ADDING WAIT");
			Thread.currentThread().interrupt();
		}
	}
}
