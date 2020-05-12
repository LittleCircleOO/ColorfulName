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
	 * 关于窗口
	 */
	private static final long serialVersionUID = -7173879279892177873L;
	/*颜色样式*/
	private Color backgroundcolor = new Color(250, 250, 250);	//窗体背景颜色样式
	private Color buttoncolor = new Color(233, 233, 234);		//按钮正常颜色样式
	private Color buttonentercolor = new Color(201, 202, 203);	//按钮经过颜色样式
	private Color textareacolor = new Color(122, 138, 153);	//文本边框激活颜色样式
	
	/**
	 * Create the dialog.
	 */
	public AboutWindow(Component component) {
		setAlwaysOnTop(true);
		setModal(true);
		getContentPane().setBackground(backgroundcolor);	//内容背景颜色
		setBackground(backgroundcolor);						//窗体背景颜色
		setTitle("关于  “彩色 ID 生成工具”");					//窗体标题
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//窗体关闭模式
		setSize(300, 220);									//窗体大小
		setLocationRelativeTo(component);					//窗体居中
		getContentPane().setLayout(null);					//窗体布局
		setResizable(false);								//窗体禁用缩放
		
		JButton exitbutton = new JButton("关闭");
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
		exitbutton.setBounds(214, 154, 60, 27);
		getContentPane().add(exitbutton);
		
		JButton linkbutton = new JButton("Github...");
		linkbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				/*from https://blog.csdn.net/xingbaozhen1210/article/details/81078101*/
				Desktop desktop = Desktop.getDesktop();				//鼠标点击动作:转到github
				if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://github.com/LittleCircleOO/ColorfulName"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}										
			}
		});
		linkbutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				linkbutton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				linkbutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		linkbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		linkbutton.setFocusPainted(false);
		linkbutton.setBorderPainted(false);
		linkbutton.setBackground(new Color(233, 233, 234));
		linkbutton.setBounds(20, 154, 88, 27);
		getContentPane().add(linkbutton);
		
		JButton updatelogbutton = new JButton("更新日志");
		updatelogbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				if(updatelogbutton.getText()=="更新日志") {
					updatelogbutton.setText("收起");
					setSize(300,440);
				}
				else if(updatelogbutton.getText()=="收起") {
					updatelogbutton.setText("更新日志");
					setSize(300,220); 
				}
			}
		});
		updatelogbutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				updatelogbutton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				updatelogbutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		updatelogbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		updatelogbutton.setFocusPainted(false);
		updatelogbutton.setBorderPainted(false);
		updatelogbutton.setBackground(new Color(233, 233, 234));
		updatelogbutton.setBounds(118, 154, 86, 27);
		getContentPane().add(updatelogbutton);
		
		JButton netdiskbutton = new JButton("网盘下载");
		netdiskbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				/*from https://blog.csdn.net/xingbaozhen1210/article/details/81078101*/
				Desktop desktop = Desktop.getDesktop();				//鼠标点击动作:转到github
				if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://www.lanzous.com/b0awlzefi"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}										
			}
		});
		netdiskbutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				netdiskbutton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				netdiskbutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		netdiskbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		netdiskbutton.setFocusPainted(false);
		netdiskbutton.setBorderPainted(false);
		netdiskbutton.setBackground(new Color(233, 233, 234));
		netdiskbutton.setBounds(118, 117, 86, 27);
		getContentPane().add(netdiskbutton);
		
		JButton channelbutton = new JButton("bilibili...");
		channelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				/*from https://blog.csdn.net/xingbaozhen1210/article/details/81078101*/
				Desktop desktop = Desktop.getDesktop();				//鼠标点击动作:转到github
				if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://space.bilibili.com/272324550"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}										
			}
		});
		channelbutton.addMouseListener(new MouseAdapter() {			//鼠标动作
			@Override
			public void mouseEntered(MouseEvent arg0) {				//鼠标移入
				channelbutton.setBackground(buttonentercolor);			//鼠标移入样式
			}
			@Override
			public void mouseExited(MouseEvent e) {					//鼠标移出
				channelbutton.setBackground(buttoncolor);				//鼠标移出样式
			}
		});
		channelbutton.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		channelbutton.setFocusPainted(false);
		channelbutton.setBorderPainted(false);
		channelbutton.setBackground(new Color(233, 233, 234));
		channelbutton.setBounds(20, 117, 88, 27);
		getContentPane().add(channelbutton);
		
		
		
		JLabel lblId = new JLabel("<html><body>彩色 ID 生成工具 v1.2<br>由 bilibili Up主 : o0O0o0l0o0O0o 制作<br>软件已在github开源<br>遵循 GPLv3 (通用公共许可证) 协议<br>本软件完全免费,请勿售卖!</body></html>");
		lblId.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		lblId.setBounds(20, 10, 254, 100);
		getContentPane().add(lblId);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new MatteBorder(1, 1, 3, 1, textareacolor));
		textPane.setBackground(backgroundcolor);
		textPane.setFont(new Font("思源黑体 CN", Font.PLAIN, 12));
		textPane.setText("v0.8：\n界面美化，逻辑功能完善\nv0.9：\n修正文本格式错误，现在可以正常展示颜色了\nv1.0：\n完善关于页面\n加入对Just Shapes & Beats的支持\n更换了新图标\nv1.1：\n修复某些设备由于字体缺失导致的显示问题\n修复取消颜色选择后导致上个颜色丢失的问题\n现在颜色选择器可以显示上次选择的颜色了\n现在更改颜色会自动清空生成框\n加入镜像下载站点与bilibili链接\nv1.2：\nWindows版本开始提供exe可执行文件\n优化了颜色选择界面与更新日志展示");
		textPane.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 202, 254, 189);
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			/*样式重定义*/
			/**
			 * 自定义滚动条样式
			 * Adapted from: https://www.cnblogs.com/LiuYanYGZ/p/9490880.html
			 */
			private final int thumbWidth = 8;
		    //手柄透明度
		    private final float opaque = 1f;
		    // 手柄边框颜色
		    private final Color thumbColor = new Color(123, 186, 245);
		    // 手柄颜色
		    private final Color thumbColorFrom = new Color(123, 186, 245);
		    private final Color thumbColorTo = new Color(123, 186, 245);
		    // 滑道颜色
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