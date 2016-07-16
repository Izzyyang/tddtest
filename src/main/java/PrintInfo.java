import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by izzy on 16-7-10.
 */
public class PrintInfo {
    public static BigDecimal totalm = new BigDecimal("0");
    public static BigDecimal reducem = new BigDecimal("0");

    public static Map<String,Product> productMap = new HashMap<String, Product>();
    static{
        productMap.put("ITEM000000",Product.Coocla);
        productMap.put("ITEM000003",Product.Badminton);
        productMap.put("ITEM000005",Product.Apple);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args){
        Map<Product,Integer> cart = getProductNum();
        for(Map.Entry<Product,Integer> entry:cart.entrySet()){
            printProductInfo(entry.getValue(),entry.getKey());
        }
        System.out.println("*********************************************");
        System.out.println("单品打折商品：");
        for(Map.Entry entry:cart.entrySet()){
            Product p = (Product) entry.getKey();
            if(null != Discount.getDiscountType(p.getBarCode())){
                System.out.println("名称："+p.getName()+",折扣："+ Discount.productType.get(Discount.getDiscountType(p.getBarCode())));
            }
        }
        System.out.println("*********************************************");
        double totald = totalm.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        double reducd = reducem.setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
        System.out.println("总计："+totald+"（元）");
        System.out.println("节省："+reducd+"（元）");
    }

    public static void printProductInfo(int num,Product product){
        String str = new StringBuilder("名称："+product.getName()).
                append("，数量："+num+"个").
                append("，单价："+product.getPrice()+"（元）").
                toString();
        BigDecimal discountMoney = null != Discount.getDiscountType(product.getBarCode()) ? Discount.getDiscountFee(product,num,Discount.getDiscountType(product.getBarCode())) : new BigDecimal("0");
        BigDecimal totalMoney = product.getPrice().multiply(new BigDecimal(num));
        BigDecimal reduceMoney = null != Discount.getDiscountType(product.getBarCode()) ? totalMoney.subtract(discountMoney) : new BigDecimal("0");
        double reduceMoneyf =  reduceMoney.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        totalm = totalm.add(totalMoney);
        reducem = reducem.add(reduceMoney);
        System.out.println(null == Discount.getDiscountType(product.getBarCode()) ? str+"，小计："+ totalMoney +"（元）": str+"小计："+ Discount.getDiscountFee(product,num,"NO_DISCOUNT")+"（元）"+"，优惠："+reduceMoneyf+"（元）");
    }

    public static Map<Product,Integer> getProductNum(){
        String productCode = "'ITEM000000-3', 'ITEM000003-5', 'ITEM000005-2'";
        Map<Product,Integer> productNumMap = new HashMap<Product,Integer>();
        for(String goodNum:productCode.split(",")){
            goodNum = goodNum.trim();
            String barCode = goodNum != null && goodNum.split("-").length > 1 ? goodNum.split("-")[0].substring(1,goodNum.split("-")[0].length()) : goodNum.substring(1,goodNum.length()-1);
            Integer num = goodNum != null && goodNum.split("-").length > 1 ? Integer.valueOf(goodNum.split("-")[1].substring(0,goodNum.split("-")[1].length()-1))  : 1;
            productNumMap.put(productMap.get(barCode),num);
        }
        return productNumMap;
    }
}
