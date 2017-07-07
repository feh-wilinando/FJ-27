package br.com.caelum.fj27.loja.controller;

import br.com.caelum.fj27.loja.infra.FileSaver;
import br.com.caelum.fj27.loja.models.BookType;
import br.com.caelum.fj27.loja.models.Product;
import br.com.caelum.fj27.loja.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created by nando on 02/07/17.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private FileSaver fileSaver;

    @GetMapping("form")
    public ModelAndView form(Product product){
        ModelAndView view = new ModelAndView("products/form");

        view.addObject("types", BookType.values());

        return view;
    }

    @GetMapping
    @Cacheable("lastProducts")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("products/list");

        view.addObject("products", productDao.findAll());

        return view;
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "lastProducts", allEntries = true)
    public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult result, RedirectAttributes redirectAttributes){

        ModelAndView view = new ModelAndView("redirect:/products");

        if (result.hasErrors()) return form(product);

        String summaryPath = fileSaver.write("uploaded-summaries", summary);
        product.setSummaryPath(summaryPath);

        productDao.save(product);

        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");

        return view;
    }


    @GetMapping("{id}")
    public ModelAndView show(@PathVariable("id") Integer id){
        ModelAndView view = new ModelAndView("products/show");

        view.addObject("product", productDao.findOne(id));

        return view;
    }
}
