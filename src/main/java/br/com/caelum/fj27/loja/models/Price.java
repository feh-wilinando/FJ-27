package br.com.caelum.fj27.loja.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * Created by nando on 02/07/17.
 */

@Embeddable
public class Price {

    @Column(precision = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
