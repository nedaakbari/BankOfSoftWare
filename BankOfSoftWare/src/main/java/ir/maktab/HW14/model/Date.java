package ir.maktab.HW14.model;

public class Date {
    private final int minYear = 1;
    private final int maxYear = 9999;
    private int day = 11;
    private int year = 1400;
    private int month = 1;
    private final String[] months = {"farvardin", "ordibehesht", "khordad", "tir", "mordad", "shahrivar"
            , "mehr", "aban", "azar", "dey", "bahman", "esfand"};

    public Date(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public Date() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public int getMonthLastDay(int month) {
        if (month >= 1 && month <= 6) {
            return 31;
        } else if (month == 12) {
            return 29;
        } else
            return 30;
    }


    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + months[month - 1] +
                ", year=" + year +
                '}';
    }


    public int between(Date date) {//=>borrow date
        if (this.getYear() == date.getYear()) {
            if (this.getMonth() == date.getMonth()) {
                return this.getDay()-date.getDay();
              //  return date.getDay()-this.getDay();
            } else {
                int dayUntilEndMonth = getMonthLastDay(date.getMonth()) - date.getDay();
                int count = dayUntilEndMonth + this.getDay();
                for (int i = 1; i < this.getMonth() - date.getMonth(); i++) {
                    int monthLastDay = getMonthLastDay(i + date.getMonth());
                    count += monthLastDay;
                }
                return count;
            }
        } else {
            int count = (getMonthLastDay(date.getMonth()) - date.getDay()) + this.getDay();
            for (int i = date.getMonth() + 1; i <= 12; i++) {
                count += getMonthLastDay(i);
            }
            for (int j = 1; j < this.getMonth(); j++) {
                count += getMonthLastDay(j);
            }
            return count;
        }
    }


    public boolean isValidDate(int year, int month, int day) {
        if (year < minYear || year > maxYear) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int totalDay = getMonthLastDay(month);
        if (day < 1 || day > totalDay) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //1389,5,31,5","1389,6,2,7","1389,7,3,39","1390,2,2,248
       // Date deliveryDate = new Date( 1382,6,31);// same month 6
        Date deliveryDate = new Date(1382, 7, 2);//nextMonth 8
       // Date deliveryDate = new Date(1382, 12, 29);//several month later in esfan Month 185
       // Date deliveryDate = new Date(1383, 2, 1);//nextyear 217
        System.out.println(deliveryDate.between(new Date(1382, 6, 25)));
    }
}
