package whac_a_mole;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Bo Tian
 * The model
 */
public class Mouse extends JButton {

    /*
     * New Fields.
     */
    private Icon mouseImage = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("mouse.jpg")));
    private Icon holeImage = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("hole.jpg")));
    private Icon hitImage = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("hit.jpg")));
    private boolean appear = false;

    /**
     * Constructor.
     */
    public Mouse() throws IOException {
	super(new ImageIcon());
	addActionListener(new MouseListener());
    }
    
    public Icon fitIcon(Icon icon) {
	ImageIcon imageIcon = (ImageIcon) icon;
	Image image = imageIcon.getImage();
	Image newImage = image.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
	Icon newIcon = new ImageIcon(newImage);
	return newIcon;
    }

    public void appear() {
	setIcon(fitIcon(mouseImage));
	appear = true;
    }

    public void disappear() {
	setIcon(holeImage);
	appear = false;
    }

    class MouseListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (appear) {
		setIcon(fitIcon(hitImage));
		Toolkit.getDefaultToolkit().beep();
		Operations.scoreCount = Operations.scoreCount + 2;
	    }
	}
    }
}
