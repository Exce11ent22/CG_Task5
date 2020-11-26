package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    private int x, y;
    private int dx;
    Timer timer;
    Flame flame;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        timer = new Timer(1, this);
        timer.start();
        flame = new Flame(PANEL_WIDTH/2, PANEL_HEIGHT/2, 30);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        flame.paint(g2d);
        g2d.setColor(new Color(115, 80, 0));
        g2d.fillRect(249, 250, 2, 20);
        g2d.setColor(new Color(252, 206, 3));
        g2d.fillRect(235, 270, 30, 250);
        g2d.drawString("Помянем...", 350,350);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        flame.animation(dx/3);
        repaint();
        dx *= 0.99;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 2){
            flame.reset();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dx = e.getX() - x;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
