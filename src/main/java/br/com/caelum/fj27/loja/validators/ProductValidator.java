package br.com.caelum.fj27.loja.validators;

import br.com.caelum.fj27.loja.models.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by nando on 02/07/17.
 */
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description", "field.required");

        Product product = (Product) target;

        if (product.getNumberOfPages() == null || product.getNumberOfPages() == 0){
            errors.rejectValue("numberOfPages", "field.required");
        }

    }
}
