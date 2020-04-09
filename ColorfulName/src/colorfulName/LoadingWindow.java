package colorfulName;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class LoadingWindow extends JDialog {

	public LoadingWindow() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		setSize(176, 35);									//�����С
		setLocationRelativeTo(null);						//�������
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("���ڼ��������ļ�,���Ժ�...");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel.setBackground(new Color(250, 250, 250));
		lblNewLabel.setBounds(10, 10, 156, 15);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 176, 35);
		panel.setBackground(new Color(250, 250, 250));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 188, 212)));
		getContentPane().add(panel);
		
	}
}