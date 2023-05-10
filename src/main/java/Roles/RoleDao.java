package Roles;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    Role getRole(int id);
    void deleteRole(int id);
    void addRole(Role role);
}
