package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JPanel mainPanel;
    private JPanel Panel;
    private JButton drawButton;
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldCD;
    private JTextField textFieldCR;
    private JLabel labelX1;
    private JLabel labelX2;
    private JLabel labelY1;
    private JLabel labelY2;
    private JTextField textFieldZ;
    private JLabel labelZ;
    private JLabel labelChieuCao;
    private JTextField textFieldCC;

    public App() {
        setTitle("Paint");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //DrawLine dr = new DrawLine();


        final HinhHopChuNhat[] hcn = {new HinhHopChuNhat(0, 0, 0, 0, 0, 0)};
//
//
        Panel.add(hcn[0]);


        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textFieldX.getText();
                int x = Integer.parseInt(text);
                text = textFieldCD.getText();
                int cd = Integer.parseInt(text);
                text = textFieldY.getText();
                int y = Integer.parseInt(text);
                text = textFieldCR.getText();
                int cr = Integer.parseInt(text);
                text = textFieldZ.getText();
                int z = Integer.parseInt(text);
                text = textFieldCC.getText();
                int cc = Integer.parseInt(text);

//                hcn.x = x;
//                hcn.y = y;
//                hcn.z = z;
//                hcn.chieuDai = cd;
//                hcn.chieuRong = cr;
//                hcn.chieuCao = cc;

                //hcn.drawHinhHopChuNhat();
                HinhHopChuNhat hcn1 = new HinhHopChuNhat(x, y, z, cd, cr, cc);
//                Panel.add(hcn1);
                hcn[0] = hcn1;
                hcn[0].drawHinhHopChuNhat();
            }
        });
        add(mainPanel);
    }
}
