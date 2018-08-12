package ru.stqa.pft.addressbook.modelGroup;

import java.util.Objects;

public class GroupData {

    private int id;
    private final String header;
    private final String footer;
    private final String name;


    public GroupData(int id, String header, String footer, String name) {
        this.id = id;
        this.header = header;
        this.footer = footer;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                '}';
    }

    public GroupData(String header, String footer, String name) {
        this.id = Integer.MAX_VALUE;
        this.header = header;
        this.footer = footer;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public String getName() {
        return name;
    }

}
