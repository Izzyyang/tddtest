import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/7/3.
 */
public enum Product {
    Coocla("ITEM000000", "可口可乐", "瓶", "食品", "碳酸饮料", new BigDecimal("3")),
    Badminton("ITEM000003", "羽毛球", "个", "器材", "体育", new BigDecimal("1")),
    Apple("ITEM000005", "苹果", "个", "食品", "水果", new BigDecimal("5.5"));

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String suCategory;
    private BigDecimal price;

    Product(String barcode, String name, String unit, String category, String suCategory, BigDecimal price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.category = category;
        this.suCategory = suCategory;
        this.price = price;
    }
    public String getName(){
        return  name;
    }
    public BigDecimal getPrice() {
        return price;
    }


    public String getBarCode() {
        return barcode;
    }
}
