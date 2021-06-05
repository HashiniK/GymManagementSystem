package sample;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (!dateValid(day, month, year)) {
            this.year = year;
            this.day = day;
            this.month = month;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth () {
        return month;
    }

    public int getYear() {
        return year;
    }

    public static boolean dateValid(int year, int month, int day) {
        //validation for year
        if (year < 0) return false;
        //validation for month
        if ((month < 1) || (month > 12)) return false;
        //validation for days
        if ((day < 1) || (day > 31)) return false;
        //checking months and days
        if (month==1) {
            return true;
        }else if (month==3) {
            return true;
        }else if (month==4) {
            return day < 31;
        }else if (month==5) {
            return true;
        }else if (month==6) {
            return day < 31;
        }else if (month==7) {
            return true;
        }else if (month==8) {
            return true;
        }else if (month==9) {
            return day < 31;
        }else if (month==10) {
            return true;
        }else if (month==11) {
            return day < 31;
        }else
          return true;
        }

    public void setYear(int year, int month, int day){
        try {
            if (year%400==0){
                if (month==2 && day == 29){
                    this.year = year;
                    this.day = day;
                    this.month = month;
                } else {
                    System.out.println("Incorrect number of days");
                }
            }
        } catch (NumberFormatException numberFormatException){
            System.out.println("Please enter only a numerical value!");
        }
    }
}



