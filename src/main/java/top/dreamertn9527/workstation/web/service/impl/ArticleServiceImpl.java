package top.dreamertn9527.workstation.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.dreamertn9527.workstation.web.dao.mongodb.ArticleDao;
import top.dreamertn9527.workstation.web.dao.mongodb.ArticleDetailDao;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticleDetailPO;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticlePO;
import top.dreamertn9527.workstation.web.enums.ArticleStatusEnum;
import top.dreamertn9527.workstation.web.service.ArticleService;

import java.util.Date;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleDetailDao articleDetailDao;

    @Override
    public Page<ArticlePO> findAll(Pageable pageable) {
        return articleDao.findAll(pageable);
    }

    @Override
    public ArticlePO findById(Long id) {
        return articleDao.findById(id);
    }

    @Override
    public ArticleDetailPO findByTitleId(Long id) {
        return articleDetailDao.findByTitleId(id);
    }

    @Override
    public Boolean save(ArticlePO articlePO, ArticleDetailPO articleDetailPO) {
        articlePO.setStatus(ArticleStatusEnum.CREATING.getCode());
        articleDetailPO.setStatus(ArticleStatusEnum.CREATING.getCode());
        articlePO.setCreated(new Date());

        articlePO = articleDao.save(articlePO);
        articleDetailPO = articleDetailDao.save(articleDetailPO);

        articlePO.setStatus(ArticleStatusEnum.CREATED.getCode());
        articleDetailPO.setStatus(ArticleStatusEnum.CREATED.getCode());

        articleDao.save(articlePO);
        articleDetailDao.save(articleDetailPO);

        return Boolean.TRUE;
    }

    @Override
    public Boolean update(ArticleDetailPO articleDetailPO){
        ArticlePO articlePO = articleDao.findById(articleDetailPO.getId());
        articleDao.save(articlePO);
        articleDetailDao.save(articleDetailPO);

        return Boolean.TRUE;
    }
}
