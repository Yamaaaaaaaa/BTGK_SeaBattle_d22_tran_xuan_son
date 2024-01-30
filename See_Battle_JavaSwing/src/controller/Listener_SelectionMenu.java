package controller;

import view.View_EnterNameandSize;
import view.View_Instruction;
import view.View_SelectionMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_SelectionMenu implements ActionListener {
    private final View_SelectionMenu viewSelectionMenu;

    public Listener_SelectionMenu(View_SelectionMenu viewSelectionMenu) {
        this.viewSelectionMenu = viewSelectionMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String src = e.getActionCommand();
         if(src.equals("1. PvP Mode.")){
         }
         else if(src.equals("2. PvC Mode.")){
             View_EnterNameandSize viewEnterNameandSize = new View_EnterNameandSize();
             this.viewSelectionMenu.close();
             viewEnterNameandSize.open();
         }
         else if(src.equals("3. Instruction.")){

             View_Instruction viewInstruction = new View_Instruction();
             this.viewSelectionMenu.close();
            // viewInstruction.open();
         }
         else if(src.equals("4. Ranking.")){
             viewSelectionMenu.close();
             View_Instruction viewInstruction = new View_Instruction();
         }
         else if(src.equals("5. Exit and Save game.")){
             viewSelectionMenu.close();
             View_Instruction viewInstruction = new View_Instruction();
         }

    }
}
