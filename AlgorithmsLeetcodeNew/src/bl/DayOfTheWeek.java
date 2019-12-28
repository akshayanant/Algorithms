package bl;

/**
 * Created by Akshay Hegde on 9/7/2019.
 *
 * 5183. Day of the Week
 User Accepted:65
 User Tried:104
 Total Accepted:65
 Total Submissions:106
 Difficulty:Easy
 Given a date, return the corresponding day of the week for that date.

 The input is given as three integers representing the day, month and year respectively.

 Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.



 Example 1:

 Input: day = 31, month = 8, year = 2019
 Output: "Saturday"
 Example 2:

 Input: day = 18, month = 7, year = 1999
 Output: "Sunday"
 Example 3:

 Input: day = 15, month = 8, year = 1993
 Output: "Sunday"


 Constraints:

 The given dates are valid dates between the years 1971 and 2100.

 */
public class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        int yearGap = year-1968;
        int leapCount = yearGap/4;
        int days = yearGap*365+(year%4!=0?leapCount:leapCount-1);
        for (int i = 1; i < month; i++) {
            if(i==4||i==6||i==9||i==11){
                days+=30;
            }
            else if(i==2){
                if(year%4==0){
                    days+=29;
                }
                else{
                    days+=28;
                }
            }
            else{
                days+=31;
            }
        }
        days+=day;
        int week = days%7;
        switch (week){
            case 0:return "Monday";
            case 1:return "Tuesday";
            case 2:return "Wednesday";
            case 3:return "Thursday";
            case 4:return "Friday";
            case 5: return "Saturday";
            default:return "Sunday";
        }
    }

    public static void main(String[] args) {
        System.out.println(new DayOfTheWeek().dayOfTheWeek(1,3,2020));
    }
}
