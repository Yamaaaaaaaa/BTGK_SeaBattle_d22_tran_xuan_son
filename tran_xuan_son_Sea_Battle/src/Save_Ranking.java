import java.io.Serializable;

public class Save_Ranking implements Serializable {
    private String nameRanking;
    private int turnRanking;

    public Save_Ranking(String name,int turn) {
        this.nameRanking = name;
        this.turnRanking = turn;
    }

    public String getName() {
        return nameRanking;
    }

    public void setName(String name) {
        this.nameRanking = name;
    }

    public int getTurn() {
        return turnRanking;
    }

    public void setTurn(int turn) {
        this.turnRanking = turn;
    }
}
