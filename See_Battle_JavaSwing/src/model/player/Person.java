package model.player;

import gameComponent.Map_Enemy;
import gameComponent.Map_Me;

public class Person{
    private String name;
    private int size;
    private Map_Me map_Me;
    private Map_Enemy map_enemy;
    public Person() {
    }
    public void CreatMap(){
        map_Me = new Map_Me(this.size);
        map_enemy = new Map_Enemy(this.size);
    }

    public int[][] getMap_Enemy() {
        return map_enemy.getMap();
    }

    public void setMap_enemy(int[][] map) {
        this.map_enemy.setMap(map);
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
}
