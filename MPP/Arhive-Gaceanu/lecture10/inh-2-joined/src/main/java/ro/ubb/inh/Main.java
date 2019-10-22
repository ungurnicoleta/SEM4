package ro.ubb.inh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.inh.model.Battery;
import ro.ubb.inh.model.Product;
import ro.ubb.inh.repository.ProductRepository;

/**
 * Created by radu.
 */


public class Main {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(
                  "ro.ubb.inh.config"
                );

        ProductRepository productRepository=
                context.getBean(ProductRepository.class);

        Product product=new Product("p1",100);
        productRepository.save(product);

        Battery battery=new Battery("b1",200,true);
        productRepository.save(battery);


        productRepository.findAll()
                         .forEach(System.out::println);


        System.out.println("hello");
    }

}
