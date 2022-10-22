package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        for (int i = 0; i < 5; i++) {
            Client client = context.getBean(Client.class);
            client.purchase();
            client.showCart();
        }
    }


}
