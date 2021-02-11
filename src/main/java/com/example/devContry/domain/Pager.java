package com.example.devContry.domain;

import java.util.Optional;

public class Pager {
    Project prev;
    Project next;

    public Project getPrev() {
        return prev;
    }

    public void setPrev(Project prev) {
        this.prev = prev;
    }

    public Project getNext() {
        return next;
    }

    public void setNext(Project next) {
        this.next = next;
    }
}
