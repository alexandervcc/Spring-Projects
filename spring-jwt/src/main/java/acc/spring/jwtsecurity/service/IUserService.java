package acc.spring.jwtsecurity.service;

import acc.spring.jwtsecurity.model.AppUser;
import acc.spring.jwtsecurity.model.Role;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);
    List<AppUser> getUsers();
}
