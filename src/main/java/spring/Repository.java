package spring;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface Repository {

    void init();
    List<Product> findAll();
    Optional<Product> findById(Integer id);


}
