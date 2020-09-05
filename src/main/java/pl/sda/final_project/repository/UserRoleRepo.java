package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.final_project.model.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    @Query("select case when count(u)> 0 then true else false end from UserRole u where lower(u.roleName) like lower(?1)")
    boolean roleExists(String name);

    @Query("select ur from UserRole ur where lower(ur.roleName) = lower(?1)")
    UserRole findByRoleName(String roleName);
}
