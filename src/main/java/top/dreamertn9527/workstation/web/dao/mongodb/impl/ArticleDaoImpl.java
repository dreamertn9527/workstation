package top.dreamertn9527.workstation.web.dao.mongodb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import top.dreamertn9527.workstation.web.dao.mongodb.ArticleDao;
import top.dreamertn9527.workstation.web.dao.mongodb.SequenceDao;
import top.dreamertn9527.workstation.web.domain.mongodb.ArticlePO;
import top.dreamertn9527.workstation.web.repository.mongodb.ArticleRepository;

import java.util.Date;
import java.util.Optional;


@Repository
public class ArticleDaoImpl implements ArticleDao {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private SequenceDao sequenceDao;

    private static final String ARTICLE_SEQ = "article_seq";
    @Override
    public ArticlePO findById(Long id) {
        Optional<ArticlePO> optional = articleRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Page<ArticlePO> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public ArticlePO save(ArticlePO articlePO) {
        if(articlePO.getId() != null){
            articlePO.setId(sequenceDao.get(ARTICLE_SEQ));
        }
        articlePO.setModified(new Date());
        return articleRepository.save(articlePO);
    }
}
