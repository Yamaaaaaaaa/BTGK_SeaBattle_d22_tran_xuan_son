public class Game_Menu_Player {

    public void CreateNewMap_PvP() {
        Player player1 = new Person();
        Player player2 = new Person();

        System.out.println("Enter player1's name: ");
        player1.Enter_Name();
        System.out.println("Enter player2's name: ");
        player2.Enter_Name();
        player1.Mode = "PvP";
        player2.Mode = "PvC";

        Main.List.addElement(player1);
        Main.List.addElement(player2);

        System.out.println("Enter size of Map(10 -> 20):");
        Main.List.get(0).Enter_Size();
        Main.List.get(1).size = Main.List.get(0).size;

        Main.List.get(0).CreatNewBoard();
        Main.List.get(1).CreatNewBoard();
        Main.List.get(0).CreatNewBoard_Enemy();
        Main.List.get(1).CreatNewBoard_Enemy();
    }
    public void CreateNewMap_PvC() {
        Player player1 = new Person();
        Player player2 = new Computer(); // Mặc định bot là Player 2

        System.out.println("Enter player's name: ");
        player1.Enter_Name();
        player1.Mode = "PvP";
        Main.List.addElement(player1);
        Main.List.addElement(player2);

        System.out.println("Enter size of Map(10 -> 20):");
        Main.List.get(0).Enter_Size();
        Main.List.get(1).size = Main.List.get(0).size;

        Main.List.get(0).CreatNewBoard();
        Main.List.get(1).CreatNewBoard();
        Main.List.get(0).CreatNewBoard_Enemy();
        Main.List.get(1).CreatNewBoard_Enemy();
    }
    public void CreateBoat(int enemy) {
        for (int i = 0; i <= 1; i++) {
            if (i == 1 && enemy == 2)  // PvC
            {
                System.out.println("Computer is creating boat: ");

                int check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_PatrolBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_PatrolBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_DestroyerBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_Submarine();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_BattleShip();
                }
                Main.List.get(i).SeeMap();
            } else {
                System.out.println("Player " + (i + 1) + " is creating boat: ");

                int check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_PatrolBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_PatrolBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_DestroyerBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_Submarine();
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_BattleShip();
                }

                Main.List.get(i).SeeMap();
            }
        }
    }

    public void PlayNow(int enemy){
        while (true)
        {
            int cnt = 0;
            for (int i = 0; i <= 1; i++)
            {
                // B3: Attack Turn
                if (i == 1 && enemy == 2)  // PvC
                {
                    if(Main.List.get(i).check_greedy == 0) {
                        ((Computer)Main.List.get(i)).TurnAttack_Computer_Random(i);
                    }
                    else{
                        int[] dx = {0,-1,+1,0};
                        int[] dy = {-1,0,0,+1};
                        int attacked = 0;//Check xem tấn công đc chưa
                        for(int j = 0; j < 4; j++) {
                            ((Computer) Main.List.get(i)).TurnAttack_Computer_Greedy(i, Main.List.get(i).x_id + dx[j], Main.List.get(i).y_id + dy[j]);
                            if (Main.List.get(i).check_greedy != 0) // Có tàu ở vị trí + j, chỉ TH này thì mới kết thúc turn máy
                            {
                                System.out.println("Computer is Attacking ....."); //Nếu tìm thấy thì  mới show ra địa chỉ,ko thì thôi.
                                Main.List.get(i).x_id += dx[j];
                                Main.List.get(i).y_id += dy[j];
                                System.out.println(Main.List.get(i).x_id + " " + Main.List.get(i).y_id);
                                attacked = 1;
                                break;
                            }
                        }
                        if(attacked == 0) //Nếu chưa tấn công đc
                        {
                            Main.List.get(i).check_greedy = 0;
                            ((Computer)Main.List.get(i)).TurnAttack_Computer_Random(i);
                        }
                    }
                  //  Main.List.get(i).SeeMap();
                } else {
                    ((Person)Main.List.get(i)).TurnAttack_Person(i);
                  //  Main.List.get(i).SeeMap();
                }

                // B4: Check Winner
                cnt = 0;
                //  ClearScreen.clrscr();
                for (int p = 0; p < Main.List.get(1).size; p++) {
                    for (int q = 0; q < Main.List.get(1).size; q++) {
                        if (Main.List.get(1 - i).board_Me[p][q] == 1) cnt++;
                    }
                }
                if (cnt == 0) {
                    if(enemy == 2 && i == 1) System.out.println("Computer is winner");
                    else System.out.println("CONGRATULATION! Player " + i + " is winner!");
                    Main.List_Ranking.addElement(Main.List.get(i));
                //    Main.thelastgame = 0;
                    break;
                }
            }
            if (cnt == 0) break;
        }
    }
}
