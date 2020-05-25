package hotelsys;

import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.event.*;

public class QueryPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblRoomId, lbsSize, lblPrice, lblCheckin, lblRoomType;
	private JTextField txtRoomId;
	private RoomManage roomManage;

	public QueryPanel() {
		roomManage = new RoomManage();
		try {
			roomManage.LoadRoom();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setLayout(new GridLayout(8, 1));
		JPanel panel = new JPanel();
		lblRoomId = new JLabel("�����ţ�");
		txtRoomId = new JTextField(6);
		panel.add(lblRoomId);
		panel.add(txtRoomId);

		lbsSize = new JLabel("�����С��");
		lblPrice = new JLabel("����۸�");
		lblCheckin = new JLabel("��ס�����");
		lblRoomType = new JLabel("�������ͣ�");
		lbsSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckin.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomType.setHorizontalAlignment(SwingConstants.CENTER);

		txtRoomId.getDocument().addDocumentListener(new TextFieldListener());
		this.add(panel);
		this.add(lbsSize);
		this.add(lblPrice);
		this.add(lblCheckin);
		this.add(lblRoomType);
	}

	private class TextFieldListener implements DocumentListener {
		@Override
		public void insertUpdate(DocumentEvent e) {
			String roomId = txtRoomId.getText().trim();
			Room room = roomManage.QueryInfo(roomId);
			if (null == room) {
				// �����Ų�����, ��ѯ������Ӧ����Ϣ, ���½�����ϢΪ��
				lbsSize.setText("�����С��");
				lblPrice.setText("����۸�");
				lblCheckin.setText("��ס�����");
				lblRoomType.setText("�������ͣ�");
			} else {
				// ���½�����Ϣ
				lbsSize.setText("�����С��" + room.getSize());
				lblPrice.setText("����۸�" + room.getPrice());
				lblCheckin.setText("��ס�����" + (0 == room.getCheckIn() ? "����" : "����ס"));
				lblRoomType.setText("�������ͣ�" + (0 == room.getRoomType() ? "���˷�" : (1 == room.getRoomType() ? "˫�˷�" : "�����󴲷�")));
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// nothing to do
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// nothing to do
		}
	}
}
