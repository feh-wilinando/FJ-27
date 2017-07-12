package br.com.caelum.fj27.loja.builder;

import br.com.caelum.fj27.loja.models.BookType;
import br.com.caelum.fj27.loja.models.Price;
import br.com.caelum.fj27.loja.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by nando on 12/07/17.
 */
public class ProductBuilder {

    private List<Product> products = new ArrayList<>();


    private ProductBuilder(Product product){
        products.add(product);
    }

    public static ProductBuilder newProduct(){
        Product book = create("BOOK 1", BookType.COMBO, BigDecimal.TEN);

        return new ProductBuilder(book);
    }
    public static ProductBuilder newProduct(BookType bookType, BigDecimal value) {
        Product book = create("Book 1",bookType, value);
        return new ProductBuilder(book);
    }
    private static Product create(String title, BookType type, BigDecimal value) {

            Product book = new Product();
            book.setTitle(title);
            book.setReleaseDate(Calendar.getInstance());
            book.setNumberOfPages(150);
            book.setDescription("great book about testing");
            Price price = new Price();
            price.setBookType(type);
            price.setValue(value);
            book.getPrices().add(price);
            return book;
    }

    public ProductBuilder more(int number){
        Product base = products.get(0);
        Price price = base.getPrices().get(0);

        for (int i = 0; i < number; i++) {
            products.add(create("Book "+i, price.getBookType(), price.getValue()));
        }

        return this;
    }

    public Product buildOne(){
        return products.get(0);
    }

    public List<Product> buildAll(){
        return products;
    }


}
