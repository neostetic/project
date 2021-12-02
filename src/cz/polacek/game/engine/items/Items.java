package cz.polacek.game.engine.items;

import cz.polacek.game.config.Config;

public enum Items {

    SHOTGUN(new Item("SHOTGUN", Item.ItemState.EMPTY, 0, 1)),
    MAP(new Item("MAP", Item.ItemState.EMPTY, 0, 1)),
    TAPE(new Item("TAPE", Item.ItemState.EMPTY, 0, 1)),
    TOOLKIT(new Item("TOOL KIT", Item.ItemState.EMPTY, 0, 1)), // create asset
    MEDKIT(new Item("MED KIT", Item.ItemState.EMPTY, 0, 1)),
    WATER(new Item("WATER SUPPLY", Item.ItemState.EMPTY, 0, new Config().player_max_water)),
    FOOD(new Item("FOOD SUPPLY", Item.ItemState.EMPTY, 0, new Config().player_max_food));

    private Item item;

    Items(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
