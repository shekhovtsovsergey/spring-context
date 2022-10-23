package spring;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Controller implements Repository {

    private final Repository repository;
    private Cart cart;

    public void addProductToCartById(Integer id) {
        repository.findById(id).ifPresent(cart::add);
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

    @Override
    public void init() {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.empty();
    }
}
