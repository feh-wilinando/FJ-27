package br.com.caelum.fj27.loja.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by nando on 02/07/17.
 */

@Embeddable
public class Price {

    @Column(scale = 2)
    @DecimalMin("10")
    @NotNull
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
