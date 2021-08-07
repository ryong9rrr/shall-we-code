package j2kb.swc.shallwecode.repository;

import j2kb.swc.shallwecode.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJapUserRepository extends JpaRepository<User, Long>, UserRepository {

    @Override
    Optional<User> findByEmail(String email);
}
