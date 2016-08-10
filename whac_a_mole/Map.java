package whac_a_mole;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Bo Tian
 * GUI (controller and view)
 * view is observer
 */
public class Map {
    
    /*
     * Fields.
     */
    private JFrame frame;
    private JPanel p1;
    private JPanel p2;
    private JLabel label;
    private JTextField textField;
    private Mouse[] mouseSet;
    
    /**
     * Constructor.
     */
    public Map() throws IOException{
        frame = new JFrame("Punch Game: Stage 1");
        frame.setLayout(new BorderLayout());
        p1 = new JPanel(new GridLayout(1, 6));
        label = new JLabel("Stage Score:");
        textField = new JTextField("0");
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(label);
        p1.add(textField);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p2 = new JPanel(new GridLayout(4, 4));
        frame.add(p1, BorderLayout.NORTH);
        frame.add(p2, BorderLayout.CENTER);
        
        mouseSet = new Mouse[16];
        for (int i = 0; i < 16; i++) {
            Mouse mouse = new Mouse();
            mouse.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("hole.jpg"))));
            mouseSet[i] = mouse;
            p2.add(mouse);
        }
        
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /**
     * Getter.
     * @return mouseSet.
     */
    public Mouse[] getMouseSet() {
	return mouseSet;
    }
    
    public void showNextLevel() {
	JOptionPane.showMessageDialog(frame, "Brilliant! Now moving to stage " + Operations.stage, "Brilliant", 1);
	frame.setTitle("Punch Game: Stage " + Operations.stage);
    }
    
    public void showWin() {
	JOptionPane.showMessageDialog(frame, "You Win.", "Congratulation", 1);
	JOptionPane.showMessageDialog(frame, "This game was initially written for someone special.\n\n"
		+ "Hence,\n"
		+ "Private message for her is hidden.", "Hi",1);
    }
    
    public void showFail() {
	JOptionPane.showMessageDialog(frame, "You Fail.", "Sorry", 0);
    }
    
    public void showWelcome() {
	JOptionPane.showMessageDialog(frame, "Hi there,\n\n"
		+ "Hit naughty Michy Mouse before it's too late.\n"
		+ "Hope you like it.\n"
		+ "Have fun.\n\n"
		+ "(Turn on the speaker to hear BGM)", "Hi there", 1);
	JOptionPane.showMessageDialog(frame, "Level up after stage score reaches 6.\n"
		+ "Fail if stage score reaches -10.\n"
		+ "Display winner message when finishing stage 5.\n\n"
		+ "Game will begin when clicking OK.", "Rules", 2);
    }
    
    public void setScore(int score) {
	textField.setText("" + score);
    }

}