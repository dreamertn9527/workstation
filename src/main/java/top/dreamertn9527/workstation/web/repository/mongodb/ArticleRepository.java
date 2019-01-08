package top.dreamertn9527.workstation.web.repository.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticlePO;


public interface ArticleRepository extends MongoRepository<ArticlePO, Long> {

    Page<ArticlePO> findAll(Pageable pageable);
}
