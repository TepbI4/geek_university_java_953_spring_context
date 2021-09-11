package ru.geekbrains.alekseiterentev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.alekseiterentev.beans.Cart;
import ru.geekbrains.alekseiterentev.beans.repositories.ProductRepository;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart1 = context.getBean(Cart.class);
        Cart cart2 = context.getBean(Cart.class);

        cart1.addProduct(1L);
        cart1.addProduct(2L);
        cart1.addProduct(3L);

        cart2.addProduct(3L);
        cart2.addProduct(4L);
        cart2.addProduct(5L);

        System.out.println(cart1);
        System.out.println();
        System.out.println(cart2);

        cart2.removeProduct(3L);

        System.out.println();
        System.out.println(cart1);
        System.out.println();
        System.out.println(cart2);

        context.close();
    }
}
