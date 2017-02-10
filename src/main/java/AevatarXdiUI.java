import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

/*
 * Created by JFormDesigner on Wed Feb 08 20:58:33 CET 2017
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;



/**
 * @author wertwer ggsdfbs
 */
public class AevatarXdiUI extends JFrame {
	public AevatarXdiUI() {
		initComponents();
	}

	protected void okButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void jxdButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void xdiButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - wertwer ggsdfbs
		JPanel dialogPane = new JPanel();
		JPanel contentPanel = new JPanel();
		JScrollPane scrollPane1 = new JScrollPane();
		xdiTextPane = new JTextPane();
		JPanel buttonBar = new JPanel();
		JButton xdiButton = new JButton();
		JButton jxdButton = new JButton();
		JButton describeButton = new JButton();
		JButton okButton = new JButton();

		//======== this ========
		setTitle("View XDI");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{

			// JFormDesigner evaluation mark
			dialogPane.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new BorderLayout());

				//======== scrollPane1 ========
				{

					//---- xdiTextPane ----
					xdiTextPane.setFont(new Font("Courier New", Font.BOLD, 16));
					scrollPane1.setViewportView(xdiTextPane);
				}
				contentPanel.add(scrollPane1, BorderLayout.CENTER);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
				((GridBagLayout)buttonBar.getLayout()).rowHeights = new int[] {0, 0, 0};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0E-4};
				((GridBagLayout)buttonBar.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

				//---- xdiButton ----
				xdiButton.setText("XDI");
				xdiButton.addActionListener(e -> xdiButtonActionPerformed(e));
				buttonBar.add(xdiButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));

				//---- jxdButton ----
				jxdButton.setText("JXD");
				jxdButton.addActionListener(e -> jxdButtonActionPerformed(e));
				buttonBar.add(jxdButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));

				//---- describeButton ----
				describeButton.setText("Describe");
				describeButton.addActionListener(e -> okButtonActionPerformed(e));
				buttonBar.add(describeButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));

				//---- okButton ----
				okButton.setText("CLOSE");
				okButton.addActionListener(e -> okButtonActionPerformed(e));
				buttonBar.add(okButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(765, 560);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - wertwer ggsdfbs
	protected JTextPane xdiTextPane;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
