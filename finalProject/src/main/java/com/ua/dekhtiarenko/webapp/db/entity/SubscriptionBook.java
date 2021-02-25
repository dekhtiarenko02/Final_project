package com.ua.dekhtiarenko.webapp.db.entity;

import java.util.Date;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class SubscriptionBook {

    private int id;
    private Date dateOfPurchase;
    private int subscription_id;
    private int book_id;

    public SubscriptionBook() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "SubscriptionBook{" +
                "id=" + id +
                ", dateOfPurchase=" + dateOfPurchase +
                ", subscription_id=" + subscription_id +
                ", book_id=" + book_id +
                '}';
    }
}
