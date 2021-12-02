package ir.maktab.HW14.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private List<Date> dates = new ArrayList<>();
    private List<Disc> discBorrow = new ArrayList<>();
    private int lateDays = 0;



    public void borrow(Disc disc, Date date) {
        discBorrow.add(disc);
        dates.add(date);
    }

    public void deliver(Disc disc, Date date) {
        discBorrow.remove(disc);
        dates.add(date);
    }

//region setter & getter
    public int getLateDays() {
        return lateDays;
    }
    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Date> getDates() {
        return dates;
    }
    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
    public List<Disc> getDiscBorrow() {
        return discBorrow;
    }
    public void setDiscBorrow(List<Disc> discBorrow) {
        this.discBorrow = discBorrow;
    }
//end region setter & getter
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{" + name + ", " + discBorrow +
                ", lateDays:" + lateDays + '}';
    }
}
