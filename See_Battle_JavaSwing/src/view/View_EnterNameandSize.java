package view;

import controller.Listener_EnterNameandSize;
import controller.Listener_Playgame_PvC_Enter_Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View_EnterNameandSize extends JFrame {
    private String name;
    private int size;
    private JTextField jTextField_EnterName_1;
    private JTextField jTextField_EnterSize_1;

    public View_EnterNameandSize()  {
        this.init();
    }

    private void init(){
        this.setTitle("Player Vs Player");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);

        // 0:
        Font font1 = new Font("Arial", Font.BOLD, 20);
        Font font2 = new Font("Arial", Font.ITALIC, 20);
        Font font3 = new Font("Arial", Font.BOLD, 40);
        ActionListener ac = new Listener_EnterNameandSize(this);
        // 1: Panel Nhập tên:

        JPanel jPanel_EnterNameandSize = new JPanel();


        JPanel jPanel_Player1 = new JPanel();

        JLabel jLabel_EnterName_1 = new JLabel("Enter your name here: ");
        jLabel_EnterName_1.setFont(font1);
        jTextField_EnterName_1 = new JTextField();

        JLabel jLabel_EnterSize_1 = new JLabel("Enter Size here: ");
        jLabel_EnterSize_1.setFont(font1);
        jTextField_EnterSize_1 = new JTextField();

        jPanel_Player1.setLayout(new GridLayout(2,2));
        jPanel_Player1.add(jLabel_EnterName_1);
        jPanel_Player1.add(jTextField_EnterName_1);
        jPanel_Player1.add(jLabel_EnterSize_1);
        jPanel_Player1.add(jTextField_EnterSize_1);

        JButton jButton_SaveName = new JButton("Save");
        jButton_SaveName.setFont(font1);
        jButton_SaveName.addActionListener(ac);

        jPanel_EnterNameandSize.setLayout(new BorderLayout());
        jPanel_EnterNameandSize.add(jPanel_Player1,BorderLayout.CENTER);
        jPanel_EnterNameandSize.add(jButton_SaveName,BorderLayout.EAST);


        this.setLayout(new BorderLayout());
        this.add(jPanel_EnterNameandSize,BorderLayout.NORTH);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public String get_Name(){
        return this.jTextField_EnterName_1.getText();
    }
    public int get_Size(){
        String s = this.jTextField_EnterSize_1.getText();
        int tmp = 0;
        for(int i = 0 ;i < s.length(); i++){
            tmp*=10;
            tmp += ((int)s.charAt(i) - 48);
        }
        return tmp;
    }
    public void open(){
        this.setVisible(true);
    }
    public void close(){
        this.setVisible(false);
    }
}
