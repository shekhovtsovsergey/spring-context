package spring;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Data
public class ProductRepository implements Repository{

    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    @Override
    public void init() {
        products.add(new Product(1, "Apple1", 100d));
        products.add(new Product(2, "Apple2", 200d));
        products.add(new Product(3, "Apple3", 300d));
        products.add(new Product(4, "Apple4", 400d));
        products.add(new Product(5, "Apple5", 500d));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
        //тут вопрос как лучше сделать как выше или как ниже?
        //return products;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        if (id < (products.size()) && id >= 0) {
            return Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }


}


