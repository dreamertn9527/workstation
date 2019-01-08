package top.dreamertn9527.workstation.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticleDetailPO;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticlePO;


public interface ArticleService {

    Page<ArticlePO> findAll(Pageable pageable);

    ArticlePO findById(Long id);

    ArticleDetailPO findByTitleId(Long id);

    Boolean save(ArticlePO articlePO, ArticleDetailPO articleDetailPO);

    Boolean update(ArticleDetailPO articleDetailPO);
}
