package net.codebuff.views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;

public class SearchDialog extends Dialog {

	protected Object result;
	protected Shell shlSearchDisabled;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SearchDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlSearchDisabled.open();
		shlSearchDisabled.layout();
		Display display = getParent().getDisplay();
		while (!shlSearchDisabled.isDisposed()) {
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
		shlSearchDisabled = new Shell(getParent(), SWT.DIALOG_TRIM);
		shlSearchDisabled.setToolTipText("");
		shlSearchDisabled.setSize(398, 177);
		shlSearchDisabled.setText("Search Disabled");
		
		CLabel lblNewLabel = new CLabel(shlSearchDisabled, SWT.NONE);
		lblNewLabel.setBounds(34, 10, 337, 127);
		lblNewLabel.setText("search functionality have been disabled temporarily \r\nI will add it in future versions once I have integrated\r\n this app with website\r\n                                                           -----\r\n                                                                            Deepankar Tyagi");

	}
}
