package Multimedia;


import javax.sound.sampled.*;
import javax.swing.*;

public class AppMultimedia {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Audio WAV desde paquete");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton btnPlay = new JButton("Reproducir Audio");
        btnPlay.addActionListener(e -> playAudio());

        frame.add(btnPlay);
        frame.setVisible(true);
    }

    public static void playAudio() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                AppMultimedia.class.getResource("audio.wav")  // ← Busca dentro del paquete
            );

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo reproducir el audio");
        }
    }
}

