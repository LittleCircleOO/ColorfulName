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
		setSize(176, 35);									//窗体大小
		setLocationRelativeTo(null);						//窗体居中
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("正在加载字体文件,请稍后...");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
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