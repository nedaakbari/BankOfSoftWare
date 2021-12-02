package ir.maktab.HW14.model;

public class Disc {
    private String name;
    private int count;


    public Disc(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return  name +" "+ count;
    }

}
