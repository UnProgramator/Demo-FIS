package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class MainMenu extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainMenu(Composite parent, int style) {
		super(parent, style);
		
		Button btnViewClients = new Button(this, SWT.NONE);
		btnViewClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				PageManager.getInstance().changeLayout(ViewClients.class.getName());
			}
		});
		btnViewClients.setBounds(10, 66, 75, 25);
		btnViewClients.setText("View clients");
		
		Button btnAddClient = new Button(this, SWT.NONE);
		btnAddClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				PageManager.getInstance().changeLayout(AddClient.class.getName());
			}
		});
		btnAddClient.setBounds(10, 121, 75, 25);
		btnAddClient.setText("Add Client");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
