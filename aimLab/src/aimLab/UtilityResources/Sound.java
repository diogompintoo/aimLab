package aimLab.UtilityResources;

import javax.sound.sampled.*;
import java.io.File;

public class Sound {

    private Clip clip;

    public Sound(String path) {
        try {
            File file = new File(path);
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);

            clip = AudioSystem.getClip();
            clip.open(audio);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playLoop(){
        if (clip != null &&  !clip.isRunning()){
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    public void stop(){
        if (clip != null && clip.isRunning()){
            clip.stop();
        }
    }
}
