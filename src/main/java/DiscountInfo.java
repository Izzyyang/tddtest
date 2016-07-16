import java.util.List;

/**
 * Created by izzy on 16-7-15.
 */
public class DiscountInfo {
    String type;
    List<String> barcodes;
    public String getType(){
        return type;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public String toString(){
        return type+"   " +barcodes;
    }
}
