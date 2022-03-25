package assignments.assignment2;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

// TODO
public class BookLoan{
    private static long DENDA_PER_HARI = 3000;
    private Member member;
    private Book book;
    private String loanDate;
    private String returnDate;
    private long fine;
    private boolean status;

    public BookLoan( Book book, String loanDate){
        this.loanDate = loanDate;
        this.book = book;
        
    }

    
    public Book getBook(){
        return this.book;
    }

    public Member getMember(){
        return this.member;
    }
    
    public long selisihHari(){
        SimpleDateFormat sdf = new SimpleDateFormat(
        "dd/MM/yyyy");
        try {
        Date d1 = sdf.parse(this.loanDate);
        Date d2 = sdf.parse(this.returnDate);

        long difference_In_Time = d2.getTime() - d1.getTime();

        long difference_In_Days = (difference_In_Time
            / (1000 * 60 * 60 * 24));
            
        return difference_In_Days;  
        }

        catch (ParseException e) {
        e.printStackTrace();
        }

        return 0;   
    }

    public long getFine(){
        return member.getFine();
    }

    public void  setfine(long hari){
        this.fine = member.setfine(DENDA_PER_HARI * (hari - 7));
        
    }

    public boolean getStatus(){
        return this.status;
    }

    public boolean setStatus(){
        return (member.getFine() >= 5000);
        
    }

}
