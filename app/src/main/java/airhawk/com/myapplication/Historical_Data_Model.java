package airhawk.com.myapplication;

public class Historical_Data_Model {

    String name;
    String cap;
    String volume;
    String date;

    public Historical_Data_Model(String name, String volume, String date ) {
        this.name=name;
        this.volume=volume;
        this.date=date;

    }

    public String getName() {
        return name;
    }
    
    public String getMarketCap() {
        return cap;
    }
    
    public String getVolume() {
        return volume;
    }
    
    public String getDate() {
        return date;
    }
    
}