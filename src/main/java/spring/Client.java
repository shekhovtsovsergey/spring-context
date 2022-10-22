package spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Client {

    private final spring.Controller Controller;

    private Integer productsNumber;

    Random random = new Random();

    @PostConstruct
    public void init() {
        productsNumber = random.nextInt(9) + 2;
        Controller.enterToShop();
    }

    public void purchase() {
        System.out.println("Buyer wants to buy " + productsNumber + " products");
        int i = 0;
        while (i < productsNumber) {
            Controller.addProductToCartById(random.nextInt(5));
            i++;
        }
        int getOutProductId = random.nextInt(5);
        System.out.println("Buyer wants to get out product with id: " + getOutProductId);
        Controller.deleteProductFromCartById(getOutProductId);
    }

    public void showCart() {
        System.out.println("Buyer bought: ");
        Controller.showProductInCart();
        System.out.println("------------------------------------------------------------------------------------");
    }

}
