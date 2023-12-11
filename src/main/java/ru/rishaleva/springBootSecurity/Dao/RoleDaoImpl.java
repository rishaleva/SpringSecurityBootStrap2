package ru.rishaleva.springBootSecurity.Dao;

import org.springframework.stereotype.Repository;
import ru.rishaleva.springBootSecurity.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }
}
