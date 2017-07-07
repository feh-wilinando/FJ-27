package br.com.caelum.fj27.loja.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nando on 07/07/17.
 */
@Entity
public class Role implements GrantedAuthority{
    @Id
    private String name;


    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
