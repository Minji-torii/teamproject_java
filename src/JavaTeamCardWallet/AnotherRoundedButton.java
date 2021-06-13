package JavaTeamCardWallet;

import java.awt.*;
import javax.swing.*;

public class AnotherRoundedButton extends JButton{


	public AnotherRoundedButton() { 
		super(); 
		decorate();
	} 
	public AnotherRoundedButton(String text) { 
		super(text); 
		decorate();   
	} 
	public AnotherRoundedButton(Action action) { 
		super(action); 
		decorate();
	} 
	public AnotherRoundedButton(Icon icon) { 
		super(icon); 
		decorate();   
	} 
	public AnotherRoundedButton(String text, Icon icon) { 
		super(text, icon); 
		decorate();
	}

	protected void decorate() { 
		setBorderPainted(false); 
		setOpaque(false); 
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (getModel().isArmed()) { 
			graphics.setColor(getBackground().darker()); 
		} else if (getModel().isRollover()) { 
			graphics.setColor(Color.lightGray); 
		} else { 
			graphics.setColor(Color.GRAY); 
		}
		graphics.fillRoundRect(0, 0, width, height, 10, 10);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		graphics.setColor(getForeground()); 
		graphics.setFont(getFont()); 
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose();

		super.paintComponent(g);
	}

}