package j2kb.swc.shallwecode.userproject.persist.repository;

import j2kb.swc.shallwecode.userproject.persist.entity.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserProjectRepository extends JpaRepository<UserProject, Long> {

    @Modifying
    @Query(value = "delete from user_project where user_id =:userId and project_id =:projectId", nativeQuery = true)
    int mdeleteJoinProject(Long userId, Long projectId);

    @Modifying
    @Query(value = "select user_id, email, nickname, skills from user where user_id in (select user_id from user_project where project_id =:projectId)", nativeQuery = true)
    List<String> mselectJoinedUserList(Long projectId);

    int deleteAllByProject_Id(Long projectId);

}
