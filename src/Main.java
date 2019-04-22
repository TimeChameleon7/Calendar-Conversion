import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a Gregorian Date to be converted to an International Fixed Calendar date." +
                "(d/m/y)");
        Scanner in = new Scanner(System.in);
        String date;
        int fails=0;
        do{
            if(fails>0){
                System.out.println("Invalid date, either the format is wrong (should be day/month/year) or your date is" +
                        "non existent");
            }
            date = in.nextLine();
            fails++;
        }while(!isValidDate(date));
    }

    /**
     * Returns true if the year is a leap year according to Gregorian Calendar leap year rules.
     * @param year input year
     * @return boolean
     */
    private static boolean isLeapYear(int year){
        return year%4==0&&(year%100!=0||year%400==0);
    }

    /**
     * Returns the number of days in the Gregorian Month, or 0 if not 1-12 inclusive.
     * @param month input month, must be 1-12 inclusive
     * @param year input year, changes the number of days in February
     * @return int value of days in the month
     */
    private static int daysinMonth(int month,int year){
        if(month==2){
            if(isLeapYear(year)){
                return 29;
            }else{
                return 28;
            }
        }else if(month==4||month==6||month==9||month==11){
            return 30;
        }else if(month>=1&&month<=12){
            return 31;
        }else{
            return 0;
        }
    }

    /**
     * Returns true if the date received is valid and properly formatted.
     * @param str date input in the format d/m/y
     * @return boolean
     */
    private static boolean isValidDate(String str){
        try {
            int day = Integer.parseInt(str.split("/")[0]);
            int month = Integer.parseInt(str.split("/")[1]);
            int year = Integer.parseInt(str.split("/")[2]);
            return str.split("/").length == 3
                    && day >= 1
                    && day <= daysinMonth(month, year)
                    && month >= 1
                    && month <= 12
                    && year >= 1;
        }catch (Exception e){
            return false;
        }
    }
}