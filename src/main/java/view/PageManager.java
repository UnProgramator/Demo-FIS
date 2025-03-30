package view;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class PageManager {
	String crtActive;
	StackLayout stack;
	HashMap<String, Composite> layouts;
	Shell shell;
	
	public PageManager(Shell shell) {
		this.shell = shell;
		stack = new StackLayout();
		shell.setLayout(stack);
		
		layouts = new HashMap<String, Composite>();
	}
	
	public void changeLayout(String winName) {
		if(crtActive != null)
			layouts.get(crtActive).setVisible(!layouts.get(winName).isVisible());
		stack.topControl = layouts.get(winName);
		crtActive = winName; //set current active windows index
		shell.layout();
	}
	
	private static PageManager _instance;
	
	public static void createInstance(Shell shell) {
		if(_instance == null)
			_instance = new PageManager(shell);
		else
			throw new RuntimeException("PageManager already instantiated");
	}
	
	public static PageManager getInstance() {
		if(_instance == null)
			throw new RuntimeException("Stack not instanciated but used");
		return _instance;
	}
	
	public void addPage(String name, Class<? extends Composite> pageCls, int param) {
		try {
			Constructor<? extends Composite> cons = pageCls.getConstructor(Composite.class, int.class);	
			layouts.put(name, cons.newInstance(shell, param));
		}
		catch(NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void addPage(String name, Class<? extends Composite> pageCls) {		
		addPage(name, pageCls, SWT.NONE);
	}
	
	public void addPage(Class<? extends Composite> pageCls, int param) {		
		addPage(pageCls.getName(), pageCls, param);
	}
	
	public void addPage(Class<? extends Composite> pageCls) {		
		addPage(pageCls.getName(), pageCls, SWT.NONE);
	}
}
