package Creational.factory_method;

public class RunnerClass {

    public static void main(String[] args) {

        SamsungFactory product = new SamsungProduct();
        product.getProduct("Mobile");
        product.getProduct("Laptop");
    }
}
