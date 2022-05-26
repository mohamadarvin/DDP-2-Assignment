package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class AnggotaHomePanel extends SistakaPanel {
    private JLabel titleLabel;
    private JButton peminjamanButton;
    private JButton pengembalianButton;
    private JButton pembayaranDendaButton;
    private JButton detailAnggotaButton;
    private JButton logoutButton;

    public AnggotaHomePanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        titleLabel = new JLabel();
        peminjamanButton = new JButton(String.format("Peminjaman"));
        pengembalianButton = new JButton(String.format("Pengembalian"));
        pembayaranDendaButton = new JButton(String.format("pembayaran Denda"));
        detailAnggotaButton = new JButton(String.format("Detail Anggota"));
        logoutButton = new JButton(String.format("Logout"));

        titleLabel.setFont(HomeGUI.fontTitle);
        peminjamanButton.setFont(HomeGUI.fontGeneral);
        pengembalianButton.setFont(HomeGUI.fontGeneral);
        pembayaranDendaButton.setFont(HomeGUI.fontGeneral);
        detailAnggotaButton.setFont(HomeGUI.fontGeneral);
        logoutButton.setFont(HomeGUI.fontGeneral);

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        peminjamanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        peminjamanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("peminjaman");

            }
        });
        pengembalianButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pengembalianButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("pengembalian");

            }
        });

        pembayaranDendaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pembayaranDendaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("pembayaran");

            }
        });

        detailAnggotaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailAnggotaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("detailUser");

            }
        });

        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("login");

            }
        });

        this.setLayout(new GridLayout(6, 1, 0, 10));

        this.add(titleLabel);
        this.add(peminjamanButton);
        this.add(pengembalianButton);
        this.add(pembayaranDendaButton);
        this.add(detailAnggotaButton);
        this.add(logoutButton);
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        titleLabel.setText(String.format("Selamat datang kembali %s!", main.getUser().getNama()));
    }

}
