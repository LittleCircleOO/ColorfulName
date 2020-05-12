package colorfulName;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JScrollPane;

public class AboutWindow extends JDialog {

	/**
	 * ���ڴ���
	 */
	private static final long serialVersionUID = -7173879279892177873L;
	/*��ɫ��ʽ*/
	private Color backgroundcolor = new Color(250, 250, 250);	//���屳����ɫ��ʽ
	private Color buttoncolor = new Color(233, 233, 234);		//��ť������ɫ��ʽ
	private Color buttonentercolor = new Color(201, 202, 203);	//��ť������ɫ��ʽ
	private Color textareacolor = new Color(122, 138, 153);	//�ı��߿򼤻���ɫ��ʽ
	
	/**
	 * Create the dialog.
	 */
	public AboutWindow(Component component) {
		setAlwaysOnTop(true);
		setModal(true);
		getContentPane().setBackground(backgroundcolor);	//���ݱ�����ɫ
		setBackground(backgroundcolor);						//���屳����ɫ
		setTitle("����  ����ɫ ID ���ɹ��ߡ�");					//�������
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//����ر�ģʽ
		setSize(300, 220);									//�����С
		setLocationRelativeTo(component);					//�������
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
		exitbutton.setBounds(214, 154, 60, 27);
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
		linkbutton.setBounds(20, 154, 88, 27);
		getContentPane().add(linkbutton);
		
		JButton updatelogbutton = new JButton("������־");
		updatelogbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				if(updatelogbutton.getText()=="������־") {
					updatelogbutton.setText("����");
					setSize(300,440);
				}
				else if(updatelogbutton.getText()=="����") {
					updatelogbutton.setText("������־");
					setSize(300,220); 
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
		updatelogbutton.setBounds(118, 154, 86, 27);
		getContentPane().add(updatelogbutton);
		
		JButton netdiskbutton = new JButton("��������");
		netdiskbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				/*from https://blog.csdn.net/xingbaozhen1210/article/details/81078101*/
				Desktop desktop = Desktop.getDesktop();				//���������:ת��github
				if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://www.lanzous.com/b0awlzefi"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}										
			}
		});
		netdiskbutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				netdiskbutton.setBackground(buttonentercolor);			//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				netdiskbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		netdiskbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		netdiskbutton.setFocusPainted(false);
		netdiskbutton.setBorderPainted(false);
		netdiskbutton.setBackground(new Color(233, 233, 234));
		netdiskbutton.setBounds(118, 117, 86, 27);
		getContentPane().add(netdiskbutton);
		
		JButton channelbutton = new JButton("bilibili...");
		channelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				/*from https://blog.csdn.net/xingbaozhen1210/article/details/81078101*/
				Desktop desktop = Desktop.getDesktop();				//���������:ת��github
				if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://space.bilibili.com/272324550"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}										
			}
		});
		channelbutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				channelbutton.setBackground(buttonentercolor);			//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				channelbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		channelbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		channelbutton.setFocusPainted(false);
		channelbutton.setBorderPainted(false);
		channelbutton.setBackground(new Color(233, 233, 234));
		channelbutton.setBounds(20, 117, 88, 27);
		getContentPane().add(channelbutton);
		
		
		
		JLabel lblId = new JLabel("<html><body>��ɫ ID ���ɹ��� v1.2<br>�� bilibili Up�� : o0O0o0l0o0O0o ����<br>�������github��Դ<br>��ѭ GPLv3 (ͨ�ù������֤) Э��<br>�������ȫ���,��������!</body></html>");
		lblId.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		lblId.setBounds(20, 10, 254, 100);
		getContentPane().add(lblId);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new MatteBorder(1, 1, 3, 1, textareacolor));
		textPane.setBackground(backgroundcolor);
		textPane.setFont(new Font("˼Դ���� CN", Font.PLAIN, 12));
		textPane.setText("v0.8��\n�����������߼���������\nv0.9��\n�����ı���ʽ�������ڿ�������չʾ��ɫ��\nv1.0��\n���ƹ���ҳ��\n�����Just Shapes & Beats��֧��\n��������ͼ��\nv1.1��\n�޸�ĳЩ�豸��������ȱʧ���µ���ʾ����\n�޸�ȡ����ɫѡ������ϸ���ɫ��ʧ������\n������ɫѡ����������ʾ�ϴ�ѡ�����ɫ��\n���ڸ�����ɫ���Զ�������ɿ�\n���뾵������վ����bilibili����\nv1.2��\nWindows�汾��ʼ�ṩexe��ִ���ļ�\n�Ż�����ɫѡ������������־չʾ");
		textPane.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 202, 254, 189);
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			/*��ʽ�ض���*/
			/**
			 * �Զ����������ʽ
			 * Adapted from: https://www.cnblogs.com/LiuYanYGZ/p/9490880.html
			 */
			private final int thumbWidth = 8;
		    //�ֱ�͸����
		    private final float opaque = 1f;
		    // �ֱ��߿���ɫ
		    private final Color thumbColor = new Color(123, 186, 245);
		    // �ֱ���ɫ
		    private final Color thumbColorFrom = new Color(123, 186, 245);
		    private final Color thumbColorTo = new Color(123, 186, 245);
		    // ������ɫ
		    private final Color backColorFrom = new Color(229, 229, 229);
		    private final Color backColorTo = new Color(229, 229, 229);
		    public Dimension getPreferredSize(JComponent c) {
		    	c.setPreferredSize(new Dimension(thumbWidth, thumbWidth));
		    	return super.getPreferredSize(c);
		    }
		    public void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		    	Graphics2D g2 = (Graphics2D) g;
		    	GradientPaint gp = null;
		    	if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {
		    		gp = new GradientPaint(0, 0, backColorFrom, 0, trackBounds.height, backColorTo);
		    	}
		    	if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL) {
		    		gp = new GradientPaint(0, 0, backColorFrom, trackBounds.width, 0, backColorTo);
		    	}
		    	g2.setPaint(gp);
		    	g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
		    	if (trackHighlight == BasicScrollBarUI.DECREASE_HIGHLIGHT)
		            this.paintDecreaseHighlight(g);
		    	if (trackHighlight == BasicScrollBarUI.INCREASE_HIGHLIGHT)
		    		this.paintIncreaseHighlight(g);
		    }
		    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		    	g.translate(thumbBounds.x, thumbBounds.y);
		    	g.setColor(thumbColor);
		    	g.drawRoundRect(0, 0, thumbBounds.width - 1, thumbBounds.height - 1, 5, 5);
		    	Graphics2D g2 = (Graphics2D) g;
		    	RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    	g2.addRenderingHints(rh);
		    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opaque));
		    	g2.setPaint(new GradientPaint(c.getWidth() / 2, 1, thumbColorFrom, c.getWidth() / 2, c.getHeight(),thumbColorTo));
		    	g2.fillRoundRect(0, 0, thumbBounds.width - 1, thumbBounds.height - 1, 5, 5);
		    }
		    protected JButton createIncreaseButton(int orientation) {
		    	JButton button = new JButton();
		    	button.setBorderPainted(true);
		    	button.setContentAreaFilled(true);
		    	button.setBorder(null);
		    	return button;
		    }
		    protected JButton createDecreaseButton(int orientation) {
		    	JButton button = new JButton();
		    	button.setBorderPainted(true);
		    	button.setContentAreaFilled(true);
		    	button.setFocusable(false);
		    	button.setBorder(null);
		    	return button;
		    }
		});
		scrollPane.setViewportView(textPane);
		getContentPane().add(scrollPane);
	}
}