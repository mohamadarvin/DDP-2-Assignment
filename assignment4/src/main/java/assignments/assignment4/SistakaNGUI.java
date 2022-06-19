package assignments.assignment4;

import assignments.assignment4.frontend.HomeGUI;

import javax.swing.*;

// import assignments.assignment4.backend.

public class SistakaNGUI extends JFrame {

    public static void main(String[] args) {
        // Membuat Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SistakaNG");

        // TODO: Tambahkan hal-hal lain yang diperlukan

        new HomeGUI(frame);
        frame.setVisible(true);

    }

}
