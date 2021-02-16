package com.presentation.scheduler.model;

public class Event {
    private String title;
    private String type;
    private int breaks;
    private int ammout;
    private String currency;

    public Event withTitle(String title) {
        this.title = title;
        return this;
    }

    public Event withType(String type) {
        this.type = type;
        return this;
    }

    public Event withBreaks(int breaks) {
        this.breaks = breaks;
        return this;
    }

    public Event withAmmout(int ammout) {
        this.ammout = ammout;
        return this;
    }

    public Event withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getBreaks() {
        return breaks;
    }

    public int getAmmout() {
        return ammout;
    }


}
