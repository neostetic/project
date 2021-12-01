package cz.polacek.game.engine.items;

import cz.polacek.game.config.Config;

public enum EnumItems {

    WEAPON(new Item("WEAPON", Item.ItemState.EMPTY, 0, 1)),
    MAP(new Item("MAP", Item.ItemState.EMPTY, 0, 1)),
    BUGSPRAY(new Item("BUGSPRAY", Item.ItemState.EMPTY, 0, 1)),
    TOOLKIT(new Item("TOOL KIT", Item.ItemState.EMPTY, 0, 1)),
    MEDKIT(new Item("MED KIT", Item.ItemState.EMPTY, 0, 1)),
    WATER(new Item("WATER SUPLY", Item.ItemState.EMPTY, 0, new Config().player_max_water)),
    FOOD(new Item("FOOD SUPLY", Item.ItemState.EMPTY, 0, new Config().player_max_food));

    private Item item;

    EnumItems(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
