package ru.sbrf.reboot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowsGame extends JFrame {

    private static WindowsGame winGame;
    private static Image back;
    private static Image over;
    private static Image blob;

    public static void main(String[] args) throws IOException {
        back = ImageIO.read(WindowsGame.class.getResourceAsStream("back.JPG"));
        over = ImageIO.read(WindowsGame.class.getResourceAsStream("gameover.JPG"));
        blob = ImageIO.read(WindowsGame.class.getResourceAsStream("blob.JPG"));
        winGame = new WindowsGame();
        winGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        winGame.setLocation(200,100);
        winGame.setSize(600,500);
        winGame.setResizable(false);
        GameField gameField = new GameField();
        winGame.add(gameField);
        winGame.setVisible(true);
    }

    private static void onRepaint(Graphics g){
//        g.fillOval(10,10,100,200);
//        g.drawLine(200,300,100,400);
        g.drawImage(back,0,0, null);
        g.drawImage(blob,100,100,null);
        g.drawImage(over,300,200,null);
    }

    private static class GameField extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
