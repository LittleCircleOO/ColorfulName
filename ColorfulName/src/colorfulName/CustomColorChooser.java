package colorfulName;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class CustomColorChooser extends JDialog{
	/**
	 * 自定义颜色选择窗口
	 */
	private static final long serialVersionUID = 1108980208767803621L;
	private static Color currentcolor;
	private Color buttoncolor = new Color(233, 233, 234);		//按钮正常颜色样式
	private Color buttonentercolor = new Color(201, 202, 203);	//按钮经过颜色样式
	
	static Color showDialog(Component component, String title, Color initialColor) {
		CustomColorChooser cc = new CustomColorChooser(component, title, initialColor);
		cc.setVisible(true);
		return currentcolor;
	}
	
	CustomColorChooser(Component component, String title, Color initialColor){
		setTitle(title);
		setSize(600,400);
		setIconImage(new ImageIcon(MainWindow.class.getResource("colorchooser.png")).getImage());
		setLocationRelativeTo(component);
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JColorChooser colorchooser = new JColorChooser();
		currentcolor = initialColor;
		colorchooser.setColor(currentcolor);
		colorchooser.addChooserPanel(new PresetColorChooserPanel());
		getContentPane().add(colorchooser);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setBorder(new EmptyBorder(3,3,3,3));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 6));
		
		JButton yesButton = new JButton("确定");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentcolor = colorchooser.getColor();
				dispose();
			}
		});
		yesButton.addMouseListener(new MouseAdapter() {				//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				yesButton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				yesButton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		yesButton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		yesButton.setFocusPainted(false);
		yesButton.setBorderPainted(false);
		yesButton.setBackground(buttoncolor);
		panel.add(yesButton);
		
		JButton noButton = new JButton("取消");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentcolor = null;
				dispose();
			}
		});
		noButton.addMouseListener(new MouseAdapter() {				//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				noButton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				noButton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		noButton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		noButton.setFocusPainted(false);
		noButton.setBorderPainted(false);
		noButton.setBackground(buttoncolor);
		panel.add(noButton);
		
		JButton reButton = new JButton("重置");
		reButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentcolor == null)
					colorchooser.setColor(Color.WHITE);
				else
					colorchooser.setColor(currentcolor);
			}
		});
		reButton.addMouseListener(new MouseAdapter() {				//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				reButton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				reButton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		reButton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		reButton.setFocusPainted(false);
		reButton.setBorderPainted(false);
		reButton.setBackground(buttoncolor);
		panel.add(reButton);
	}
	
}

class PresetColorChooserPanel extends AbstractColorChooserPanel implements ActionListener{
	/**
	 * 预设颜色面板
	 * Adapted from: https://blog.csdn.net/xxkkff/article/details/1402485
	 */
	private static final long serialVersionUID = 8343398290219931539L;
	
	private static Color colors[] = {
			new Color(255,255,255),new Color(255,0,0),new Color(0,255,0),new Color(0,0,255),new Color(255,0,255),
			new Color(0,255,255),new Color(255,255,0),new Color(0,0,0),new Color(112, 219, 147),new Color(92, 51, 23),
			new Color(159, 95, 159),new Color(181, 166, 66),new Color(217, 217, 25),new Color(166, 125, 61),new Color(140, 120, 83),
			new Color(166, 125, 61),new Color(95, 159, 159),new Color(217, 135, 25),new Color(184, 115, 51),new Color(255, 127, 0),
			new Color(66, 66, 111),new Color(92, 64, 51),new Color(47, 79, 47),new Color(74, 118, 110),new Color(79, 79, 47),
			new Color(153, 50, 205),new Color(135, 31, 120),new Color(107, 35, 142),new Color(47, 79, 79),new Color(151, 105, 79),
			new Color(112, 147, 219),new Color(133, 94, 66),new Color(84, 84, 84),new Color(133, 99, 99),new Color(209, 146, 117),
			new Color(142, 35, 35),new Color(35, 142, 35),new Color(205, 127, 50),new Color(219, 219, 112),new Color(192, 192, 192),
			new Color(82, 127, 118),new Color(147, 219, 112),new Color(33, 94, 33),new Color(78, 47, 47),new Color(159, 159, 95),
			new Color(192, 217, 217),new Color(168, 168, 168),new Color(143, 143, 189),new Color(233, 194, 166),new Color(50, 205, 50),
			new Color(228, 120, 51),new Color(142, 35, 107),new Color(50, 205, 153),new Color(50, 50, 205),new Color(107, 142, 35),
			new Color(234, 234, 174),new Color(147, 112, 219),new Color(66, 111, 66),new Color(127, 0, 255),new Color(127, 255, 0),
			new Color(112, 219, 219),new Color(219, 112, 147),new Color(166, 128, 100),new Color(47, 47, 79),new Color(35, 35, 142),
			new Color(77, 77, 255),new Color(255, 110, 199),new Color(0, 0, 156),new Color(235, 199, 158),new Color(207, 181, 59),
			new Color(255, 127, 0),new Color(255, 36, 0),new Color(219, 112, 219),new Color(143, 188, 143),new Color(188, 143, 143),
			new Color(234, 173, 234),new Color(217, 217, 243),new Color(89, 89, 171),new Color(111, 66, 66),new Color(188, 23, 23),
			new Color(35, 142, 104),new Color(107, 66, 38),new Color(142, 107, 35),new Color(230, 232, 250),new Color(50, 153, 204),
			new Color(0, 127, 255),new Color(255, 28, 174),new Color(0, 255, 127),new Color(35, 107, 142),new Color(56, 176, 222),
			new Color(219, 147, 112),new Color(216, 191, 216),new Color(173, 234, 234),new Color(92, 64, 51),new Color(205, 205, 205),
			new Color(79, 47, 79),new Color(204, 50, 153),new Color(216, 216, 191),new Color(153, 204, 50),new Color(0, 188, 212),
			new Color(123, 186, 245),new Color(73, 135, 238),new Color(248, 114, 150),new Color(242, 67, 51),new Color(254, 193, 4),
			new Color(137, 196, 71),new Color(30, 150, 240),new Color(154, 39, 173),new Color(13, 157, 86),new Color(216, 68, 52),
			new Color(61, 81, 179),new Color(0, 151, 135),new Color(253, 153, 0),new Color(101, 58, 180),new Color(30, 150, 240),
			new Color(120, 86, 70),new Color(94, 126, 136),new Color(31, 34, 31),new Color(48, 51, 48),new Color(250, 250, 250)
	};
	
