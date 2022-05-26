package assignments.assignment4;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;
import assignments.assignment4.frontend.WelcomePanel;
import assignments.assignment4.backend.pengguna.Mahasiswa;
import assignments.assignment4.backend.pengguna.Dosen;
import assignments.assignment4.backend.pengguna.Mahasiswa;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

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
