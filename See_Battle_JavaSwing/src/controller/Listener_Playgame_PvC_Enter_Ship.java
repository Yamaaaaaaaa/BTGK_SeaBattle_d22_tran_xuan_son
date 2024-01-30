package controller;

import view.PvC.View_Panel_PlayGame_PvC_Status_Player_Enter_ShipandAttack;
import view.PvC.View_PlayGame_PvC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Playgame_PvC_Enter_Ship implements ActionListener {
    private View_PlayGame_PvC viewPlayGamePvC;
    public Listener_Playgame_PvC_Enter_Ship(View_PlayGame_PvC viewPlayGamePvC) {
        this.viewPlayGamePvC = viewPlayGamePvC;
    }
    private int check_Entership_ok = 0;
    private int Check_Atk_ok = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Enter")){
            this.viewPlayGamePvC.checkCompleted_EnterShip();
            this.viewPlayGamePvC.getText_Address();
            this.viewPlayGamePvC.checkShip_EnterShip();
        }
        else if (src.equals("Enter to Attack")){
            if(check_Entership_ok == 0){
                this.viewPlayGamePvC.set_AttackTurn_EnterAddress();
                check_Entership_ok ++;
            }
            else{
                this.viewPlayGamePvC.getText_Address();
                this.viewPlayGamePvC.checkAttack_Person_turn();
                Check_Atk_ok = this.viewPlayGamePvC.getCheckATK_OK();
                if(Check_Atk_ok == 1){
                    // Set view cho Map Person_enemy va Person+ Check WInner
                    this.viewPlayGamePvC.setMap_Attacked();
                    this.viewPlayGamePvC.checkWinner_Person();


                    // chuyen sang computer Attack +Check Winner
                    this.viewPlayGamePvC.setText_Status_Computer_Attack();
                    this.viewPlayGamePvC.checkAttack_Computer_turn();
                    this.viewPlayGamePvC.checkWinner_Computer();
                    Check_Atk_ok = 0;
                }
                else{
                    JOptionPane.showMessageDialog(this.viewPlayGamePvC,
                            "Nhập Dữ liệu tấn công sai!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(src.equals("Enter to go Your Turn")){
            // chuyen sang ng
            this.viewPlayGamePvC.setText_Status_Person_Attack();
        }
    }
}
