package top.dreamertn9527.workstation.web.dao.mongodb;

import top.dreamertn9527.workstation.web.domain.mongodb.ArticleDetailPO;


public interface ArticleDetailDao {

    ArticleDetailPO findByTitleId(Long id);

    ArticleDetailPO save(ArticleDetailPO articleDetailPO);
}
