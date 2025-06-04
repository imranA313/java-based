package Creational.factory_method;

public class SamsungProduct implements SamsungFactory{
    @Override
    public Object getProduct(String productName) {

        if(productName.equalsIgnoreCase("Laptop")){
            return new Laptop("Samsung ".concat(productName));
        } else if (productName.equalsIgnoreCase("mobile")) {
            return new Mobile("Samsung ".concat(productName));
        }
        return "This product not available";
    }
}
