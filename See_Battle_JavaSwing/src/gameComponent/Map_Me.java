package gameComponent;

public class Map_Me {
    private int[][] map;

    //public int[][] board_Me = new int[30][30];
    //// 0: Ko có j : "~"
    //// 1: Có tàu, chưa bị đánh bom (X: nền xanh)
    //// 2: Có tàu, đã bị đánh bom (X: nền đỏ)

    private int size;
    public Map_Me(int size) {
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
