package top.dreamertn9527.workstation.web.dao.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticlePO;


public interface ArticleDao {

    ArticlePO findById(Long id);

    Page<ArticlePO> findAll(Pageable pageable);

    ArticlePO save(ArticlePO articlePO);
}
