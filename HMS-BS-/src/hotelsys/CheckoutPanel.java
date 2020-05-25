package hotelsys;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CheckoutPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblRoomId, lblPrice, lblStartTime, lblCustomerId;
	private JLabel lblRoomFee;
	private JTextField txtRoomId, txtCustomerId;
	private RoomManage roomManage;
	private CheckinRecordManage checkinRecordManage;
	private JButton btnConfirm;

	public CheckoutPanel() {
		roomManage = new RoomManage();
		try {
			roomManage.LoadRoom();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		checkinRecordManage = new CheckinRecordManage();
		try {
			checkinRecordManage.LoadRecords();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.setLayout(new GridLayout(8, 1));
		JPanel panel1 = new JPanel();
		lblRoomId = new JLabel("�����ţ�");
		txtRoomId = new JTextField(6);
		panel1.add(lblRoomId);
		panel1.add(txtRoomId);
		txtRoomId.getDocument().addDocumentListener(new TextFieldListener());

		JPanel panel2 = new JPanel();
		lblCustomerId = new JLabel("���֤�ţ�");
		txtCustomerId = new JTextField(6);
		panel2.add(lblCustomerId);
		panel2.add(txtCustomerId);
		txtCustomerId.getDocument().addDocumentListener(new TextFieldListener());

		lblPrice = new JLabel("����۸�");
		lblStartTime = new JLabel("��סʱ�䣺");
		lblRoomFee = new JLabel("���ѣ�");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomFee.setHorizontalAlignment(SwingConstants.CENTER);

		btnConfirm = new JButton("ȷ��");
		btnConfirm.addActionListener(new BtnActionListener());

		this.add(panel1);
		this.add(panel2);
		this.add(lblPrice);
		this.add(lblStartTime);
		this.add(lblRoomFee);
		this.add(btnConfirm);
		this.add(Box.createRigidArea(new Dimension(400, 40)));
	}

	private class BtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ����ס����¼ �� ������Ϣ
			String roomId = txtRoomId.getText().trim();
			String customerId = txtCustomerId.getText().trim();
			checkinRecordManage.CloseRoom(customerId, roomId);
			roomManage.ActiveRoom(roomId);
			JOptionPane.showMessageDialog(null, "�˷��ɹ�");
		}
	}

	private class TextFieldListener implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			String roomId = txtRoomId.getText().trim();
			String customerId = txtCustomerId.getText().trim(); 
			System.out.println("insertUpdate: roomId=" + roomId + ", customerId=" + customerId);
			Room room = roomManage.QueryInfo(roomId);
			CheckinRecord record = checkinRecordManage.QueryInfo(customerId, roomId);
			if (null != room && null != record) {
				lblPrice.setText("����۸�" + room.getPrice());
				lblStartTime.setText("��סʱ�䣺" + record.getCheckinTime());
//				lblRoomFee = new JLabel("���ѣ�" + );
			}
			else {
				if (null == record) {
					lblStartTime.setText("��סʱ�䣺");
				}
				if (null == room) {
					lblPrice.setText("����۸�");
				}
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}

	}
}
