package view.PvC;


import controller.Listener_Playgame_PvC_Enter_Ship;
import model.feature.Check_Attack;
import model.feature.Check_Winner;
import model.player.Computer;
import model.player.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class View_PlayGame_PvC extends JFrame {
    private Person person;
    private Computer computer;
    Font font1 = new Font("Arial", Font.BOLD, 20);
    Font font2 = new Font("Arial", Font.ITALIC, 20);
    Font font3 = new Font("Arial", Font.BOLD, 40);

    private View_Panel_PlayGame_PvC_Status_Player_Enter_ShipandAttack viewPanelPlayGamePvCStatusPlayerEnterShip;
    private View_Panel_PlayGame_PvC_PlayGame_Map viewPanelPlayGamePvCPlayGameMap;
    private View_Panel_PlayGame_PvC_Status_Game viewPanelPlayGamePvCStatusGame;
    private View_Panel_PlayGame_PvC_Status_Computer viewPanelPlayGamePvCStatusComputer;
    public View_PlayGame_PvC(Person person,Computer computer) {
        this.person = person;
        this.computer = computer;
        this.computer.CreatMap();
        this.init();
    }
    private void init() {
        this.setTitle("Player Vs Computer");
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
    // 0:
        ActionListener ac = new Listener_Playgame_PvC_Enter_Ship(this);
    // 1
        this.viewPanelPlayGamePvCStatusGame = new View_Panel_PlayGame_PvC_Status_Game();

        this.viewPanelPlayGamePvCPlayGameMap = new View_Panel_PlayGame_PvC_PlayGame_Map(this.person);

        this.viewPanelPlayGamePvCStatusPlayerEnterShip = new View_Panel_PlayGame_PvC_Status_Player_Enter_ShipandAttack(this.person,this.viewPanelPlayGamePvCPlayGameMap,this.computer,ac);

        this.viewPanelPlayGamePvCStatusComputer = new View_Panel_PlayGame_PvC_Status_Computer();


    // 6. Add vào Panel tổng
        this.setLayout(new BorderLayout());
        this.add(viewPanelPlayGamePvCStatusGame,BorderLayout.NORTH);
        this.add(viewPanelPlayGamePvCPlayGameMap,BorderLayout.CENTER);
        this.add(viewPanelPlayGamePvCStatusPlayerEnterShip,BorderLayout.SOUTH);
    }
    public void getText_Address(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.getText();
    }
    public void checkShip_EnterShip(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.checkShip();
    }
    public void checkCompleted_EnterShip(){
        if(this.viewPanelPlayGamePvCStatusPlayerEnterShip.getShip().equals("Completed Create Ship")){
            this.setText_Status_Game_Attacking_Round();
            this.viewPanelPlayGamePvCStatusPlayerEnterShip.setText_jTextField_Person_Attack();
        }
    }
    public void setText_Status_Computer_Attack(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.setText_jTextField_Computer_Attack();
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.setTextButton_Attack_2();
    }
    public void setText_Status_Person_Attack(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.setText_jTextField_Person_Attack();
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.setTextButton_Attack();
    }
    private void setText_Status_Game_Attacking_Round(){
        this.viewPanelPlayGamePvCStatusGame.Round_PlayGame();
    }
    public void set_AttackTurn_EnterAddress(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.openPanel_EnterShip();
    }



    private int check_ATK_OK;
    public void checkAttack_Person_turn(){
        check_ATK_OK = this.viewPanelPlayGamePvCStatusPlayerEnterShip.check_Attack_Person_turn_view();
    }
    public void checkAttack_Computer_turn(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.check_Attack_Computer_turn_view();
    }
    public int getCheckATK_OK(){
        return this.check_ATK_OK;
    }


    public void setMap_Attacked(){
        this.viewPanelPlayGamePvCPlayGameMap.setMap(person);
    }


    private int winner;
    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public void checkWinner_Person(){
        Check_Winner checkWinner = new Check_Winner(this.computer.getMap_Me(),this.computer.getSize());
        if(checkWinner.getCheck() == 1){
            this.setWinner_Person();
        }
    }
    private void setWinner_Person(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.closePanel_Entership_Player();
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.setText_jTextField_Person_Winner();
    }

    public void checkWinner_Computer(){
        Check_Winner checkWinner = new Check_Winner(this.person.getMap_Me(),this.person.getSize());
        if(checkWinner.getCheck() == 1){
            this.setWinner_Computer();
        }
    }
    private void setWinner_Computer(){
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.setText_jTextField_Computer_Winner();
        this.viewPanelPlayGamePvCStatusPlayerEnterShip.closePanel_Entership_Player();
    }
    public void open(){
        this.setVisible(true);
    }
    public void close(){
        this.setVisible(false);
    }
}
