package tubes.views.login;

import java.awt.*;
import javax.swing.*;

public class LoginUI extends JFrame {

    private JPanel panelLogin;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUI() {
        super("Login UI View For Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 1024); // Ukuran lebih besar agar gambar terlihat
        
        JLabel backgroundLabel = addLoginBackground();
        if (backgroundLabel == null) {
            backgroundLabel = new JLabel();
            backgroundLabel.setBackground(Color.LIGHT_GRAY);
            backgroundLabel.setOpaque(true);
        }

        // Inisialisasi JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));

        // Tambahkan Gambar Latar Belakang ke Layer Bawah (Layer 0)
        backgroundLabel.setBounds(0, 0, 800, 600);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Inisialisasi Panel Login (Form)
        panelLogin = new JPanel();
        panelLogin.setLayout(new GridLayout(3, 2, 10, 10));
        panelLogin.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panelLogin.setOpaque(false); 
        // Komponen Label 
        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE); 
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE); 
        // Komponen Input Type
        emailField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        // Tambahkan komponen ke panelLogin
        panelLogin.add(emailLabel);
        panelLogin.add(emailField);
        panelLogin.add(passwordLabel);
        panelLogin.add(passwordField);
        panelLogin.add(new JLabel()); // Placeholder
        panelLogin.add(loginButton);

        // 5. Atur Posisi dan Ukuran panelLogin di Layer Atas (Layer 1)
        // Kita atur panelLogin di tengah jendela, dengan ukuran yang sesuai (misal 300x150)
        int panelWidth = 400;
        int panelHeight = 150;
        int x = (800 - panelWidth) / 2; // Hitung posisi X tengah
        int y = (600 - panelHeight) / 2; // Hitung posisi Y tengah
        // 200 makin kecil spacenya --> 300 (maksudnya padding 300 atas 300 bawah makanya makin sempit)
        // 400 makin lebar buat si PALLETTE --> 200 (maksudnya padding 200 kiri 200 kanan makanya makin luas)
        panelLogin.setBounds(x, y, panelWidth, panelHeight);
        layeredPane.add(panelLogin, JLayeredPane.PALETTE_LAYER); // Letakkan di layer di atas default

        add(layeredPane); 
        pack(); // ngatur ukuran frame agar sesuai dengan layeredPane
        setVisible(true);
    }

    public final JLabel addLoginBackground() {
        ImageIcon bgImage;
        JLabel displayImage;
        try {
            bgImage = new ImageIcon(getClass().getResource("login_bandara.png"));
            Image image = bgImage.getImage(); 
            Image newImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH); 
            displayImage = new JLabel(new ImageIcon(newImage));
            return displayImage;
        } catch (Exception e) {
            System.out.println("Image not found! Error: " + e.getMessage());
            return null;
        }
    }
}