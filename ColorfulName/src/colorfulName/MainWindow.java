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
	 * 主窗口
	 */
	private static final long serialVersionUID = 2836476333100030704L;

	/*粘贴函数 from https://blog.csdn.net/xietansheng/article/details/70478266*/
	public static String getClipboardString() {
		// 获取系统剪贴板
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// 获取剪贴板中的内容
		Transferable trans = clipboard.getContents(null);
		if (trans != null) {
			// 判断剪贴板中的内容是否支持文本
			if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				try {
					// 获取剪贴板中的文本内容
					String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
					return text;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/*复制函数 from https://blog.csdn.net/xietansheng/article/details/70478266*/
	public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }
	
	/*RGB转换HEX函数 from https://blog.csdn.net/typa01_kk/article/details/46673187*/
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
	public static void main(String[] args) {			//运行程序
		createfont();		//加载字体
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
	
	/*全局变量*/
	private JTextField originalname;		//原始名字文本框
	private JLabel tip3;					//颜色提示标签
	Color color;							//选定颜色
	private JTextField newname;				//新名字文本框
	JButton printbutton;
	JRadioButton humanfallflat;
	JRadioButton jsb;
	static LoadingWindow loadingtip = new LoadingWindow();		//加载框
	JLabel tip5;		//效果预览
	
	/*输出按钮触发器*/
	MouseAdapter printbuttonadapter = new MouseAdapter() {		//输出按钮鼠标触发效果
		@Override
		public void mouseEntered(MouseEvent arg0) {				//鼠标移入
			printbutton.setBackground(buttonentercolor);		//鼠标移入样式
		}
		@Override
		public void mouseExited(MouseEvent e) {					//鼠标移出
			printbutton.setBackground(buttoncolor);				//鼠标移出样式
		}
	};
	ActionListener printbuttonclick = new ActionListener() {							//输出按钮鼠标点击触发
		public void actionPerformed(ActionEvent arg0) {
			if(humanfallflat.isSelected()==true && jsb.isSelected()==false)				//格式一<color=#000000>名字</color>
				newname.setText("<color="+toHexFromColor(color)+">"+originalname.getText()+"</color>");	//鼠标点击动作:生成文本
			else if(humanfallflat.isSelected()==false && jsb.isSelected()==true)		//格式二<#000000>名字
				newname.setText("<"+toHexFromColor(color)+">"+originalname.getText());	//鼠标点击动作:生成文本
			tip5.setText(originalname.getText());
			tip5.setForeground(color);
		}
	};
		
	/*颜色样式*/
	private Color backgroundcolor = new Color(250, 250, 250);	//窗体背景颜色样式
	private Color buttoncolor = new Color(233, 233, 234);		//按钮正常颜色样式
	private Color buttonentercolor = new Color(201, 202, 203);	//按钮经过颜色样式
	private Color textlinepresscolor = new Color(0, 188, 212);	//文本边框激活颜色样式
	private Color textlinecolor = new Color(231, 231, 232);		//文本边框颜色样式
	
	/*图标样式*/
	private ImageIcon uncheckedbutton = new ImageIcon(MainWindow.class.getResource("uncheckedbutton.png"));		//单选按钮未选择
	private ImageIcon checkedbutton = new ImageIcon(MainWindow.class.getResource("checkedbutton.png"));			//单选按钮已选择
	private ImageIcon exeicon = new ImageIcon(MainWindow.class.getResource("icon.png"));
	private Image exeimage = exeicon.getImage();
	
	/*字体样式*/
	private static void createfont() {
		loadingtip.setVisible(true);
		//JOptionPane.showMessageDialog(null,"正在加载字体文件,请稍后","请稍后...",JOptionPane.PLAIN_MESSAGE);
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
		/*全局样式控制*/
		UIManager.put("Button.select", new Color(191, 191, 192));						//按钮按下全局颜色修改
		UIManager.put("Button.background", new Color(233, 233, 234));					//按钮正常
		UIManager.put("RadioButton.font", new Font("思源黑体 CN Medium", Font.PLAIN, 13));//单选按钮字体
		UIManager.put("RadioButton.background", new Color(250, 250, 250));				//单选按钮背景
		UIManager.put("RadioButton.icon", new MyRadiobuttonIcon());						//单选按钮图标
		UIManager.put("TabbedPane.font", new Font("思源黑体 CN", Font.PLAIN, 12));		//标签字体
		UIManager.put("TabbedPane.background", new Color(210, 210, 210));				//未选中标签背景
		UIManager.put("TabbedPane.selected", new Color(250, 250, 250));					//选中标签背景
		UIManager.put("TabbedPane.focus", new Color(250, 250, 250));					//标签聚焦点颜色
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));		//标签框框
		UIManager.put("TitledBorder.font", new Font("思源黑体 CN Medium", Font.PLAIN, 12));//框框字体
		UIManager.put("Slider.background", new Color(250, 250, 250));					//滑杆背景
		UIManager.put("Slider.horizontalThumbIcon", new ImageIcon(MainWindow.class.getResource("sliderthumbflat.png")));	//滑杆图标
		UIManager.put("Button.font", new Font("思源黑体 CN Medium", Font.PLAIN, 13));		//按钮字体
		UIManager.put("Label.font", new Font("思源黑体 CN Medium", Font.PLAIN, 13));		//文本提示字体
		UIManager.put("Panel.background", new Color(250, 250, 250));					//窗体背景
		UIManager.put("ToolTip.background", new Color(250, 250, 250));					//提示框背景
		UIManager.put("ToolTip.foreground", new Color(71, 102, 132));					//提示框字体颜色
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage("src\\icon.png"));
		setIconImage(exeimage);								//窗口图标
		getContentPane().setBackground(backgroundcolor);	//内容背景颜色
		setBackground(backgroundcolor);						//窗体背景颜色
		setTitle("彩色ID生成工具v1.3  by o0O0o0l0o0O0o");		//窗体标题
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//窗体关闭模式
		setSize(400, 330);									//窗体大小
		setLocationRelativeTo(null);						//窗体居中
		getContentPane().setLayout(null);					//窗体布局
		setResizable(false);								//窗体禁用缩放
		
		/*标签1*/
		JLabel tip1 = new JLabel("第一步：输入待转换的名字");		//标签内容
		tip1.setFont(new Font("思源黑体 CN", Font.PLAIN, 14));	//标签字体
		tip1.setBounds(20, 10, 168, 21);						//标签布局
		getContentPane().add(tip1);								//添加控件
		
		/*原始名字文本框*/
		originalname = new JTextField();													//文本框
		originalname.addFocusListener(new FocusAdapter() {									//焦点
			@Override
			public void focusGained(FocusEvent arg0) {										//获得焦点
				originalname.setBorder(new MatteBorder(0, 0, 2, 0, textlinepresscolor));	//获得焦点样式
			}
			@Override
			public void focusLost(FocusEvent e) {											//失去焦点
				originalname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));			//失去焦点样式
			}
		});
		originalname.setBackground(backgroundcolor);										//文本框背景颜色
		originalname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));					//文本框线条颜色
		originalname.setFont(new Font("思源黑体 CN", Font.PLAIN, 14));						//文本框字体
		originalname.setBounds(20, 35, 212, 27);											//文本框布局
		getContentPane().add(originalname);													//添加控件
		originalname.setColumns(10);														//指定列数
		
		/*粘贴按钮*/
		JButton pastebutton = new JButton("粘贴");					//按钮内容
		pastebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//鼠标点击
				String pastestring = getClipboardString();			//鼠标点击动作1:读取剪贴板
				originalname.setText(pastestring);					//鼠标点击动作2:粘贴文本
			}
		});
		pastebutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				pastebutton.setBackground(buttonentercolor);		//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				pastebutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		pastebutton.setBorderPainted(false);						//无边框
		pastebutton.setFocusPainted(false);							//无焦点指示
		pastebutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));	//按钮字体
		pastebutton.setBackground(buttoncolor);						//按钮背景颜色
		pastebutton.setBounds(238, 35, 65, 27);						//按钮布局
		getContentPane().add(pastebutton);							//添加控件
		
		/*清空按钮*/
		JButton clearbutton = new JButton("清空");					//按钮内容
		clearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				originalname.setText(null);							//鼠标点击动作:清空文本
			}
		});
		clearbutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				clearbutton.setBackground(buttonentercolor);		//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				clearbutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		clearbutton.setBorderPainted(false);						//无边框
		clearbutton.setFocusPainted(false);							//无焦点指示
		clearbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));	//按钮字体
		clearbutton.setBackground(buttoncolor);						//按钮背景颜色
		clearbutton.setBounds(308, 35, 65, 27);						//按钮布局
		getContentPane().add(clearbutton);							//添加控件
		
		/*标签2*/
		JLabel tip2 = new JLabel("第二步：选择颜色与游戏");			//标签内容
		tip2.setFont(new Font("思源黑体 CN", Font.PLAIN, 14));	//标签字体
		tip2.setBounds(20, 80, 154, 21);						//标签布局
		getContentPane().add(tip2);								//添加控件
		
		/*颜色选择按钮*/
		JButton choosecolor = new JButton("选择颜色...");				//按钮内容
		choosecolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				Color getcolor = CustomColorChooser.showDialog(getContentPane(), "选择颜色...", color);//颜色选择
				if(getcolor == null && color == null) {								//情况1:第一次没选择颜色
					tip3.setText("请选择颜色");
					tip3.setFont(new Font("思源黑体 CN Light", Font.PLAIN, 14));
					printbutton.setText("未选择颜色");
					printbutton.removeActionListener(printbuttonclick);
					printbutton.removeMouseListener(printbuttonadapter);
					printbutton.setForeground(Color.GRAY);
					tip3.setForeground(Color.BLACK);
				}
				else if(getcolor != null) {											//情况2:选择了颜色
					color = getcolor;
					tip3.setText("您选择的颜色是:"+toHexFromColor(color));
					tip3.setFont(new Font("思源黑体 CN Medium", Font.PLAIN, 14));
					printbutton.setText("一键生成");
					printbutton.addActionListener(printbuttonclick);
					printbutton.addMouseListener(printbuttonadapter);
					printbutton.setForeground(Color.BLACK);
					tip3.setForeground(color);
					newname.setText(null);
					tip5.setText("效果预览");
					tip5.setForeground(Color.BLACK);
				}
				else if(getcolor == null && color != null){							//情况3:第二次以后没选择颜色,保留之前的颜色
					tip3.setText("您选择的颜色是:"+toHexFromColor(color));
					tip3.setFont(new Font("思源黑体 CN Medium", Font.PLAIN, 14));
					printbutton.setText("一键生成");
					printbutton.addActionListener(printbuttonclick);
					printbutton.addMouseListener(printbuttonadapter);
					printbutton.setForeground(Color.BLACK);
					tip3.setForeground(color);
				}
			}
		});
		choosecolor.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				choosecolor.setBackground(buttonentercolor);		//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				choosecolor.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		choosecolor.setBorderPainted(false);
		choosecolor.setFocusPainted(false);
		choosecolor.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		choosecolor.setBackground(buttoncolor);
		choosecolor.setBounds(20, 104, 100, 26);
		getContentPane().add(choosecolor);
		
		/*标签3:颜色提示标签*/
		tip3 = new JLabel("请选择颜色");
		tip3.setForeground(Color.BLACK);
		tip3.setFont(new Font("思源黑体 CN Light", Font.PLAIN, 14));
		tip3.setBounds(130, 106, 243, 21);
		getContentPane().add(tip3);
		
		/*游戏选择单选按钮*/
		humanfallflat = new JRadioButton("人类一败涂地");
		humanfallflat.setSelected(true);
		humanfallflat.setBackground(backgroundcolor);
		humanfallflat.setFocusPainted(false);
		humanfallflat.setIcon(uncheckedbutton);
		humanfallflat.setSelectedIcon(checkedbutton);
		humanfallflat.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		humanfallflat.setBounds(20, 133, 110, 23);
		getContentPane().add(humanfallflat);
		
		jsb = new JRadioButton("Just Shapes & Beats");
		jsb.setBackground(backgroundcolor);
		jsb.setFocusPainted(false);
		jsb.setIcon(uncheckedbutton);
		jsb.setSelectedIcon(checkedbutton);
		jsb.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		jsb.setBackground(new Color(250, 250, 250));
		jsb.setBounds(140, 133, 180, 23);
		getContentPane().add(jsb);
		
		ButtonGroup group=new ButtonGroup();
		group.add(humanfallflat);
		group.add(jsb);
		
		/*标签4*/
		JLabel tip4 = new JLabel("第三步：生成带有颜色属性的新名字");
		tip4.setFont(new Font("思源黑体 CN", Font.PLAIN, 14));
		tip4.setBounds(20, 155, 224, 21);
		getContentPane().add(tip4);
		
		printbutton = new JButton("未选择颜色");
		printbutton.setForeground(Color.GRAY);
		printbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		printbutton.setFocusPainted(false);
		printbutton.setBorderPainted(false);
		printbutton.setBackground(buttoncolor);
		printbutton.setBounds(20, 181, 100, 27);
		getContentPane().add(printbutton);
		
		JButton copybutton = new JButton("复制");
		copybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				setClipboardString(newname.getText());				//鼠标点击动作:复制文本
			}
		});
		copybutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				copybutton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				copybutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		copybutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		copybutton.setFocusPainted(false);
		copybutton.setBorderPainted(false);
		copybutton.setBackground(buttoncolor);
		copybutton.setBounds(123, 181, 65, 27);
		getContentPane().add(copybutton);
		
		newname = new JTextField();
		newname.addFocusListener(new FocusAdapter() {									//焦点
			@Override
			public void focusGained(FocusEvent arg0) {										//获得焦点
				newname.setBorder(new MatteBorder(0, 0, 2, 0, textlinepresscolor));	//获得焦点样式
			}
			@Override
			public void focusLost(FocusEvent e) {											//失去焦点
				newname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));			//失去焦点样式
			}
		});
		newname.setBackground(backgroundcolor);
		newname.setBorder(new MatteBorder(0, 0, 1, 0, textlinecolor));
		newname.setFont(new Font("思源黑体 CN", Font.PLAIN, 14));
		newname.setBounds(20, 214, 353, 27);
		getContentPane().add(newname);
		newname.setColumns(10);
		
		JButton aboutbutton = new JButton("关于");
		aboutbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
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
		aboutbutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				aboutbutton.setBackground(buttonentercolor);		//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				aboutbutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		aboutbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		aboutbutton.setFocusPainted(false);
		aboutbutton.setBorderPainted(false);
		aboutbutton.setBackground(buttoncolor);
		aboutbutton.setBounds(244, 264, 65, 27);
		getContentPane().add(aboutbutton);
		
		JButton exitbutton = new JButton("退出");
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				dispose();											//鼠标点击动作:退出程序
			}
		});
		exitbutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				exitbutton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				exitbutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		exitbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		exitbutton.setFocusPainted(false);
		exitbutton.setBorderPainted(false);
		exitbutton.setBackground(buttoncolor);
		exitbutton.setBounds(319, 264, 65, 27);
		getContentPane().add(exitbutton);
		
		tip5 = new JLabel("效果预览");
		tip5.setFont(new Font("思源黑体 CN Medium", Font.PLAIN, 20));
		tip5.setBounds(20, 251, 212, 40);
		getContentPane().add(tip5);
	}
}
