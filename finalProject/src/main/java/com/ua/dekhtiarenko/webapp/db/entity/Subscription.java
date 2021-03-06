package com.ua.dekhtiarenko.webapp.db.entity;

/**
 * Subscription entity.
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class Subscription {

    private int id;
    private int penalty;
    private int user_id;

    public Subscription() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", penalty=" + penalty +
                ", user_id=" + user_id +
                '}';
    }
}
