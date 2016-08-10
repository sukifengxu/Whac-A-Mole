package whac_a_mole;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BGM {

    private AudioInputStream audioSource = null;
    private Clip clip = null;

    public void playBGM(InputStream in) {
	try {
	    audioSource = AudioSystem.getAudioInputStream(in);
	} catch (UnsupportedAudioFileException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	try {
	    clip = AudioSystem.getClip();
	} catch (LineUnavailableException e) {
	    e.printStackTrace();
	}

	try {
	    clip.open(audioSource);
	} catch (LineUnavailableException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	clip.start();
    }

}
