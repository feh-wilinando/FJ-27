package br.com.caelum.fj27.loja.repositories;

import br.com.caelum.fj27.loja.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nando on 07/07/17.
 */
@Repository
public class UserDao implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String jpql = "select u from User u where u.login = :login";

        List<User> users = em.createQuery(jpql,User.class)
                .setParameter("login", username).getResultList();

        if(users.isEmpty()) {
            throw new UsernameNotFoundException
                    ("O usuario " +username +" não existe");
        }

        return users.get(0);
    }
}
