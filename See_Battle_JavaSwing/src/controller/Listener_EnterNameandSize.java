package controller;

import model.player.Computer;
import model.player.Person;
import view.View_EnterNameandSize;
import view.PvC.View_PlayGame_PvC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_EnterNameandSize implements ActionListener {
    private View_EnterNameandSize viewEnterNameandSize;

    public Listener_EnterNameandSize(View_EnterNameandSize viewEnterNameandSize) {
        this.viewEnterNameandSize = viewEnterNameandSize;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Save")){
            // Laays size va name
            String name = this.viewEnterNameandSize.get_Name();
            int size = this.viewEnterNameandSize.get_Size();

            System.out.println(name + " " + size);


            Person person = new Person();
            Computer computer = new Computer();
            person.setSize(size);
            person.setName(name);
            computer.setSize(size);
            View_PlayGame_PvC viewPlayGamePvC = new View_PlayGame_PvC(person,computer);
            this.viewEnterNameandSize.close();
            viewPlayGamePvC.open();
        }
    }

}
