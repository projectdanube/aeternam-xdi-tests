

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import xdi2.core.Graph;
import xdi2.core.io.MimeType;
import xdi2.core.io.XDIWriterRegistry;

public class AevatarXdi extends AevatarXdiUI {

	private Graph g;
	private String description;

	public AevatarXdi(Graph g, String description) {

		super();

		initComponents();

		this.g = g;
		this.description = description;
		this.viewXDI();
	}

	@Override
	protected void xdiButtonActionPerformed(ActionEvent e) {

		this.viewXDI();
	}

	@Override
	protected void jxdButtonActionPerformed(ActionEvent e) {

		this.viewJXD();
	}

	@Override
	protected void describeButtonActionPerformed(ActionEvent e) {

		this.viewDescribe();
	}

	@Override
	protected void okButtonActionPerformed(ActionEvent e) {

		this.dispose();
	}

	private void viewXDI() {

		StringWriter w = new StringWriter();
		try {
			XDIWriterRegistry.forFormat("XDI DISPLAY", null).write(this.g, w);
		} catch (IOException ex) {
			this.error(ex);
		}
		this.xdiTextPane.setText(w.toString());
	}

	private void viewJXD() {

		StringWriter w = new StringWriter();
		try {
			XDIWriterRegistry.forMimeType(new MimeType("application/xdi+jxd;pretty=1")).write(this.g, w);
		} catch (IOException ex) {
			this.error(ex);
		}
		this.xdiTextPane.setText(w.toString());
	}

	private void viewDescribe() {

		this.xdiTextPane.setText(this.description);
	}

	private void initComponents() {

		Util.initJFrame(this);
	}

	private void error(Exception ex) {

		JOptionPane.showMessageDialog(null, (ex.getMessage() != null && ex.getMessage().length() > 1) ? ex.getMessage() : ex.getClass().getName());
	}
}
