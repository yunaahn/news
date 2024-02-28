
package com.newsfeed.demo.repository;

        import com.newsfeed.demo.domain.News;
        import com.newsfeed.demo.domain.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        List<Long> findSubscribedSchoolIdsForCurrentUser();
}
