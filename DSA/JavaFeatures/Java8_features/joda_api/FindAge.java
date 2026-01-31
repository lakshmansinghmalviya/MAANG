import java.time.*;

public class FindAge {
    public static void main(String[] args) {
        LocalDate date = new LocalDate();
        Period p= date.between("10-06-2003",date);
        System.out.println("The age is "+p.getYears()+"  "+p.getDays()+"  "+p.getMonths()+"  "+p.getChronology());
    }
}