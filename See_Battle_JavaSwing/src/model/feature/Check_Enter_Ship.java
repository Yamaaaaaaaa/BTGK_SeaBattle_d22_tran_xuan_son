package model.feature;

import gameComponent.Map_Enemy;

public class Check_Enter_Ship {
    // Nhiệm vụ của Class này: trả vầ giá trị check của từn lần đặt thuyền là xong
    private int check;
    private int[][] map;
    private String ship;
    private int X1,Y1,X2,Y2;
    public Check_Enter_Ship(int[][] map,String ship,int X1,int Y1,int X2,int Y2) {
        this.map = map;
        this.ship = ship;

        if(ship.equals("Patrol Boat 1")){
            this.check = Check_PatrolBoat(X1,Y1,X2,Y2);
        }
        else if(ship.equals("Patrol Boat 2")){
            this.check = Check_PatrolBoat(X1,Y1,X2,Y2);
        }
        else if(ship.equals("Destroyer Boat")){
            this.check = Check_DestroyerBoat(X1,Y1,X2,Y2);
        }
        else if(ship.equals("Submarine")){
            this.check = Check_Submarine(X1,Y1,X2,Y2);
        }
        else if(ship.equals("Battle Ship")){
            this.check = Check_BattleShip(X1,Y1,X2,Y2);
        }
    }
    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getCheck() {
        return check; // Nếu check = 1 thì getMap luoon
    }

    private int Check_PatrolBoat(int i1, int j1, int i2, int j2) // enemy check com or player
    {
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 2){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(map[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                map[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 2) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(map[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                map[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
    private int Check_DestroyerBoat(int i1,int j1,int i2,int j2){
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 4){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(map[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                map[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 4) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(map[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                map[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
    private int Check_Submarine(int i1, int j1,int i2,int j2){
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 3){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(map[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                map[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 3) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(map[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                map[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
    private int Check_BattleShip(int i1,int j1, int i2,int j2){
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 5){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(map[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                //System.out.println("nhapo");
                map[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 5) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(map[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                map[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
}
