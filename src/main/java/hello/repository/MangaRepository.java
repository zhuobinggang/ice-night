package hello.repository;

import hello.pojo.Manga;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * Created by Administrator on 2017/1/25.
 */

@Repository
@Table(name = "manga")
@Qualifier("mangaRepository")
public interface MangaRepository extends CrudRepository<Manga,Long> {
}
