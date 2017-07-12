package br.com.caelum.fj27.loja.dao;

import br.com.caelum.fj27.loja.builder.ProductBuilder;
import br.com.caelum.fj27.loja.conf.DataSourceConfigurationTest;
import br.com.caelum.fj27.loja.conf.JpaConfiguration;
import br.com.caelum.fj27.loja.models.BookType;
import br.com.caelum.fj27.loja.models.Product;
import br.com.caelum.fj27.loja.repositories.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by nando on 12/07/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class, ProductDao.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProductRepositoryTest {


    @Autowired
    private ProductDao dao;

    @Test
    @Transactional
    public void shouldSumAllPricesOfEachBookPerType() {


        List<Product> printedBooks = ProductBuilder
                .newProduct(BookType.PRINTED, BigDecimal.TEN)
                .more(4).buildAll();

        dao.save(printedBooks);

        List<Product> ebooks = ProductBuilder
                .newProduct(BookType.EBOOK, BigDecimal.TEN)
                .more(4).buildAll();

        dao.save(ebooks);


        BigDecimal value = dao.sumPricePerType(BookType.PRINTED);
        System.out.println(value);

        Assert.assertEquals(new BigDecimal("50").setScale(2), value);

    }
}
