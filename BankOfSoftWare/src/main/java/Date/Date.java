package Date;

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


    private Date nextDay(Date date) {
        Date date1 = new Date(date.getYear(), date.getMonth(), date.getDay() + 1);
        if (date.getDay() == 31) {
            date.setYear(date1.getYear());
            date.setMonth(date1.getMonth() + 1);
            date.setDay(1);
        } else if (date.getDay() == 30) {
            if (date.getMonth() >= 7 || date.getMonth() <= 11) {
                date.setYear(date1.getYear());
                date.setMonth(date1.getMonth() + 1);
                date.setDay(1);

            } else if (date.getMonth() == 12) {
                date.setYear(date1.getYear() + 1);
                date.setMonth(1);
                date.setDay(1);
            }

        } else {
            date.setYear(date1.getYear());
            date.setMonth(date1.getMonth());
            date.setDay(date1.getDay() + 1);
        }
        return date;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + months[month - 1] +
                ", year=" + year +
                '}';
    }


    public int between(Date date1, Date date2) {
        if (date1.getYear() == date2.getYear()) {
            if (date1.getMonth() == date2.getMonth()) {
                return date2.getDay() - date1.getDay() + 1;
            } else {
                int dayUntilEndMonth = getMonthLastDay(date1.getMonth()) - date1.getDay();
                int count = dayUntilEndMonth + date2.getDay();
                for (int i = 1; i < date2.getMonth() - date1.getMonth(); i++) {
                    int monthLastDay = getMonthLastDay(i + date1.getMonth());
                    count += monthLastDay;
                }
                return count;
            }
        } else {
            int count = (getMonthLastDay(date1.getMonth()) - date1.getDay()) + date2.getDay();
            for (int i = date1.getMonth() + 1; i <= 12; i++) {
                count += getMonthLastDay(i);
            }
            for (int j = 1; j < date2.getMonth(); j++) {
                count += getMonthLastDay(j);
            }
            return count;
        }

    }

    public int betweens(Date date) {
        if (this.getYear() == date.getYear()) {
            if (this.getMonth() == date.getMonth()) {
                return date.getDay() - this.getDay() ;
            } else {
                int dayUntilEndMonth = getMonthLastDay(this.getMonth()) - this.getDay();
                int count = dayUntilEndMonth + date.getDay();
                for (int i = 1; i < date.getMonth() - this.getMonth(); i++) {
                    int monthLastDay = getMonthLastDay(i + this.getMonth());
                    count += monthLastDay;
                }
                return count;
            }
        } else {
            int count = (getMonthLastDay(this.getMonth()) - this.getDay()) + date.getDay();
            for (int i = this.getMonth() + 1; i <= 12; i++) {
                count += getMonthLastDay(i);
            }
            for (int j = 1; j < date.getMonth(); j++) {
                count += getMonthLastDay(j);
            }
            return count;
        }
    }

    public int betweenss(Date date) {//=>borrow date
        if (this.getYear() == date.getYear()) {
            if (this.getMonth() == date.getMonth()) {
                return this.getDay()-date.getDay()-1;
            } else {
                int dayUntilEndMonth = getMonthLastDay(date.getMonth()) - date.getDay();
                int count = dayUntilEndMonth + this.getDay();
                for (int i = 1; i < this.getMonth() - date.getMonth(); i++) {
                    int monthLastDay = getMonthLastDay(i + date.getMonth());
                    count += monthLastDay;
                }
                return count-1;
            }
        } else {
            int count = (getMonthLastDay(date.getMonth()) - date.getDay()) + this.getDay();
            for (int i = date.getMonth() + 1; i <= 12; i++) {
                count += getMonthLastDay(i);
            }
            for (int j = 1; j < this.getMonth(); j++) {
                count += getMonthLastDay(j);
            }
            return count-1;
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
}
