import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

/**
 * Created by izzy on 16-7-7.
 */
public class Test {

    private final int COCOLA_NUM = 3;
    private final BigDecimal COCOLA_PRICE = new BigDecimal(3);

    private final int BADMINTON_NUM = 5;
    private final BigDecimal BADMINTON_PRICE = new BigDecimal(1);

    private final int APPLE_NUM = 2;
    private final BigDecimal APPLE_PRICE = new BigDecimal(5.5);

    private final String FIVE_PERCENT_DISCOUNT = "FIVE_PERCENT_DISCOUNT";
    private final String  TEN_PERCENT_DICOUNT= "TEN_PERCENT_DISCOUNT";
    private final String  NO_DISCOUNT = "NO_DISCOUNT";
    @org.junit.Test
    public void should_return_totallfee_cocola() throws Exception {
        assertTrue(Discount.getDiscountFee(Product.Coocla,COCOLA_NUM,NO_DISCOUNT).equals(new BigDecimal(9)));
    }
    @org.junit.Test
    public void should_return_discountfee_cocola() throws Exception {
        BigDecimal b = Discount.getDiscountFee(Product.Coocla,COCOLA_NUM,FIVE_PERCENT_DISCOUNT);
        double f =  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        assertTrue(new BigDecimal(f).compareTo(new BigDecimal(8.55)) == 0);
    }

    //羽毛球
    @org.junit.Test
    public void should_return_totallfee_badminton() throws Exception {
        assertTrue(Discount.getDiscountFee(Product.Badminton,BADMINTON_NUM,NO_DISCOUNT).equals(new BigDecimal(5)));
    }
    @org.junit.Test
    public void should_return_discountfee_badminton() throws Exception {
        BigDecimal b = Discount.getDiscountFee(Product.Badminton,BADMINTON_NUM,NO_DISCOUNT);
        double f =  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        assertTrue(new BigDecimal(f).compareTo(new BigDecimal(5)) == 0);
    }
    //苹果
    @org.junit.Test
    public void should_return_totallfee_apple() throws Exception {
        BigDecimal b = Discount.getDiscountFee(Product.Apple,APPLE_NUM,NO_DISCOUNT);
        double f =  b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        assertTrue(new BigDecimal(f).compareTo(new BigDecimal(11)) == 0);
    }
    @org.junit.Test
    public void should_return_discountfee_apple() throws Exception {
        BigDecimal b = Discount.getDiscountFee(Product.Apple,APPLE_NUM,NO_DISCOUNT);
        double f =  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        assertTrue(new BigDecimal(f).compareTo(new BigDecimal(11)) == 0);
    }
}
