package colorfulName;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MyRadiobuttonIcon implements Icon {
	/**
	 * 自定义单选按钮样式
	 * Adapted from: https://stackoverflow.com/questions/36505597/uimanager-and-jcheckbox-icon
	 */
	public void paintIcon(Component component, Graphics g, int x, int y) {
    	AbstractButton abstractButton = (AbstractButton)component;
        ButtonModel buttonModel = abstractButton.getModel();

        if(buttonModel.isSelected()) 
        	g.drawImage(createImage("checkedbutton.png"), x, y, component);
        else
        	g.drawImage(createImage("uncheckedbutton.png"), x, y, component);
	}
	public int getIconWidth() {
    	return 13;
	}
	public int getIconHeight() {
		return 13;
	}

	protected Image createImage(String path) {
        URL imageURL = MyRadiobuttonIcon.class.getResource(path);
        Image icn = null;

        if (imageURL == null) {
            icn = new ImageIcon(MainWindow.class.getResource(path)).getImage();
			if (null != icn)
				return icn;
			else {
				System.err.println("Resource not found: " + path);
				return null;
			}
        } else {
            return (new ImageIcon(imageURL)).getImage();
        }
    }
}