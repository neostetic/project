package cz.polacek.game.engine.events;

import cz.polacek.game.engine.items.Items;

public class Event {

    String eventTextInfo;
    String eventDecline;
    String eventAcceptPositive;
    String eventAcceptNegative;
    Items item1;

    public Event(String eventTextInfo, String eventDecline, String eventAcceptPositive, String eventAcceptNegative, Items item1) {
        this.eventTextInfo = eventTextInfo;
        this.eventDecline = eventDecline;
        this.eventAcceptPositive = eventAcceptPositive;
        this.eventAcceptNegative = eventAcceptNegative;
        this.item1 = item1;
    }

    public Event(String eventTextInfo, String eventDecline, String eventAcceptPositive, String eventAcceptNegative) {
        this.eventTextInfo = eventTextInfo;
        this.eventDecline = eventDecline;
        this.eventAcceptPositive = eventAcceptPositive;
        this.eventAcceptNegative = eventAcceptNegative;
    }

    public String getEventTextInfo() {
        return eventTextInfo;
    }

    public void setEventTextInfo(String eventTextInfo) {
        this.eventTextInfo = eventTextInfo;
    }

    public String getEventDecline() {
        return eventDecline;
    }

    public void setEventDecline(String eventDecline) {
        this.eventDecline = eventDecline;
    }

    public String getEventAcceptPositive() {
        return eventAcceptPositive;
    }

    public void setEventAcceptPositive(String eventAcceptPositive) {
        this.eventAcceptPositive = eventAcceptPositive;
    }

    public String getEventAcceptNegative() {
        return eventAcceptNegative;
    }

    public void setEventAcceptNegative(String eventAcceptNegative) {
        this.eventAcceptNegative = eventAcceptNegative;
    }

    public Items getItem1() {
        return item1;
    }

    public void setItem1(Items item1) {
        this.item1 = item1;
    }
}
