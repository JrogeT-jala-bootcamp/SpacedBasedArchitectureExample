package com.rubenjg.pu.counter.entity;

import javax.persistence.*;

/**
 * Counter object
 *
 * @author Rubén Jiménez
 */
@Entity
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long count;

    public Counter() {
    }

    public Counter(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
