package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

// TODO: Implementasikan hal-hal yang diperlukan
public class PeringkatPanel extends SistakaPanel {
    private JLabel titleLabel;
    private JLabel labelRankingAnggota;
    private JButton kembaliButton;

    private JPanel buttonPanel;

    public PeringkatPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        titleLabel = new JLabel("Peringkat");
        labelRankingAnggota = new JLabel("", JLabel.CENTER);
        kembaliButton = new JButton("Kembali");

        buttonPanel = new JPanel();

        titleLabel.setFont(HomeGUI.fontTitle);
        labelRankingAnggota.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);

        titleLabel.setForeground(new Color(0,255,0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelRankingAnggota.setForeground(new Color(0,255,0));
        kembaliButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(kembaliButton);

        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");

            }
        });

        kembaliButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                kembaliButton.setBackground(new Color(59, 80, 250));
                kembaliButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                kembaliButton.setBackground(new Color(30, 30, 30));
                kembaliButton.setForeground(new Color(209, 209, 209));
            }
        });

        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(30,30,30));
        GridBagConstraints gbc = new GridBagConstraints();

        this.add(titleLabel, gbc);
        gbc.gridy = 1;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 2;
        this.add(labelRankingAnggota, gbc);
        gbc.gridy = 3;
        this.add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        gbc.gridy = 4;
        this.add(buttonPanel, gbc);
        gbc.gridy = 5;

    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)

        labelRankingAnggota.setText(SistakaNG.handleRankingAnggota());
    }
}
