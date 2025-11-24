package multimedia;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.io.File;

public class VideoExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de Video");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JFXPanel jfxPanel = new JFXPanel();
        frame.add(jfxPanel);
        frame.setVisible(true);

        // Ejecutar JavaFX en su hilo
        Platform.runLater(() -> {
            String videoPath = new File("video.mp4").toURI().toString();
            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            jfxPanel.setScene(new Scene(new javafx.scene.Group(mediaView)));
            mediaPlayer.play();
        });
    }
}
