package de.jpah2.entities;


import jakarta.persistence.*;

@Entity
public class Userx {
    @Id
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wetter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
