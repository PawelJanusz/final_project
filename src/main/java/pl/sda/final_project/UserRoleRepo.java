package pl.sda.final_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    @Query("select case when count(u)> 0 then true else false end from UserRole u where lower(u.roleName) like lower(?1)")
    boolean roleExists(String name);

    @Query("select ur from UserRole ur where (ur.roleName) = lower(?1)")
    UserRole findByRoleName(String roleName);
}
