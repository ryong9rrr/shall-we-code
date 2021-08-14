package j2kb.swc.shallwecode.project.persist.repository;

import j2kb.swc.shallwecode.project.persist.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProjectRepository extends JpaRepository<Project, Long> {
}
