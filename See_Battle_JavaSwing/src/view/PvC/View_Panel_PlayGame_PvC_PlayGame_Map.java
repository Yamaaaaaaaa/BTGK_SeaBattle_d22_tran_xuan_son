package view.PvC;

import model.player.Person;

import javax.swing.*;
import java.awt.*;

public class View_Panel_PlayGame_PvC_PlayGame_Map extends JPanel {
    private Person person;
    private JTextField[][] jTextField_Map_Me;
    private JTextField[][] jTextField_Map_Enemy;
    //public int[][] board_Me = new int[30][30];
    //// 0: Ko có j : "~"
    //// 1: Có tàu, chưa bị đánh bom (X: nền xanh)
    //// 2: Có tàu, đã bị đánh bom (X: nền đỏ)

    //public int[][] board_Enemy = new int[30][30]; // Ở đây là 2 ng chơi, nếu cần thêm thì tạo vector
    //// 0: Ko có j: "~"
    //// 1: Đã đánh bom, ko có tàu (*: BlUE)
    //// 2: Đã đánh bom, có tàu (X :nền đỏ)
    Font font3 = new Font("Arial", Font.BOLD, 60);
    public View_Panel_PlayGame_PvC_PlayGame_Map(Person person) {
        this.person = person;
        this.person.CreatMap();
        this.init();
    }

    private void init(){
        // 1:(Quân Mình) Panel Map của quân ta và phần map đã đanh trúng của kẻ địch
        this.setLayout(new GridLayout(1, 2, 20, 20));

        JPanel jPanel_Map_Me = new JPanel();
        jPanel_Map_Me.setLayout(new GridLayout(this.person.getSize(), this.person.getSize()));
        JPanel jPanel_Map_Enemy = new JPanel();
        jPanel_Map_Enemy.setLayout(new GridLayout(this.person.getSize(), this.person.getSize()));


        jTextField_Map_Me = new JTextField[this.person.getSize() + 5][this.person.getSize() + 5];
        jTextField_Map_Enemy = new JTextField[this.person.getSize() + 5][this.person.getSize() + 5];

        for (int i = 0; i < this.person.getSize(); i++) {
            for (int j = 0; j < this.person.getSize(); j++) {

                jTextField_Map_Me[i][j] = new JTextField("~");
                jTextField_Map_Enemy[i][j] = new JTextField("~");

                jPanel_Map_Me.add(jTextField_Map_Me[i][j]);
                jPanel_Map_Enemy.add(jTextField_Map_Enemy[i][j]);
            }
        }

        this.add(jPanel_Map_Me);
        this.add(jPanel_Map_Enemy);
    }
    public void setMap(Person person){
        this.person = person;
        int[][] map = this.person.getMap_Me();
        int[][] map_en = this.person.getMap_Enemy();
        for (int i = 0; i < this.person.getSize(); i++) {
            for (int j = 0; j < this.person.getSize(); j++) {
                if(map[i][j] == 1) {
                    jTextField_Map_Me[i][j].setText("X");
                    jTextField_Map_Me[i][j].setBackground(Color.BLUE);
                }
                else if(map[i][j] == 2){
                    jTextField_Map_Me[i][j].setText("X");
                    jTextField_Map_Me[i][j].setBackground(Color.RED);
                }

                if(map_en[i][j] == 1){
                    jTextField_Map_Enemy[i][j].setText("*");
                    jTextField_Map_Enemy[i][j].setFont(font3);
                    jTextField_Map_Enemy[i][j].setForeground(Color.BLUE);
                }
                else if(map_en[i][j] == 2){
                    jTextField_Map_Enemy[i][j].setText("X");
                    jTextField_Map_Enemy[i][j].setBackground(Color.RED);
                }
            }
        }
    }

}
