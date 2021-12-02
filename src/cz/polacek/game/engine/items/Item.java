package cz.polacek.game.engine.items;

public class Item {

    public enum ItemState {
        HOLDING,
        SOME,
        BROKEN,
        EMPTY
    }

    public String name;
    public ItemState state;
    public int holding;
    public int max_holding;

    public Item(String name, ItemState state, int holding, int max_holding) {
        this.name = name;
        this.state = state;
        this.holding = holding;
        this.max_holding = max_holding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemState getState() {
        return state;
    }

    public void setState(ItemState state) {
        this.state = state;
    }

    public int getMax_holding() {
        return max_holding;
    }

    public void setMax_holding(int max_holding) {
        this.max_holding = max_holding;
    }

    public Item(String name) {
        this.name = name;
    }
}
