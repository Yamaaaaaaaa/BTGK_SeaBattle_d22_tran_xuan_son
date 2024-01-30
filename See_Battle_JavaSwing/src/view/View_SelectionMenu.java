package view;

import controller.Listener_SelectionMenu;
import model.menu.Menu_Selection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View_SelectionMenu extends JFrame {
    private Menu_Selection menuSelection;

    public View_SelectionMenu(Menu_Selection menuSelection) {
        this.menuSelection = menuSelection;
        this.init();
    }

    private void init() {
        this.setTitle("SEE BATTLE");
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);

        // 0:
        Font font1 = new Font("Arial", Font.BOLD, 20);
        Font font2 = new Font("Arial", Font.ITALIC, 20);
        Font font3 = new Font("Arial", Font.BOLD, 40);
        ActionListener listenerSelectionMenu = new Listener_SelectionMenu(this);
        // 1: Welcome
        JPanel jPanel_Welcome = new JPanel();

        JLabel jLabel_Welcome = new JLabel("WELCOME to SEABATTLE");
        jLabel_Welcome.setFont(font3);

        jPanel_Welcome.setLayout(new FlowLayout());
        jPanel_Welcome.add(jLabel_Welcome);

        //2: Selection Menu:
        JPanel jPanel_SelectionMenu = new JPanel();

        JButton jButton_1 = new JButton("1. PvP Mode.");
        jButton_1.setFont(font1);
        jButton_1.addActionListener(listenerSelectionMenu);
        JButton jButton_2 = new JButton("2. PvC Mode.");
        jButton_2.setFont(font1);
        jButton_2.addActionListener(listenerSelectionMenu);
        JButton jButton_3 = new JButton("3. Instruction.");
        jButton_3.setFont(font1);
        jButton_3.addActionListener(listenerSelectionMenu);
        JButton jButton_4 = new JButton("4. Ranking.");
        jButton_4.setFont(font1);
        jButton_4.addActionListener(listenerSelectionMenu);
        JButton jButton_5 = new JButton("5. Exit and Save game.");
        jButton_5.setFont(font1);
        jButton_5.addActionListener(listenerSelectionMenu);

        jPanel_SelectionMenu.setLayout(new GridLayout(4, 1));
        jPanel_SelectionMenu.add(jButton_1);
        jPanel_SelectionMenu.add(jButton_2);
        jPanel_SelectionMenu.add(jButton_3);
        jPanel_SelectionMenu.add(jButton_4);
        jPanel_SelectionMenu.add(jButton_5);


        //
        this.setLayout(new BorderLayout());
        this.add(jPanel_Welcome, BorderLayout.NORTH);
        this.add(jPanel_SelectionMenu, BorderLayout.CENTER);

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void open(){
        this.setVisible(true);
    }
    public void close(){
        this.setVisible(false);
    }
}
