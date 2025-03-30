import view.AppWindows;

public class Main {

	public static void main(String[] args) {
		try {
			AppWindows window = new AppWindows();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

}
