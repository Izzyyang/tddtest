import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by izzy on 16-7-10.
 */
public class Discount {
    public static Map<String, Float> discountTypeMap= new HashMap<String, Float>();
    static{
        discountTypeMap.put("FIVE_PERCENT_DISCOUNT", 0.95f);
        discountTypeMap.put("TEN_PERCENT_DISCOUNT", 0.90f);
        discountTypeMap.put("NO_DISCOUNT", 1.00f);
    }

    public static Map<String ,String> productType = new HashMap<String, String>();
    static {
        productType.put("FIVE_PERCENT_DISCOUNT","九五折");
        productType.put("TEN_PERCENT_DISCOUNT","九折");
    }

    public static BigDecimal getDiscountFee(Product product, int num, String discountType) {
        return product.getPrice().multiply(new BigDecimal(num)).multiply(new BigDecimal(discountTypeMap.get(discountType)));
    }

    public static Map<String,List> getDiscountInfo(){
        String discontStr = "[{type: 'FIVE_PERCENT_DISCOUNT', barcodes: ['ITEM000000']}, {type: 'TEN_PERCENT_DISCOUNT', barcodes: ['ITEM000003']} ]";
        JSONArray objs = JSON.parseArray(discontStr);
        Map<String,List> discountMap = new HashMap<String, List>();
        for(Object obj:objs){
            JSONObject object = JSON.parseObject(obj.toString());
            discountMap.put(object.get("type").toString(),(List) object.get("barcodes"));
        }

        return discountMap;
    }

    public static String getDiscountType(String barcode){
        for(Map.Entry<String,List> entry:getDiscountInfo().entrySet()){
            if(entry.getValue().contains(barcode)){
                return entry.getKey();
            }
        }
        return null;
    }
}
