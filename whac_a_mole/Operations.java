package whac_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.Timer;

/**
 * @author Bo Tian
 * The model
 */
public class Operations implements Runnable {

    private Map map = new Map();
    private Random rand = new Random();
    private int interval = 1200;
    public static int scoreCount = 0;
    public static int stage = 0;
    private Thread myThread = new Thread(this);
    private Timer t;
    private int hitTimes = 7;
    private int failScore = -10;
    
    public Operations() throws IOException {
	super();
    }

    public void startGame(RunGame game) {
	myThread.start();
    }

    private void disappearAll() {
	for (Mouse mouse: map.getMouseSet()) {
	    mouse.disappear();
	}
    }

    /**
     * Shorten the internal for Timer.
     * Also instantiate the new Timer object with the new interval.
     */
    public void accelerate() {
	interval = interval - 150;
	t = new Timer(interval, new MyTimeListener());
    }

    @Override
    public void run() {

	t = new Timer(interval, new MyTimeListener());
	t.setRepeats(false);
	map.showWelcome();

	while (Operations.stage < 5) {
	    Operations.scoreCount = 0;
	    Operations.stage = Operations.stage + 1;
	    if (Operations.stage != 1) {
		map.showNextLevel();
		disappearAll();
		accelerate();
	    }
	    while (Operations.scoreCount < hitTimes) {
		t.start();
		if (Operations.scoreCount < failScore) {
		    t.stop();
		    map.showFail();
		    System.exit(0);
		}
	    }
	    t.stop();
	}
	map.showWin();
	System.exit(0);
    }

    class MyTimeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    disappearAll();
	    Mouse mouse = map.getMouseSet()[rand.nextInt(16)];
	    mouse.appear();
	    map.setScore(scoreCount);
	    Operations.scoreCount = Operations.scoreCount - 1; // Punish if do nothing.
	}
    }

}
