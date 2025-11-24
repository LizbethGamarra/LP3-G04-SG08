package Multimedia;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AppVideo extends JFrame {

    private MediaPlayer mediaPlayer;
    private JFXPanel jfxPanel;

    public AppVideo() {
        super("Reproductor de Video");

        jfxPanel = new JFXPanel();

        JButton playButton = new JButton("Reproducir");
        JButton pauseButton = new JButton(" Pausar");
        JButton stopButton = new JButton(" Detener");

        playButton.addActionListener(e -> {
            if (mediaPlayer != null) mediaPlayer.play();
        });

        pauseButton.addActionListener(e -> {
            if (mediaPlayer != null) mediaPlayer.pause();
        });

        stopButton.addActionListener(e -> {
            if (mediaPlayer != null) mediaPlayer.stop();
        });

        JPanel controls = new JPanel();
        controls.add(playButton);
        controls.add(pauseButton);
        controls.add(stopButton);

        setLayout(new BorderLayout());
        add(jfxPanel, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Platform.runLater(this::initFX);
    }

    private void initFX() {
        try {
            String path = new File("src/multimedia/video1.mp4").toURI().toString();

            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            Group root = new Group(mediaView);
            Scene scene = new Scene(root, 900, 550);

            jfxPanel.setScene(scene);

            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error cargando el video desde multimedia/video.mp4",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppVideo::new);
    }
}


