package ru.geekbrains.alekseiterentev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.alekseiterentev.beans.Cart;
import ru.geekbrains.alekseiterentev.beans.services.ClientService;
import ru.geekbrains.alekseiterentev.beans.services.ProductService;
import ru.geekbrains.alekseiterentev.beans.services.ShoppingReportService;
import ru.geekbrains.alekseiterentev.model.Client;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Cart cart1 = context.getBean(Cart.class);
//        Cart cart2 = context.getBean(Cart.class);
//
//        cart1.addProduct(1L);
//        cart1.addProduct(2L);
//        cart1.addProduct(3L);
//
//        cart2.addProduct(3L);
//        cart2.addProduct(4L);
//        cart2.addProduct(5L);
//
//        System.out.println(cart1);
//        System.out.println();
//        System.out.println(cart2);
//
//        cart2.removeProduct(3L);
//
//        System.out.println();
//        System.out.println(cart1);
//        System.out.println();
//        System.out.println(cart2);
        ShoppingReportService shoppingReportService = context.getBean(ShoppingReportService.class);

        ProductService productService = context.getBean(ProductService.class);
        Product product = productService.findById(8L);
        System.out.println(product);

        System.out.println(
                Arrays.toString(
                        shoppingReportService.findClientsByOrderedProductId(product.getId()).toArray()
                )
        );

        System.out.println();

        ClientService clientService = context.getBean(ClientService.class);
        Client client = clientService.findById(3L);
        System.out.println(client);

        System.out.println(
                Arrays.toString(
                        shoppingReportService.findProductsOrderedByClientId(client.getId()).toArray()
                )
        );

        context.close();
    }
}
