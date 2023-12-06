import java.util.Scanner;
public class Talking_Menu {
    public void Hello(){
        System.out.println("Welcome to Sea Battle");
    }
    public void Hello_PvP(){
        System.out.println("Welcome to PvP Mode:");
    }
    public void Hello_PvC(){
        System.out.println("Welcome to PvC Mode:");
    }
    public void GoodBye(){
        System.out.println("Good Bye, See you again!");
    }
    public void Instruction(){
        System.out.println("zzzzz");
    }
    public void ShowRanking(){
        System.out.println("| STT | Name          | Turn Play |");
        System.out.println("===================================");
        for(int i = 0 ;i < Main.List_Ranking.size(); i++){
            System.out.println(String.format("| "+ "%-3s" + " | " + "%-13s" + " | " + "%-9s" + " |", i, Main.List_Ranking.get(i).Name, Main.List_Ranking.get(i).Turn));
            System.out.println("-----------------------------------");
        }
    }
//    public void SaveGame(){
//        System.out.println("Do you want to save game?: 1: Save.  0: No");
//        Scanner sc = new Scanner(System.in);
//        int save = sc.nextInt();
//        if(save == 0){
//            Main.thelastgame = 1;
//        }
//        else Main.thelastgame = 0;
//    }
}
