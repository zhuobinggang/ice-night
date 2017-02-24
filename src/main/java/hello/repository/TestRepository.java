package hello.repository;

import hello.pojo.BBS;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kobako on 2017/2/23.
 * Just a game
 */
public interface TestRepository extends JpaRepository<BBS,Long> {

}
