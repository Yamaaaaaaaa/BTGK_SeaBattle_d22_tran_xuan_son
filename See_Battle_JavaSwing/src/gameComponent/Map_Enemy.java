package gameComponent;

public class Map_Enemy {
    private int[][] map;
    //public int[][] board_Enemy = new int[30][30]; // Ở đây là 2 ng chơi, nếu cần thêm thì tạo vector
    //// 0: Ko có j: "~"
    //// 1: Đã đánh bom, ko có tàu (*: BlUE)
    //// 2: Đã đánh bom, có tàu (X :nền đỏ)
    private int size;
    public Map_Enemy(int size) {
        this.map = new int[size + 5][size + 5];
        this.size = size;
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size; j++){
                map[i][j] = 0;
            }
        }
    }


    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
}
