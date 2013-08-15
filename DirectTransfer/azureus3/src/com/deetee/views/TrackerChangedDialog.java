package com.deetee.views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class TrackerChangedDialog extends Dialog {

	protected Object result;
	protected Shell shlPleaseNote;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TrackerChangedDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlPleaseNote.open();
		shlPleaseNote.layout();
		Display display = getParent().getDisplay();
		while (!shlPleaseNote.isDisposed()) {
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
		shlPleaseNote = new Shell(getParent(), SWT.DIALOG_TRIM);
		shlPleaseNote.setSize(440, 191);
		shlPleaseNote.setText("Please Note");
		
		Label lblItSeemsThat = new Label(shlPleaseNote, SWT.NONE);
		lblItSeemsThat.setBounds(30, 20, 394, 133);
		lblItSeemsThat.setText("It seems that  your system ip have changed since you last used Direct \r\nTransfer as result of this all of your PRIVATE transfers have become invalid \r\nwhereas PUBLIC transfers will work fine\r\nplease delete any such transfers and create new private transfers\r\n                                              Sorry for that\r\n\r\nin future versions app will delete such transfers automatically\r\n  // by future version I mean until I learn some more Java //");

	}
}
