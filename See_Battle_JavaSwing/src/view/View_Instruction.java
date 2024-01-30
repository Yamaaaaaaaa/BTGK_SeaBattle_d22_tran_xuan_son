package view;

import javax.swing.*;
import java.awt.*;

public class View_Instruction extends JFrame {
    public View_Instruction(){
        this.setTitle("INSTRUCTION:");
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);


        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
