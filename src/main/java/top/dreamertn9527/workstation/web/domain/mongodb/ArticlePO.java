package top.dreamertn9527.workstation.web.domain.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;


@Document(collection = "article")
@Data
public class ArticlePO {

    @Id
    private Long id;

    private Date created;

    private Date modified;

    private String name;

    private String desc;

    private Integer pv;

    private Integer status;
}
