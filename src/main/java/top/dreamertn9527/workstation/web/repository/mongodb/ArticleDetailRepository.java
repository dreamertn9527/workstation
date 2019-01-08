package top.dreamertn9527.workstation.web.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticleDetailPO;


public interface ArticleDetailRepository extends MongoRepository<ArticleDetailPO, Long> {

    ArticleDetailPO findByTitleId(Long id);
}
