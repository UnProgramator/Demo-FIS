package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AppWindows {

	protected Shell shell;
	PageManager pm;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		PageManager.createInstance(shell);
		
		pm = PageManager.getInstance();
		
		pm.addPage(MainMenu.class);
		pm.addPage(ViewClients.class);
		pm.addPage(AddClient.class);
		
		pm.changeLayout(MainMenu.class.getName());
	}

}
