package net.codebuff.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.gudy.azureus2.ui.swt.sharing.ShareUtils;

public class ShareMenu {
	
	public static void addShareMenu(final Menu menuBar){
		MenuItem shareMenu = new MenuItem(menuBar,SWT.CASCADE);
        shareMenu.setText("Share");
		
		Menu Dropmenu = new Menu(shareMenu);
		shareMenu.setMenu(Dropmenu);
		
		MenuItem shareFileMI = new MenuItem(Dropmenu, SWT.NONE);
		shareFileMI.setText("File ");
		shareFileMI.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				ShareUtils.shareFile(menuBar.getShell());
			}
		} );
		
		MenuItem shareFolderMI = new MenuItem(Dropmenu, SWT.NONE);
		shareFolderMI.setText("Folder ");
		shareFolderMI.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				ShareUtils.shareDir(menuBar.getShell());
			}
		} );
		
		
	}

}
