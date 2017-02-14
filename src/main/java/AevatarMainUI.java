

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.ImageIcon;
/*
 * Created by JFormDesigner on Tue Dec 15 11:37:03 CET 2015
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * @author wert wretwert
 */
public class AevatarMainUI extends JFrame {
	public AevatarMainUI() {
		initComponents();
	}

	protected void aliceViewIdentityContainerActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void doctorSendRequestMedicalRecordsActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void aliceViewPendingMessagesActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void aliceModifyPendingMessagesActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void aliceApprovePendingMessagesActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void aliceRejectPendingMessagesActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void doctorSendNewMedicalRecordActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void aliceViewMedicalRecordsActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - wertwer ggsdfbs
		panel2 = new JPanel();
		label8 = new JLabel();
		label5 = new JLabel();
		panel1 = new JPanel();
		aliceViewIdentityContainer = new JButton();
		aliceViewMedicalRecords = new JButton();
		doctorSendRequestMedicalRecords = new JButton();
		aliceViewPendingMessages = new JButton();
		aliceModifyPendingMessages = new JButton();
		aliceApprovePendingMessages = new JButton();
		aliceRejectPendingMessages = new JButton();
		doctorSendNewMedicalRecord = new JButton();

		//======== this ========
		setTitle("Aevatar Test");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel2 ========
		{

			// JFormDesigner evaluation mark
			panel2.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel2.setLayout(new FlowLayout());

			//---- label8 ----
			label8.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
			panel2.add(label8);

			//---- label5 ----
			label5.setText("Mobile Aevatar");
			label5.setFont(new Font("Cantarell", Font.PLAIN, 26));
			panel2.add(label5);
		}
		contentPane.add(panel2, BorderLayout.NORTH);

		//======== panel1 ========
		{
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

			//---- aliceViewIdentityContainer ----
			aliceViewIdentityContainer.setText("Alice: View Identity Container");
			aliceViewIdentityContainer.addActionListener(e -> aliceViewIdentityContainerActionPerformed(e));
			panel1.add(aliceViewIdentityContainer, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- aliceViewMedicalRecords ----
			aliceViewMedicalRecords.setText("Alice: View Medical Records");
			aliceViewMedicalRecords.addActionListener(e -> aliceViewMedicalRecordsActionPerformed(e));
			panel1.add(aliceViewMedicalRecords, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- doctorSendRequestMedicalRecords ----
			doctorSendRequestMedicalRecords.setText("Doctor: Send Request for Medical Records");
			doctorSendRequestMedicalRecords.addActionListener(e -> doctorSendRequestMedicalRecordsActionPerformed(e));
			panel1.add(doctorSendRequestMedicalRecords, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- aliceViewPendingMessages ----
			aliceViewPendingMessages.setText("Alice: View Pending Messages");
			aliceViewPendingMessages.addActionListener(e -> aliceViewPendingMessagesActionPerformed(e));
			panel1.add(aliceViewPendingMessages, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- aliceModifyPendingMessages ----
			aliceModifyPendingMessages.setText("Alice: Modify Pending Messages");
			aliceModifyPendingMessages.setEnabled(false);
			aliceModifyPendingMessages.addActionListener(e -> aliceModifyPendingMessagesActionPerformed(e));
			panel1.add(aliceModifyPendingMessages, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- aliceApprovePendingMessages ----
			aliceApprovePendingMessages.setText("Alice: Approve Pending Messages");
			aliceApprovePendingMessages.addActionListener(e -> aliceApprovePendingMessagesActionPerformed(e));
			panel1.add(aliceApprovePendingMessages, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- aliceRejectPendingMessages ----
			aliceRejectPendingMessages.setText("Alice: Reject Pending Messages");
			aliceRejectPendingMessages.addActionListener(e -> aliceRejectPendingMessagesActionPerformed(e));
			panel1.add(aliceRejectPendingMessages, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- doctorSendNewMedicalRecord ----
			doctorSendNewMedicalRecord.setText("Doctor: Send New Medical Record");
			doctorSendNewMedicalRecord.addActionListener(e -> doctorSendNewMedicalRecordActionPerformed(e));
			panel1.add(doctorSendNewMedicalRecord, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, BorderLayout.CENTER);
		setSize(800, 520);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - wertwer ggsdfbs
	protected JPanel panel2;
	protected JLabel label8;
	protected JLabel label5;
	protected JPanel panel1;
	protected JButton aliceViewIdentityContainer;
	protected JButton aliceViewMedicalRecords;
	protected JButton doctorSendRequestMedicalRecords;
	protected JButton aliceViewPendingMessages;
	protected JButton aliceModifyPendingMessages;
	protected JButton aliceApprovePendingMessages;
	protected JButton aliceRejectPendingMessages;
	protected JButton doctorSendNewMedicalRecord;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
