package ir.maktab.HW14.model;

import ir.maktab.HW14.model.Date;
import ir.maktab.HW14.model.Person;

import java.util.List;

public class BorrowOperation {
    private String discName;
    private Date date;
    private List<Date> dates;
    private Person person;
    private String status;

    public BorrowOperation(String discName, Date date) {
        this.discName = discName;
        this.date = date;
    }

    public boolean isLate(Date deliveryDate) {
        int days = deliveryDate.between(date);
        if (days > 7) {
            int lateDays = days - 7;
            person.setLateDays(person.getLateDays() + lateDays);
            return true;
        } else
            return false;
    }

    //setter & getter
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Date> getDates() {
        return dates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public String getDiscName() {
        return discName;
    }

    public void setDiscName(String discName) {
        this.discName = discName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    //end region setter & getter

    @Override
    public String toString() {
        return "BorrowOperation{" +
                "discName='" + discName + '\'' +
                ", date=" + date +
                ", person=" + person + ", " + status +
                '}';
    }
}
