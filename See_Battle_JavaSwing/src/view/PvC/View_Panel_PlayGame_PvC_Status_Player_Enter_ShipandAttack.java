package view.PvC;

import model.feature.Check_Attack;
import model.feature.Check_Enter_Ship;
import model.player.Computer;
import model.player.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class View_Panel_PlayGame_PvC_Status_Player_Enter_ShipandAttack extends JPanel {
    private Person person;
    private Computer computer;
    private View_Panel_PlayGame_PvC_PlayGame_Map viewPanelPlayGamePvCPlayGameMap;
    private JPanel jPanel_Status_Player_EnterShip_and_Button;
    ActionListener ac;
    private JButton jButton_Status_Player_Enter_Boat;
    private JPanel jPanel_Status_Player_Enter_Boat;
    private JPanel jPanel_Status_Player_X2_Y2;
    private JPanel jPanel_Status_Player_X1_Y1;

    public View_Panel_PlayGame_PvC_Status_Player_Enter_ShipandAttack(Person person,View_Panel_PlayGame_PvC_PlayGame_Map viewPanelPlayGamePvCPlayGameMap,Computer computer,ActionListener ac) {
        this.person  = person;
        this.computer = computer;
        this.viewPanelPlayGamePvCPlayGameMap = viewPanelPlayGamePvCPlayGameMap;
        this.ac = ac;
        this.init();
    }

    Font font1 = new Font("Arial", Font.BOLD, 20);
    Font font0 = new Font("Arial", Font.BOLD, 15);
    Font font2 = new Font("Arial", Font.ITALIC, 20);
    Font font3 = new Font("Arial", Font.BOLD, 40);
    private JTextField jTextField_Status_Enter_Boat;
    private JTextField jTextField_X1;
    private JTextField jTextField_Y1;
    private JTextField jTextField_X2;
    private JTextField jTextField_Y2;
    private int X1,Y1,X2,Y2;


    private void init(){
        // 1. Panel Loại tàu cần nhập của Player:
        JPanel jPanel_Status_Player_Ship_Entering = new JPanel();

        jTextField_Status_Enter_Boat = new JTextField();
        jTextField_Status_Enter_Boat.setFont(font1);
        setText_Status_Player_PastrolBoat_1();

        jPanel_Status_Player_Ship_Entering.setLayout(new GridLayout(1,1));
        jPanel_Status_Player_Ship_Entering.add(jTextField_Status_Enter_Boat);


        // 2. Panel Nhap Tau
        jPanel_Status_Player_Enter_Boat = new JPanel();
        JLabel jLabel_Enter_X1 = new JLabel("Enter X1: ");
        jLabel_Enter_X1.setFont(font1);
        jTextField_X1 = new JTextField();
        jTextField_X1.setFont(font1);

        JLabel jLabel_Enter_Y1 = new JLabel("Enter Y1: ");
        jLabel_Enter_Y1.setFont(font1);
        jTextField_Y1 = new JTextField();
        jTextField_Y1.setFont(font1);

        JLabel jLabel_Enter_X2 = new JLabel("Enter X2: ");
        jLabel_Enter_X2.setFont(font1);
        jTextField_X2 = new JTextField();
        jTextField_X2.setFont(font1);

        JLabel jLabel_Enter_Y2 = new JLabel("Enter Y2: ");
        jLabel_Enter_Y2.setFont(font1);
        jTextField_Y2 = new JTextField();
        jTextField_Y2.setFont(font1);
            //1. Panel X1,y1
        jPanel_Status_Player_X1_Y1 = new JPanel();
        jPanel_Status_Player_X1_Y1.setLayout(new GridLayout(2,1));
        jPanel_Status_Player_X1_Y1.add(jLabel_Enter_X1);
        jPanel_Status_Player_X1_Y1.add(jTextField_X1);
        jPanel_Status_Player_X1_Y1.add(jLabel_Enter_Y1);
        jPanel_Status_Player_X1_Y1.add(jTextField_Y1);
            //2. Panel x2_y2
        jPanel_Status_Player_X2_Y2 = new JPanel();
        jPanel_Status_Player_X2_Y2.setLayout(new GridLayout(2,1));
        jPanel_Status_Player_X2_Y2.add(jLabel_Enter_X2);
        jPanel_Status_Player_X2_Y2.add(jTextField_X2);
        jPanel_Status_Player_X2_Y2.add(jLabel_Enter_Y2);
        jPanel_Status_Player_X2_Y2.add(jTextField_Y2);

        jPanel_Status_Player_Enter_Boat.setLayout(new GridLayout(2,1));
        jPanel_Status_Player_Enter_Boat.add(jPanel_Status_Player_X1_Y1);
        jPanel_Status_Player_Enter_Boat.add(jPanel_Status_Player_X2_Y2);

        // 3: Button Enter để check và nhập:

        jButton_Status_Player_Enter_Boat = new JButton("Enter");
        jButton_Status_Player_Enter_Boat.setFont(font1);
        jButton_Status_Player_Enter_Boat.addActionListener(ac);



        // 4. JPanel chung cua Nhap tau va Enter

        jPanel_Status_Player_EnterShip_and_Button = new JPanel();
        jPanel_Status_Player_EnterShip_and_Button.setLayout(new BorderLayout());
        jPanel_Status_Player_EnterShip_and_Button.add(jPanel_Status_Player_Enter_Boat,BorderLayout.CENTER);
        jPanel_Status_Player_EnterShip_and_Button.add(jButton_Status_Player_Enter_Boat,BorderLayout.EAST);





        //7. Panel Nhap Tau

        //5. add voo Panel chinh
        this.setLayout(new BorderLayout());
        this.add(jPanel_Status_Player_Ship_Entering,BorderLayout.NORTH);
        this.add(jPanel_Status_Player_EnterShip_and_Button,BorderLayout.CENTER);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void setText_Status_Player_PastrolBoat_1(){this.jTextField_Status_Enter_Boat.setText("Enter Pastrol Boat 1 (1x2):");}
    public void setText_Status_Player_PastrolBoat_2(){this.jTextField_Status_Enter_Boat.setText("Enter Pastrol Boat 2 (1x2) :");}
    public void setText_Status_Player_Destroyer_Boat(){this.jTextField_Status_Enter_Boat.setText("Enter Destroyer_Boat (1x4) :");}
    public void setText_Status_Player_Submarine(){
        this.jTextField_Status_Enter_Boat.setText("Enter Submarine (1x3) :");
    }
    public void setText_Status_Player_Battle_Boat(){
        this.jTextField_Status_Enter_Boat.setText("Enter Battle_Boat (1x5) :");
    }

    public void setTextButton_Attack(){
        this.jButton_Status_Player_Enter_Boat.setText("Enter to Attack");
        this.jButton_Status_Player_Enter_Boat.setFont(font0);
    }
    public void setTextButton_Attack_2(){
        this.jButton_Status_Player_Enter_Boat.setText("Enter to go Your Turn");
        this.jButton_Status_Player_Enter_Boat.setFont(font0);
    }
    public void getText(){
        this.X1 = get_Int(jTextField_X1.getText());
        this.Y1 = get_Int(jTextField_Y1.getText());
        this.X2 = get_Int(jTextField_X2.getText());
        this.Y2 = get_Int(jTextField_Y2.getText());
    }
    private String ship = "Patrol Boat 1";
    public String getShip() {
        return ship;
    }
    public void setShip(String ship) {
        this.ship = ship;
    }
    public void checkShip(){
        Check_Enter_Ship checkEnterShip= new Check_Enter_Ship(this.person.getMap_Me(),ship,X1,Y1,X2,Y2);
        if(checkEnterShip.getCheck() == 1) {
            // Set vao ma tran map
            this.person.setMap_Me(checkEnterShip.getMap());
            this.viewPanelPlayGamePvCPlayGameMap.setMap(person);
            // set vao jPanel
            if(this.ship.equals("Patrol Boat 1")) {
                this.setText_Status_Player_PastrolBoat_2();
                ship = "Patrol Boat 2";
            }
            else if(this.ship.equals("Patrol Boat 2")){
                this.setText_Status_Player_Destroyer_Boat();
                ship = "Destroyer Boat";
            }
            else if(this.ship.equals("Destroyer Boat")) {
                this.setText_Status_Player_Submarine();
                ship = "Submarine";
            }
            else if(this.ship.equals("Submarine")){
                this.setText_Status_Player_Battle_Boat();
                ship = "Battle Ship";
            }
            else if(this.ship.equals("Battle Ship")){
                this.setText_Status_Player_Battle_Boat();
                ship = "Completed Create Ship";

                this.jTextField_Status_Enter_Boat.setText("You completed Create Ship!, Computer is creating ship!");
                this.computer.Create_Ship_Auto();
                this.computer.Show_Ship();
                this.setTextButton_Attack();
                this.closePanel_EnterShip();
            }
        }
        else {
            if (!ship.equals("Completed Create Ship")) {
                JOptionPane.showMessageDialog(this,
                        "Nhập Dữ liệu sai!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public int check_Attack_Person_turn_view(){
        Check_Attack check_attack = new Check_Attack(this.computer.getMap_Me(),this.person.getMap_Enemy(),X1,Y1,this.person.getSize());
        if(check_attack.getCheck() == 0) // chỗ đó đã đánh rồi
        {
            return 0;
        }
        else{
            this.computer.setMap_Me(check_attack.getMap_me());
            this.person.setMap_enemy(check_attack.getMap_enemy());
            return 1;
        }
    }
    public void check_Attack_Computer_turn_view(){
        this.computer.Attack_Turn(this.person.getMap_Me());
    }
    public void setText_jTextField_Person_Attack(){
        this.jTextField_Status_Enter_Boat.setText("Your Turn, Enter Address To Attacking!");
    }
    public void setText_jTextField_Computer_Attack(){
        this.jTextField_Status_Enter_Boat.setText("Computer is Attacking");
    }
    private int get_Int(String s){
        int tmp = 0;
        for(int i = 0 ;i < s.length(); i++){
            tmp*=10;
            tmp += ((int)s.charAt(i) - 48);
        }
        return tmp;
    }
    public void setText_jTextField_Computer_Winner(){
        this.jTextField_Status_Enter_Boat.setText("Your're Loser,Computer is Winner!!!");
    }
    public void setText_jTextField_Person_Winner(){
        this.jTextField_Status_Enter_Boat.setText("Your're Winner!!!");
    }
    public void closePanel_Entership_Player(){
        this.jPanel_Status_Player_EnterShip_and_Button.setVisible(false);
    }
    public void closePanel_EnterShip(){this.jPanel_Status_Player_Enter_Boat.setVisible(false);}
    public void openPanel_EnterShip(){
        this.jPanel_Status_Player_X2_Y2.setVisible(false);
        this.jPanel_Status_Player_Enter_Boat.setVisible(true);
    }
    public void closePanel(){
        this.setVisible(false);
    }
    public void openPanel(){
        this.setVisible(true);
    }
}
