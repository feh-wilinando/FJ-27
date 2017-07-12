package br.com.caelum.fj27.loja.repositories;

import br.com.caelum.fj27.loja.models.BookType;
import br.com.caelum.fj27.loja.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by nando on 02/07/17.
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

    @Query("select sum(price.value) from Product p join p.prices price where price.bookType = :bookType")
    BigDecimal sumPricePerType(@Param("bookType") BookType bookType);
}
