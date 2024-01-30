package model.player;

import gameComponent.Map_Enemy;
import gameComponent.Map_Me;
import model.feature.Check_Attack;
import model.feature.Check_Enter_Ship;

import java.util.Random;

public class Computer {
    private String name;
    private int size;
    private Map_Me map_Me;
    private Map_Enemy map_Enemy;
    public Computer() {
    }
    public void CreatMap(){
        map_Enemy = new Map_Enemy(this.size);
        map_Me = new Map_Me(this.size);
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getMap_Me() {
        return map_Me.getMap();
    }
    public void setMap_Me(int[][] map) {
        this.map_Me.setMap(map);
    }

    public int[][] getMap_Enemy() {
        return map_Enemy.getMap();
    }

    public void setMap_Enemy(int[][] map_enemy) {
        this.map_Enemy.setMap(map_enemy);
    }

    public void Create_Ship_Auto(){
        String ship = "Patrol Boat 1";

        while(true){
            Random i1 = new Random();
            Random i2 = new Random();
            Random j1 = new Random();
            Random j2 = new Random();
            Check_Enter_Ship checkEnterShip = new Check_Enter_Ship(this.map_Me.getMap(),ship,i1.nextInt(size),j1.nextInt(size),i2.nextInt(size),j2.nextInt(size));
            if(checkEnterShip.getCheck() == 1){
                this.map_Me.setMap(checkEnterShip.getMap());
                if(ship.equals("Patrol Boat 1")) {
                    ship = "Patrol Boat 2";
                }
                else if(ship.equals("Patrol Boat 2")){
                    ship = "Destroyer Boat";
                }
                else if(ship.equals("Destroyer Boat")) {
                    ship = "Submarine";
                }
                else if(ship.equals("Submarine")){
                    ship = "Battle Ship";
                }
                else if(ship.equals("Battle Ship")){
                    ship = "Completed Create Ship";
                    break;
                }
            }
        }
    }

    private int check_greedy;
    private int x_id,y_id;
    public void Attack_Turn(int[][] map_Person){
        if(check_greedy == 1){
            this.Attack_Turn_Greedy(map_Person);
        }
        else{
            this.Attack_Turn_Ramdom(map_Person);
        }
    }
    private void Attack_Turn_Ramdom(int[][] map_Person){
        Random x = new Random();
        Random y = new Random();
        int x0;
        int y0;
        while(true){
            x0 = x.nextInt(size);
            y0 = y.nextInt(size);
            if(map_Enemy.getMap()[x0][y0] == 0) break; // bỏ qua những chỗ đánh bom rồi
        }
        Check_Attack check_attack = new Check_Attack(map_Person,map_Enemy.getMap(),x0,y0,size);
        check_greedy = check_attack.getCheck(); // tk i ATK tk 1 - i;
        this.x_id = x0;
        this.y_id = y0;
    }
    private void Attack_Turn_Greedy(int[][] map_Person){
        int[] dx = {0,-1,+1,0};
        int[] dy = {-1,0,0,+1};
        int attacked = 0;//Check xem tấn công đc chưa
        for(int j = 0; j < 4; j++) {
            if((x_id + dx[j] <0 || x_id + dx[j]>=size)||(y_id + dy[j]<0 ||y_id + dy[j]>=size)){}
            else {
                if(map_Enemy.getMap()[x_id+ dx[j]][y_id+ dy[j]] != 0){}
                else {
                    Check_Attack check_attack = new Check_Attack(map_Person,map_Enemy.getMap(),x_id + dx[j],y_id + dy[j],size);
                    attacked = check_attack.getCheck();
                    if(attacked == 1){
                        check_greedy = 1;
                        this.x_id = x_id + dx[j];
                        this.y_id = y_id + dy[j];
                        return;
                    }
                }
            }
        }
        if(attacked == 0) //Nếu chưa tấn công đc
        {
            check_greedy = 0;
            this.Attack_Turn_Ramdom(map_Person);
        }
    }
    public void Show_Ship(){
        for(int i = 0; i < size; i++){
            for(int j = 0 ; j < size; j++){
                System.out.print("[" + this.getMap_Me()[i][j] + "] " );
            }
            System.out.println();
        }
    }
}
