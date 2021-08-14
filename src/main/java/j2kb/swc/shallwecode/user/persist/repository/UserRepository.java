package j2kb.swc.shallwecode.user.persist.repository;

import j2kb.swc.shallwecode.user.persist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
