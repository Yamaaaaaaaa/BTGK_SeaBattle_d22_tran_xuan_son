package model.feature;

public class Check_Winner {
    private int check = 1;
    private int[][] map;
    private int size;
    private int X1,Y1,X2,Y2;
    public Check_Winner(int[][] map,int size)
    {
        this.map = map;
        this.size = size;
        this.checkMap();
    }
    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }


    private void checkMap(){
        for(int i = 0 ; i < size; i++){
            for(int j = 0 ;j < size; j++){
                if(map[i][j] == 1){
                    check = 0;
                    return;
                }
            }
        }
    }
}
