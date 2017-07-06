package br.com.caelum.fj27.loja.repositories;

import br.com.caelum.fj27.loja.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nando on 02/07/17.
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

    @Query("select distinct(p) from Product p join fetch p.prices")
    List<Product> list();
}
