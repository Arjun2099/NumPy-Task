import java.util.Calendar;

class calendar{

    static String date(){
    String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}; // created an array for months
    Calendar calendar = Calendar.getInstance(); 

    return ("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " \t\t\t\t\t\t\t\t\t\t\t\t  Year:" + calendar.get(Calendar.YEAR));
   }
}