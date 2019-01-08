package top.dreamertn9527.workstation.web.domain.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Document(collection = "article_detail")
@Data
public class ArticleDetailPO {

    @Id
    private Long id;

    private String text;

    private Long titleId;

    private Integer status;
}
