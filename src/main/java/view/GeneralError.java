package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class GeneralError extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private String txt;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public GeneralError(Shell parent, int style, String text) {
		super(parent, style);
		setText("SWT Dialog");
		this.txt = text;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(102, 90, 227, 76);
		text.setText(txt);
		
		Button btnClose = new Button(shell, SWT.NONE);
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnClose.setBounds(178, 188, 75, 25);
		btnClose.setText("Close");

	}

}
