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

	/*颜色样式*/
	private Color backgroundcolor = new Color(250, 250, 250);	//窗体背景颜色样式
	private Color buttoncolor = new Color(233, 233, 234);		//按钮正常颜色样式
	private Color buttonentercolor = new Color(201, 202, 203);	//按钮经过颜色样式
	private Color textareacolor = new Color(122, 138, 153);	//文本边框激活颜色样式
	
	/**
	 * Create the dialog.
	 */
	public AboutWindow() {
		setAlwaysOnTop(true);
		setModal(true);
		getContentPane().setBackground(backgroundcolor);	//内容背景颜色
		setBackground(backgroundcolor);						//窗体背景颜色
		setTitle("关于  “彩色 ID 生成工具”");					//窗体标题
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//窗体关闭模式
		setSize(300, 200);									//窗体大小
		setLocationRelativeTo(null);						//窗体居中
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
		exitbutton.setBounds(213, 134, 60, 27);
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
		linkbutton.setBounds(115, 134, 88, 27);
		getContentPane().add(linkbutton);
		
		JButton updatelogbutton = new JButton("更新日志");
		updatelogbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//鼠标点击
				if(updatelogbutton.getText()=="更新日志") {
					updatelogbutton.setText("收起");
					setSize(300,400);
				}
				else if(updatelogbutton.getText()=="收起") {
					updatelogbutton.setText("更新日志");
					setSize(300,200); 
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
		updatelogbutton.setBounds(19, 134, 86, 27);
		getContentPane().add(updatelogbutton);
		
		JLabel lblId = new JLabel("<html><body>彩色 ID 生成工具 v1.0<br>由 bilibili Up主 : o0O0o0l0o0O0o 制作<br>软件已在github开源<br>遵循 GPL(通用公共许可证) v3 协议<br>本软件完全免费,请勿售卖!</body></html>");
		lblId.setFont(new Font("思源黑体 CN", Font.PLAIN, 13));
		lblId.setBounds(20, 10, 254, 114);
		getContentPane().add(lblId);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new MatteBorder(1, 1, 3, 1, textareacolor));
		textPane.setBackground(backgroundcolor);
		textPane.setFont(new Font("思源黑体 CN", Font.PLAIN, 12));
		textPane.setText("v1.0：\n完善关于页面\n加入对Just Shapes & Beats的支持\n更换了新图标\nv0.9：\n修正文本格式错误，现在可以正常展示颜色了\nv0.8：\n界面美化，逻辑功能完善");
		textPane.setEditable(false);
		textPane.setBounds(19, 171, 255, 179);
		getContentPane().add(textPane);
	}
}
