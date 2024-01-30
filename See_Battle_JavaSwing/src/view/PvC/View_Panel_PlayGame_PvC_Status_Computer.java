package view.PvC;

import javax.swing.*;
import java.awt.*;

public class View_Panel_PlayGame_PvC_Status_Computer extends JPanel {
    private JTextField jTextField_Status_Computer;

    public View_Panel_PlayGame_PvC_Status_Computer() {
        this.init();
    }

    private void init(){
        jTextField_Status_Computer = new JTextField("Computer is Attacking");
        this.setLayout(new FlowLayout());
        this.add(jTextField_Status_Computer);
    }
    private void setText_1(){
        this.jTextField_Status_Computer.setText("Computer is Attacking");
    }
    private void setText_2(){
        this.jTextField_Status_Computer.setText(" ");
    }
}
