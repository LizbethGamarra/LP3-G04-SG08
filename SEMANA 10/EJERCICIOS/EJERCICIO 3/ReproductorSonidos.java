import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class ReproductorSonidos extends JFrame {

    public ReproductorSonidos() {
        setTitle("Reproductor de Efectos de Sonido");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");

        panel.add(btnAplausos);
        panel.add(btnCampana);
        panel.add(btnExplosion);

        btnAplausos.addActionListener(e -> reproducirSonido("aplausos.wav"));
        btnCampana.addActionListener(e -> reproducirSonido("sounds/campana.wav"));
        btnExplosion.addActionListener(e -> reproducirSonido("sounds/explosion.wav"));

        add(panel);
    }

    private void reproducirSonido(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "No se pudo reproducir el sonido: " + ruta,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReproductorSonidos().setVisible(true);
        });
    }
}
