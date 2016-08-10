package whac_a_mole;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Main class.
 * @author Bo Tian
 */
public class RunGame {
    
    private static RunGame game = new RunGame();
    private InputStream in = getClass().getResourceAsStream("SampleMusic.wav"); 

    public void startMusic() {
	new BGM().playBGM(new BufferedInputStream(in));
    }
    
    public static void main(String[] args) throws IOException{
	new RunGame().startMusic();
	Operations operations = new Operations();
	operations.startGame(game);
    }
}