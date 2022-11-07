package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

    // 1.tüm keyler için private variableler oluşturuyoruz
    private String checkin;
    private String checkout;

    //2. tüm parametrelerle ve parametresiz constrocturlar oluşturuyoruz
    public BookingDatesPojo(String checkin, String checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }
    public BookingDatesPojo(){

    }

    //3. public getter ve setter methodlarını olusturuyoruz
    public String getCheckin(){
        return checkin;
    }
    public void setCheckin(String checkin){
        this.checkin=checkin;
    }
    public String getCheckout(){
        return checkout;
    }
    public void setCheckout(String checkout){
        this.checkout=checkout;
    }

    //4.toString() methodu olusturuyoruz

    @Override
    public String toString(){
        return "BookingDatesPojo{" +
            "checkin='"  + checkin + '\'' +
            ", checkout='" + checkout + '\'' +
        '}';
    }

}
