public class Person extends Player{
    int i1,j1,i2,j2;
    public int Add_PatrolBoat(){
        // nhập xong thì check ở Parent
        System.out.print("Set New Patrol Boat(1x2): ");
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_PatrolBoat(i1,j1,i2,j2);
    }
    public int Add_DestroyerBoat(){
        // nhập xong thì check ở Parent
        System.out.print("Set New Destroyer Boat(1x4): ");
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_DestroyerBoat(i1,j1,i2,j2);
    }
    public int Add_Submarine(){
        System.out.print("Set New Submarine(1x3): ");
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_Submarine(i1,j1,i2,j2);
    }
    public int Add_BattleShip(){
        System.out.print("Set New Battle Ship(1x5): ");
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_BattleShip(i1,j1,i2,j2);
    }
    public void TurnAttack_Person(int i){
        System.out.println("Player " +(i+1) + " is Attacking :");
//        System.out.println("Show Your Map: ");
//        Main.List.get(i).SeeMap();
//        System.out.println("Show Attacked Map of Your Enemy: ");
//        Main.List.get(i).SeeMap_Enemy();
        System.out.println("Show Your & Your Enemy's Map: ");
        Main.List.get(i).SeeMap_Full();
        System.out.println("Enter your address to Attack: ");
        // Mặc định ngừoi không đánh chỗ đã đánh rồi.
        int x = sc.nextInt();
        int y = sc.nextInt();
        int checktmp = Main.List.get(i).Check_Attack(x,y,i); // tk i ATK tk 1 - i; // cái check ko quan trong
    }
}