	private static String tips[] = {
			"白色","红色","绿色","蓝色","牡丹红","青色","黄色","黑色","海蓝","巧克力色",
			"蓝紫色","黄铜色","亮金色","棕色","青铜色","青铜色2","士官服蓝色","冷铜色","铜色","珊瑚红",
			"紫蓝色","深棕","深绿","深铜绿色","深橄榄绿","深兰花色","深紫色","深石板蓝","深铅灰色","深棕褐色",
			"深绿松石色","暗木色","淡灰色","土灰玫瑰红色","长石色","火砖色","森林绿","金色","鲜黄色","灰色",
			"铜绿色","青黄色","猎人绿","印度红","土黄色","浅蓝色","浅灰色","浅钢蓝色","浅木色","石灰绿色",
			"桔黄色","褐红色","中海蓝色","中蓝色","中森林绿","中鲜黄色","中兰花色","中海绿色","中石板蓝色","中春绿色",
			"中绿松石色","中紫红色","中木色","深藏青色","海军蓝","霓红蓝","霓虹粉红","新深藏青色","新棕褐色","暗金黄色",
			"橙色","橙红色","淡紫色","浅绿色","粉红色","李子色","石英色","艳蓝色","鲑鱼色","猩红色",
			"海绿色","半甜巧克力色","赭色","银色","天蓝","石板蓝","艳粉红色","春绿色","钢蓝色","亮天蓝色",
			"棕褐色","紫红色","浅石板蓝","浓深棕色","淡浅灰色","紫罗兰色","紫罗兰红色","麦黄色","黄绿色","文本框绿",
			"滚动条蓝","滑块蓝","哔哩粉","姨妈红","咸蛋黄","早苗绿","胖次蓝","基佬紫","酷安绿","姨妈红2",
			"颐堤蓝","水鸭青","伊藤橙","基佬紫2","知乎蓝","古铜棕","低调灰","高端黑","A屏黑","背景灰"
	};
	
	JButton color1,color2,color3,color4,color5;
	
	public PresetColorChooserPanel(){
		ToolTipManager.sharedInstance().setInitialDelay(500);
		setLayout(new GridLayout(6,20,2,2));
		for(int i = 0; i < 120; i++) {
			JButton colorbutton = new JButton();
			colorbutton.setToolTipText(tips[i]);
			colorbutton.setBackground(colors[i]);
			colorbutton.setBorder(new EmptyBorder(10,10,10,10));
			colorbutton.addActionListener(this);
			add(colorbutton);
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		JButton source = (JButton)ae.getSource();
		getColorSelectionModel().setSelectedColor(source.getBackground());
	}
	
	public void buildChooser(){}
	
	public void updateChooser(){}
	
	public String getDisplayName(){
    	return "预设";
	}
	
	public Icon getSmallDisplayIcon() {
		return null;
	}
	
    public Icon getLargeDisplayIcon() {
        return null;
    }
    
}