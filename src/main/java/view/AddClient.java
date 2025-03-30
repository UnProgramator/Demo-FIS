package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.ClientService;
import model.reader.ClientDbManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AddClient extends Composite {
	private Text tNume;
	private Text tNrTel;
	private Text tID;
	private Button btnBack;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AddClient(Composite parent, int style) {
		super(parent, style);
		
		tNume = new Text(this, SWT.BORDER);
		tNume.setToolTipText("Nume");
		tNume.setBounds(120, 29, 76, 21);
		
		tNrTel = new Text(this, SWT.BORDER);
		tNrTel.setToolTipText("NrTel");
		tNrTel.setBounds(120, 67, 76, 21);
		
		tID = new Text(this, SWT.BORDER);
		tID.setToolTipText("ID");
		tID.setBounds(120, 113, 76, 21);
		
		Button btnAdd = new Button(this, SWT.NONE);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					ClientService.saveClient(Integer.parseInt(tID.getText()), tNume.getText(), tNrTel.getText());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					new GeneralError((Shell)parent, SWT.NONE, "ID must be a number" + e1.getMessage()).open();
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					new GeneralError((Shell)parent, SWT.NONE, "ID duplicat" + e1.getMessage()).open();
				}
			}
		});
		btnAdd.setBounds(121, 156, 75, 25);
		btnAdd.setText("Add");
		
		btnBack = new Button(this, SWT.NONE);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				PageManager.getInstance().changeLayout(MainMenu.class.getName());
			}
		});
		btnBack.setBounds(10, 10, 75, 25);
		btnBack.setText("Back");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
