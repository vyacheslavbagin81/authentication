package Roles;

import Work.WorkPersistence;

import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@NoArgsConstructor
public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> getAllRoles() {
        String sql = "select e from Role e";
        EntityManager entityManager = WorkPersistence.readPersistence();
        List<Role> roleList = entityManager.createQuery(sql).getResultList();
        WorkPersistence.closePersistence();
        return roleList;
    }

    @Override
    public Role getRole(int id) {
        EntityManager entityManager = WorkPersistence.readPersistence();
        Role role = entityManager.find(Role.class, id);
        WorkPersistence.closePersistence();
        return role;
    }

    @Override
    public void deleteRole(int id) {
        EntityManager entityManager = WorkPersistence.readPersistence();
        entityManager.remove(entityManager.find(Role.class, id));
        WorkPersistence.closePersistence();
    }

    @Override
    public void addRole(Role role) {
        EntityManager entityManager = WorkPersistence.readPersistence();
        entityManager.persist(role);
        WorkPersistence.closePersistence();
    }

}
