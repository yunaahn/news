
package com.newsfeed.demo.repository;

        import com.newsfeed.demo.domain.News;
        import com.newsfeed.demo.domain.User;
        import com.newsfeed.demo.domain.UserEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
        Boolean existsByUsername(String username);

        //username을 받아 DB 테이블에서 회원을 조회하는 메소드 작성
        UserEntity findByUsername(String username);
}
