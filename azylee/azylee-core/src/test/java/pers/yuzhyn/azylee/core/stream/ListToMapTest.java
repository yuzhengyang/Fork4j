package pers.yuzhyn.azylee.core.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapTest {

    public static void main(String[] args) {

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("1010112233", new BigDecimal(15.5)));
        orderList.add(new Order("1010112233", new BigDecimal(15.5)));
        orderList.add(new Order("1010112233", new BigDecimal(15.5)));

        Map<String, BigDecimal> priceMap = new HashMap<>();
        if (null != orderList && orderList.size() > 0) {
            priceMap = orderList.stream().collect(Collectors.toMap(k -> k.getPluCode(), v -> v.getPrice()));
        }
    }
}

class Order {
    private String pluCode;
    private BigDecimal price;

    public Order(String pluCode, BigDecimal price) {
        this.pluCode = pluCode;
        this.price = price;
    }

    public String getPluCode() {
        return pluCode;
    }

    public void setPluCode(String pluCode) {
        this.pluCode = pluCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
