package top.dreamertn9527.workstation.web.dao.mongodb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.dreamertn9527.workstation.web.dao.mongodb.ArticleDetailDao;
import top.dreamertn9527.workstation.web.dao.mongodb.SequenceDao;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticleDetailPO;
import top.dreamertn9527.workstation.web.repository.mongodb.ArticleDetailRepository;


@Repository
public class ArticleDetailDaoImpl implements ArticleDetailDao {

    @Autowired
    private ArticleDetailRepository articleDetailRepository;

    @Autowired
    private SequenceDao sequenceDao;

    private final static String ARTICLE_DETAIL_SEQ = "article_detail_seq";

    @Override
    public ArticleDetailPO findByTitleId(Long id) {
        return articleDetailRepository.findByTitleId(id);
    }

    @Override
    public ArticleDetailPO save(ArticleDetailPO articleDetailPO) {
        if(articleDetailPO.getId() != null){
            articleDetailPO.setId(sequenceDao.get(ARTICLE_DETAIL_SEQ));
        }
        return articleDetailRepository.save(articleDetailPO);
    }


}
