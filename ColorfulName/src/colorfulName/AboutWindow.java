package colorfulName;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

public class AboutWindow extends JDialog {

	/*��ɫ��ʽ*/
	private Color backgroundcolor = new Color(250, 250, 250);	//���屳����ɫ��ʽ
	private Color buttoncolor = new Color(233, 233, 234);		//��ť������ɫ��ʽ
	private Color buttonentercolor = new Color(201, 202, 203);	//��ť������ɫ��ʽ
	private Color textareacolor = new Color(122, 138, 153);	//�ı��߿򼤻���ɫ��ʽ
	
	/**
	 * Create the dialog.
	 */
	public AboutWindow() {
		setAlwaysOnTop(true);
		setModal(true);
		getContentPane().setBackground(backgroundcolor);	//���ݱ�����ɫ
		setBackground(backgroundcolor);						//���屳����ɫ
		setTitle("����  ����ɫ ID ���ɹ��ߡ�");					//�������
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//����ر�ģʽ
		setSize(300, 200);									//�����С
		setLocationRelativeTo(null);						//�������
		getContentPane().setLayout(null);					//���岼��
		setResizable(false);								//�����������
		
		JButton exitbutton = new JButton("�ر�");
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				dispose();											//���������:�˳�����
			}
		});
		exitbutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				exitbutton.setBackground(buttonentercolor);			//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				exitbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		exitbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		exitbutton.setFocusPainted(false);
		exitbutton.setBorderPainted(false);
		exitbutton.setBackground(buttoncolor);
		exitbutton.setBounds(213, 134, 60, 27);
		getContentPane().add(exitbutton);
		
		JButton linkbutton = new JButton("Github...");
		linkbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				/*from https://blog.csdn.net/xingbaozhen1210/article/details/81078101*/
				Desktop desktop = Desktop.getDesktop();				//���������:ת��github
				if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://github.com/LittleCircleOO/ColorfulName"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}										
			}
		});
		linkbutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				linkbutton.setBackground(buttonentercolor);			//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				linkbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		linkbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		linkbutton.setFocusPainted(false);
		linkbutton.setBorderPainted(false);
		linkbutton.setBackground(new Color(233, 233, 234));
		linkbutton.setBounds(115, 134, 88, 27);
		getContentPane().add(linkbutton);
		
		JButton updatelogbutton = new JButton("������־");
		updatelogbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				if(updatelogbutton.getText()=="������־") {
					updatelogbutton.setText("����");
					setSize(300,400);
				}
				else if(updatelogbutton.getText()=="����") {
					updatelogbutton.setText("������־");
					setSize(300,200); 
				}
			}
		});
		updatelogbutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				updatelogbutton.setBackground(buttonentercolor);			//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				updatelogbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		updatelogbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		updatelogbutton.setFocusPainted(false);
		updatelogbutton.setBorderPainted(false);
		updatelogbutton.setBackground(new Color(233, 233, 234));
		updatelogbutton.setBounds(19, 134, 86, 27);
		getContentPane().add(updatelogbutton);
		
		JLabel lblId = new JLabel("<html><body>��ɫ ID ���ɹ��� v1.0<br>�� bilibili Up�� : o0O0o0l0o0O0o ����<br>��������github��Դ<br>��ѭ GPL(ͨ�ù�������֤) v3 Э��<br>��������ȫ���,��������!</body></html>");
		lblId.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		lblId.setBounds(20, 10, 254, 114);
		getContentPane().add(lblId);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new MatteBorder(1, 1, 3, 1, textareacolor));
		textPane.setBackground(backgroundcolor);
		textPane.setFont(new Font("˼Դ���� CN", Font.PLAIN, 12));
		textPane.setText("v1.0��\n���ƹ���ҳ��\n�����Just Shapes & Beats��֧��\n��������ͼ��\nv0.9��\n�����ı���ʽ�������ڿ�������չʾ��ɫ��\nv0.8��\n�����������߼���������");
		textPane.setEditable(false);
		textPane.setBounds(19, 171, 255, 179);
		getContentPane().add(textPane);
	}
}