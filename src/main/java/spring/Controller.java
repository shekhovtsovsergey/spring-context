package spring;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Controller {

    private final ProductRepository productRepository;
    private Cart cart;

    public void addProductToCartById(Integer id) {
        productRepository.findById(id).ifPresent(cart::add);
    }

    public void deleteProductFromCartById(Integer id) {
        cart.deleteByProductId(id);
    }

    public void showProductInCart() {
        cart.showList();
    }

    public void enterToShop() {
        this.cart = getCart();
    }

    @Lookup
    public Cart getCart() {
        return null;
    }

}
