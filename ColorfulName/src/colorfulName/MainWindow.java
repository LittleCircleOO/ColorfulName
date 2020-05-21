package colorfulName;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class MainWindow extends JFrame {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 2836476333100030704L;

	/*ճ������ from https://blog.csdn.net/xietansheng/article/details/70478266*/
	public static String getClipboardString() {
		// ��ȡϵͳ������
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// ��ȡ�������е�����
		Transferable trans = clipboard.getContents(null);
		if (trans != null) {
			// �жϼ������е������Ƿ�֧���ı�
			if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				try {
					// ��ȡ�������е��ı�����
					String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
					return text;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/*���ƺ��� from https://blog.csdn.net/xietansheng/article/details/70478266*/
	public static void setClipboardString(String text) {
        // ��ȡϵͳ������
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // ��װ�ı�����
        Transferable trans = new StringSelection(text);
        // ���ı��������õ�ϵͳ������
        clipboard.setContents(trans, null);
    }
	
	/*RGBת��HEX���� from https://blog.csdn.net/typa01_kk/article/details/46673187*/
	private static String toHexFromColor(Color color){
		String r,g,b;
		StringBuilder su = new StringBuilder();
		r = Integer.toHexString(color.getRed());
		g = Integer.toHexString(color.getGreen());
		b = Integer.toHexString(color.getBlue());
		r = r.length() == 1 ? "0" + r : r;
		g = g.length() ==1 ? "0" +g : g;
		b = b.length() == 1 ? "0" + b : b;
		r = r.toUpperCase();
		g = g.toUpperCase();
		b = b.toUpperCase();
		su.append("#");
		su.append(r);
		su.append(g);
		su.append(b);
		return su.toString();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {			//���г���
		createfont();		//��������
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow dialog = new MainWindow();
					dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	
	/*ȫ�ֱ���*/
	private JTextField originalname;		//ԭʼ�����ı���
	private JLabel tip3;					//��ɫ��ʾ��ǩ
	Color color;							//ѡ����ɫ
	private JTextField newname;				//�������ı���
	JButton printbutton;
	JRadioButton humanfallflat;
	JRadioButton jsb;
	static LoadingWindow loadingtip = new LoadingWindow();		//���ؿ�
	JLabel tip5;		//Ч��Ԥ��
	
	/*�����ť������*/
	MouseAdapter printbuttonadapter = new MouseAdapter() {		//�����ť��괥��Ч��
		@Override
		public void mouseEntered(MouseEvent arg0) {				//�������
			printbutton.setBackground(buttonentercolor);		//���������ʽ
		}
		@Override
		public void mouseExited(MouseEvent e) {					//����Ƴ�
			printbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
		}
	};
	ActionListener printbuttonclick = new ActionListener() {							//�����ť���������
		public void actionPerformed(ActionEvent arg0) {
			if(humanfallflat.isSelected()==true && jsb.isSelected()==false)				//��ʽһ<color=#000000>����</color>
				newname.setText("<color="+toHexFromColor(color)+">"+originalname.getText()+"</color>");	//���������:�����ı�
			else if(humanfallflat.isSelected()==false && jsb.isSelected()==true)		//��ʽ��<#000000>����
				newname.setText("<"+toHexFromColor(color)+">"+originalname.getText());	//���������:�����ı�
			tip5.setText(originalname.getText());
			tip5.setForeground(color);
		}
	};
		
	/*��ɫ��ʽ*/
	private Color backgroundcolor = new Color(250, 250, 250);	//���屳����ɫ��ʽ
	private Color buttoncolor = new Color(233, 233, 234);		//��ť������ɫ��ʽ
	private Color buttonentercolor = new Color(201, 202, 203);	//��ť������ɫ��ʽ
	private Color textlinepresscolor = new Color(0, 188, 212);	//�ı��߿򼤻���ɫ��ʽ
	private Color textlinecolor = new Color(231, 231, 232);		//�ı��߿���ɫ��ʽ
	
	/*ͼ����ʽ*/
	private ImageIcon uncheckedbutton = new ImageIcon(MainWindow.class.getResource("uncheckedbutton.png"));		//��ѡ��ťδѡ��
	private ImageIcon checkedbutton = new ImageIcon(MainWindow.class.getResource("checkedbutton.png"));			//��ѡ��ť��ѡ��
	private ImageIcon exeicon = new ImageIcon(MainWindow.class.getResource("icon.png"));
	private Image exeimage = exeicon.getImage();
	
	/*������ʽ*/
	private static void createfont() {
		loadingtip.setVisible(true);
		//JOptionPane.showMessageDialog(null,"���ڼ��������ļ�,���Ժ�","���Ժ�...",JOptionPane.PLAIN_MESSAGE);
		GraphicsEnvironment ge = null;
		try{
			ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, MainWindow.class.getResourceAsStream("SourceHanSansCN-Light.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, MainWindow.class.getResourceAsStream("SourceHanSansCN-Regular.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, MainWindow.class.getResourceAsStream("SourceHanSansCN-Medium.ttf")));
		} catch(FontFormatException e){} catch (IOException e){}
        loadingtip.dispose ();
	}
	
	public MainWindow() {
		/*ȫ����ʽ����*/
		UIManager.put("Button.select", new Color(191, 191, 192));						//��ť����ȫ����ɫ�޸�
		UIManager.put("Button.background", new Color(233, 233, 234));					//��ť����
		UIManager.put("RadioButton.font", new Font("˼Դ���� CN Medium", Font.PLAIN, 13));//��ѡ��ť����
		UIManager.put("RadioButton.background", new Color(250, 250, 250));				//��ѡ��ť����
		UIManager.put("RadioButton.icon", new MyRadiobuttonIcon());						//��ѡ��ťͼ��
		UIManager.put("TabbedPane.font", new Font("˼Դ���� CN", Font.PLAIN, 12));		//��ǩ����
		UIManager.put("TabbedPane.background", new Color(210, 210, 210));				//δѡ�б�ǩ����
		UIManager.put("TabbedPane.selected", new Color(250, 250, 250));					//ѡ�б�ǩ����
		UIManager.put("TabbedPane.focus", new Color(250, 250, 250));					//��ǩ�۽�����ɫ
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));		//��ǩ���
		UIManager.put("TitledBorder.font", new Font("˼Դ���� CN Medium", Font.PLAIN, 12));//�������
		UIManager.put("Slider.background", new Color(250, 250, 250));					//���˱���
		UIManager.put("Slider.horizontalThumbIcon", new ImageIcon(MainWindow.class.getResource("sliderthumbflat.png")));	//����ͼ��
		UIManager.put("Button.font", new Font("˼Դ���� CN Medium", Font.PLAIN, 13));		//��ť����
		UIManager.put("Label.font", new Font("˼Դ���� CN Medium", Font.PLAIN, 13));		//�ı���ʾ����
		UIManager.put("Panel.background", new Color(250, 250, 250));					//���屳��
		UIManager.put("ToolTip.background", new Color(250, 250, 250));					//��ʾ�򱳾�
		UIManager.put("ToolTip.foreground", new Color(71, 102, 132));					//��ʾ��������ɫ
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage("src\\icon.png"));
		setIconImage(exeimage);								//����ͼ��
		getContentPane().setBackground(backgroundcolor);	//���ݱ�����ɫ
		setBackground(backgroundcolor);						//���屳����ɫ
		setTitle("��ɫID���ɹ���v1.3  by o0O0o0l0o0O0o");		//�������
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//����ر�ģʽ
		setSize(400, 330);									//�����С
		setLocationRelativeTo(null);						//�������
		getContentPane().setLayout(null);					//���岼��
		setResizable(false);								//�����������
		
		/*��ǩ1*/
		JLabel tip1 = new JLabel("��һ���������ת��������");		//��ǩ����
		tip1.setFont(new Font("˼Դ���� CN", Font.PLAIN, 14));	//��ǩ����
		tip1.setBounds(20, 10, 168, 21);						//��ǩ����
		getContentPane().add(tip1);								//��ӿؼ�
		
		/*ԭʼ�����ı���*/
		originalname = new JTextField();													//�ı���
		originalname.addFocusListener(new FocusAdapter() {									//����
			@Override
			public void focusGained(FocusEvent arg0) {										//��ý���
				originalname.setBorder(new MatteBorder(0, 0, 2, 0, textlinepresscolor));	//��ý�����ʽ
			}
			@Override
			public void focusLost(FocusEvent e) {											//ʧȥ����
				originalname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));			//ʧȥ������ʽ
			}
		});
		originalname.setBackground(backgroundcolor);										//�ı��򱳾���ɫ
		originalname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));					//�ı���������ɫ
		originalname.setFont(new Font("˼Դ���� CN", Font.PLAIN, 14));						//�ı�������
		originalname.setBounds(20, 35, 212, 27);											//�ı��򲼾�
		getContentPane().add(originalname);													//��ӿؼ�
		originalname.setColumns(10);														//ָ������
		
		/*ճ����ť*/
		JButton pastebutton = new JButton("ճ��");					//��ť����
		pastebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//�����
				String pastestring = getClipboardString();			//���������1:��ȡ������
				originalname.setText(pastestring);					//���������2:ճ���ı�
			}
		});
		pastebutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				pastebutton.setBackground(buttonentercolor);		//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				pastebutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		pastebutton.setBorderPainted(false);						//�ޱ߿�
		pastebutton.setFocusPainted(false);							//�޽���ָʾ
		pastebutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));	//��ť����
		pastebutton.setBackground(buttoncolor);						//��ť������ɫ
		pastebutton.setBounds(238, 35, 65, 27);						//��ť����
		getContentPane().add(pastebutton);							//��ӿؼ�
		
		/*��հ�ť*/
		JButton clearbutton = new JButton("���");					//��ť����
		clearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				originalname.setText(null);							//���������:����ı�
			}
		});
		clearbutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				clearbutton.setBackground(buttonentercolor);		//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				clearbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		clearbutton.setBorderPainted(false);						//�ޱ߿�
		clearbutton.setFocusPainted(false);							//�޽���ָʾ
		clearbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));	//��ť����
		clearbutton.setBackground(buttoncolor);						//��ť������ɫ
		clearbutton.setBounds(308, 35, 65, 27);						//��ť����
		getContentPane().add(clearbutton);							//��ӿؼ�
		
		/*��ǩ2*/
		JLabel tip2 = new JLabel("�ڶ�����ѡ����ɫ����Ϸ");			//��ǩ����
		tip2.setFont(new Font("˼Դ���� CN", Font.PLAIN, 14));	//��ǩ����
		tip2.setBounds(20, 80, 154, 21);						//��ǩ����
		getContentPane().add(tip2);								//��ӿؼ�
		
		/*��ɫѡ��ť*/
		JButton choosecolor = new JButton("ѡ����ɫ...");				//��ť����
		choosecolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				Color getcolor = CustomColorChooser.showDialog(getContentPane(), "ѡ����ɫ...", color);//��ɫѡ��
				if(getcolor == null && color == null) {								//���1:��һ��ûѡ����ɫ
					tip3.setText("��ѡ����ɫ");
					tip3.setFont(new Font("˼Դ���� CN Light", Font.PLAIN, 14));
					printbutton.setText("δѡ����ɫ");
					printbutton.removeActionListener(printbuttonclick);
					printbutton.removeMouseListener(printbuttonadapter);
					printbutton.setForeground(Color.GRAY);
					tip3.setForeground(Color.BLACK);
				}
				else if(getcolor != null) {											//���2:ѡ������ɫ
					color = getcolor;
					tip3.setText("��ѡ�����ɫ��:"+toHexFromColor(color));
					tip3.setFont(new Font("˼Դ���� CN Medium", Font.PLAIN, 14));
					printbutton.setText("һ������");
					printbutton.addActionListener(printbuttonclick);
					printbutton.addMouseListener(printbuttonadapter);
					printbutton.setForeground(Color.BLACK);
					tip3.setForeground(color);
					newname.setText(null);
					tip5.setText("Ч��Ԥ��");
					tip5.setForeground(Color.BLACK);
				}
				else if(getcolor == null && color != null){							//���3:�ڶ����Ժ�ûѡ����ɫ,����֮ǰ����ɫ
					tip3.setText("��ѡ�����ɫ��:"+toHexFromColor(color));
					tip3.setFont(new Font("˼Դ���� CN Medium", Font.PLAIN, 14));
					printbutton.setText("һ������");
					printbutton.addActionListener(printbuttonclick);
					printbutton.addMouseListener(printbuttonadapter);
					printbutton.setForeground(Color.BLACK);
					tip3.setForeground(color);
				}
			}
		});
		choosecolor.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				choosecolor.setBackground(buttonentercolor);		//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				choosecolor.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		choosecolor.setBorderPainted(false);
		choosecolor.setFocusPainted(false);
		choosecolor.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		choosecolor.setBackground(buttoncolor);
		choosecolor.setBounds(20, 104, 100, 26);
		getContentPane().add(choosecolor);
		
		/*��ǩ3:��ɫ��ʾ��ǩ*/
		tip3 = new JLabel("��ѡ����ɫ");
		tip3.setForeground(Color.BLACK);
		tip3.setFont(new Font("˼Դ���� CN Light", Font.PLAIN, 14));
		tip3.setBounds(130, 106, 243, 21);
		getContentPane().add(tip3);
		
		/*��Ϸѡ��ѡ��ť*/
		humanfallflat = new JRadioButton("����һ��Ϳ��");
		humanfallflat.setSelected(true);
		humanfallflat.setBackground(backgroundcolor);
		humanfallflat.setFocusPainted(false);
		humanfallflat.setIcon(uncheckedbutton);
		humanfallflat.setSelectedIcon(checkedbutton);
		humanfallflat.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		humanfallflat.setBounds(20, 133, 110, 23);
		getContentPane().add(humanfallflat);
		
		jsb = new JRadioButton("Just Shapes & Beats");
		jsb.setBackground(backgroundcolor);
		jsb.setFocusPainted(false);
		jsb.setIcon(uncheckedbutton);
		jsb.setSelectedIcon(checkedbutton);
		jsb.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		jsb.setBackground(new Color(250, 250, 250));
		jsb.setBounds(140, 133, 180, 23);
		getContentPane().add(jsb);
		
		ButtonGroup group=new ButtonGroup();
		group.add(humanfallflat);
		group.add(jsb);
		
		/*��ǩ4*/
		JLabel tip4 = new JLabel("�����������ɴ�����ɫ���Ե�������");
		tip4.setFont(new Font("˼Դ���� CN", Font.PLAIN, 14));
		tip4.setBounds(20, 155, 224, 21);
		getContentPane().add(tip4);
		
		printbutton = new JButton("δѡ����ɫ");
		printbutton.setForeground(Color.GRAY);
		printbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		printbutton.setFocusPainted(false);
		printbutton.setBorderPainted(false);
		printbutton.setBackground(buttoncolor);
		printbutton.setBounds(20, 181, 100, 27);
		getContentPane().add(printbutton);
		
		JButton copybutton = new JButton("����");
		copybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				setClipboardString(newname.getText());				//���������:�����ı�
			}
		});
		copybutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				copybutton.setBackground(buttonentercolor);			//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				copybutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		copybutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		copybutton.setFocusPainted(false);
		copybutton.setBorderPainted(false);
		copybutton.setBackground(buttoncolor);
		copybutton.setBounds(123, 181, 65, 27);
		getContentPane().add(copybutton);
		
		newname = new JTextField();
		newname.addFocusListener(new FocusAdapter() {									//����
			@Override
			public void focusGained(FocusEvent arg0) {										//��ý���
				newname.setBorder(new MatteBorder(0, 0, 2, 0, textlinepresscolor));	//��ý�����ʽ
			}
			@Override
			public void focusLost(FocusEvent e) {											//ʧȥ����
				newname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));			//ʧȥ������ʽ
			}
		});
		newname.setBackground(backgroundcolor);
		newname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));
		newname.setFont(new Font("˼Դ���� CN", Font.PLAIN, 14));
		newname.setBounds(20, 214, 353, 27);
		getContentPane().add(newname);
		newname.setColumns(10);
		
		JButton aboutbutton = new JButton("����");
		aboutbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//�����
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AboutWindow dialog = new AboutWindow(getContentPane());
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		aboutbutton.addMouseListener(new MouseAdapter() {			//��궯��
			@Override
			public void mouseEntered(MouseEvent arg0) {				//�������
				aboutbutton.setBackground(buttonentercolor);		//���������ʽ
			}
			@Override
			public void mouseExited(MouseEvent e) {					//����Ƴ�
				aboutbutton.setBackground(buttoncolor);				//����Ƴ���ʽ
			}
		});
		aboutbutton.setFont(new Font("˼Դ���� CN", Font.PLAIN, 13));
		aboutbutton.setFocusPainted(false);
		aboutbutton.setBorderPainted(false);
		aboutbutton.setBackground(buttoncolor);
		aboutbutton.setBounds(244, 264, 65, 27);
		getContentPane().add(aboutbutton);
		
		JButton exitbutton = new JButton("�˳�");
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
		exitbutton.setBounds(319, 264, 65, 27);
		getContentPane().add(exitbutton);
		
		tip5 = new JLabel("Ч��Ԥ��");
		tip5.setFont(new Font("˼Դ���� CN Medium", Font.PLAIN, 20));
		tip5.setBounds(20, 251, 212, 40);
		getContentPane().add(tip5);
	}
}
