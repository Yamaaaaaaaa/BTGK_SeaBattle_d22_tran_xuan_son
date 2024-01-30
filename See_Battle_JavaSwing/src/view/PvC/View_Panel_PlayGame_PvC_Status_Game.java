package view.PvC;

import javax.swing.*;
import java.awt.*;

public class View_Panel_PlayGame_PvC_Status_Game extends JPanel {
    Font font1 = new Font("Arial", Font.BOLD, 20);
    Font font2 = new Font("Arial", Font.ITALIC, 20);
    Font font3 = new Font("Arial", Font.BOLD, 40);
    private JTextField jTextField_Status_Game;

    public View_Panel_PlayGame_PvC_Status_Game() {
        this.init();
    }

    private void init(){
        jTextField_Status_Game = new JTextField();
        jTextField_Status_Game.setFont(font2);
        Round_Start();

        this.setLayout(new FlowLayout());
        this.add(jTextField_Status_Game);
    }
    private void Round_Start(){
        this.jTextField_Status_Game.setText("Vòng chuẩn bị: Tạo bản đồ chiến thuật");
    }
    public void Round_PlayGame(){
        this.jTextField_Status_Game.setText("Let's Play Game !!!");
    }
}
