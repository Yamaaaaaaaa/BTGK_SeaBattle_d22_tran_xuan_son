package model.feature;

public class Check_Attack {
    private int check;
    private int[][] map_me;
    private int[][] map_enemy;
    private int X,Y,size;
    public Check_Attack(int[][] map_me,int[][] map_enemy,int X,int Y,int size){
        this.map_me = map_me;
        this.map_enemy = map_enemy;
        this.X = X;
        this.Y = Y;
        this.check = checkAttack();
        this.size = size;
    }
    private int checkAttack(){
    //    if((X<0 || X >= size) || (Y<0 || Y >= size)) return 0;
        if(this.map_me[X][Y] == 0){   // Nếu Ko có tàu
            this.map_enemy[X][Y] = 1; // Đã đánh bom, Ko có tàu
            return 1;
        }
        else if(this.map_me[X][Y] == 1){ // Có tàu, Chưa bị Đanh bom
            this.map_enemy[X][Y] = 2; // Có tàu, Bị đánh bom
            this.map_me[X][Y] = 2; // Có tàu, Bị đánh bom
            return 1; //Nếu đánh trúng tàu thì bật mode Greedy.
        }
        else if(this.map_enemy[X][Y] == 2 || this.map_enemy[X][Y] == 1){ //  Đã bắn rồi
            // KHÔNG CÓ th này do đã bị phá rồi th nó sẽ hiện ơ map TMP
            return 0;
        }
        return 0;
    }
    public int[][] getMap_me() {
        return map_me;
    }

    public int[][] getMap_enemy() {
        return map_enemy;
    }

    public void setMap_enemy(int[][] map_enemy) {
        this.map_enemy = map_enemy;
    }

    public void setMap_me(int[][] map_me) {
        this.map_me = map_me;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
