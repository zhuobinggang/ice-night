package hello.repository;

import hello.pojo.BBS;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/27.
 */
@Repository
public interface BbsRepository extends PagingAndSortingRepository<BBS,Long> {

}
