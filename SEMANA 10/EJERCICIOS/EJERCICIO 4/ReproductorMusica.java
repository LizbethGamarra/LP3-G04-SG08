import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class ReproductorMusica extends JFrame {

    private Clip clip;
    private AudioInputStream audioStream;
    private Long posicionPausa = 0L;

    public ReproductorMusica() {
        setTitle("Reproductor de Música");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnReanudar = new JButton("Reanudar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 10));

        panel.add(btnReproducir);
        panel.add(btnPausar);
        panel.add(btnReanudar);

        add(panel);

        btnReproducir.addActionListener(e -> reproducir());
        btnPausar.addActionListener(e -> pausar());
        btnReanudar.addActionListener(e -> reanudar());
    }

    private void cargarAudio() {
        try {
            File archivo = new File("sounds/musica.wav");
            audioStream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando audio", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void reproducir() {
        try {
            cargarAudio();
            posicionPausa = 0L;
            clip.setMicrosecondPosition(0);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pausar() {
        if (clip != null && clip.isRunning()) {
            posicionPausa = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    private void reanudar() {
        try {
            if (clip != null && !clip.isRunning()) {

                if (!clip.isOpen()) {
                    cargarAudio();
                }

                clip.setMicrosecondPosition(posicionPausa);
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReproductorMusica().setVisible(true);
        });
    }
}
