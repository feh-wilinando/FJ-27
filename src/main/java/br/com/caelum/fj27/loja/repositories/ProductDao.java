package br.com.caelum.fj27.loja.repositories;

import br.com.caelum.fj27.loja.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by nando on 02/07/17.
 */
@Repository
public class ProductDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Product product) {
        manager.persist(product);
    }
}
