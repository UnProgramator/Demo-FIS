import view.AppWindows;


// https://www.youtube.com/watch?v=S0OqWAbEjbA
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
