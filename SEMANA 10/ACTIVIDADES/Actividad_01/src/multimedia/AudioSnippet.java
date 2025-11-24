package multimedia;

import javax.sound.sampled.*;
import java.io.File;

public class AudioSnippet {

    public static void main(String[] args) throws Exception {
        File audioFile = new File("audio1.wav"); // coloca el archivo WAV en el proyecto
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start(); // Reproduce el audio
    }
}
