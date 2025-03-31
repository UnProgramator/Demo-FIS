package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import controller.ClientService;
import model.dataclass.ClientModel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ViewClients extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ViewClients(Composite parent, int style) {
		super(parent, style);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(31, 39, 395, 237);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(35);
		tblclmnId.setText("ID");
		
		TableColumn tblclmnNume = new TableColumn(table, SWT.NONE);
		tblclmnNume.setWidth(239);
		tblclmnNume.setText("Nume");
		
		TableColumn tblclmnNrTelefon = new TableColumn(table, SWT.NONE);
		tblclmnNrTelefon.setWidth(119);
		tblclmnNrTelefon.setText("Nr Telefon");
		
		Button btnRefresh = new Button(this, SWT.NONE);
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				populate();
			}
		});
		btnRefresh.setBounds(152, 10, 75, 25);
		btnRefresh.setText("Refresh");
		
		Button btnBack = new Button(this, SWT.NONE);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				PageManager.getInstance().changeLayout(MainMenu.class.getName());
			}
		});
		btnBack.setBounds(10, 10, 75, 25);
		btnBack.setText("Back");
		
		populate();
	}
	
	private void populate() {
		ClientModel[] clis = ClientService.getAllClients();
		
		table.clearAll();
		
		for(ClientModel p: clis){
			TableItem ti = new TableItem(table, SWT.NONE);
			ti.setText(0, Integer.toString(p.id));
			ti.setText(1, p.nume);
			ti.setText(2, p.nrTel);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
