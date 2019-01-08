package top.dreamertn9527.workstation.web.domain.mongodb;

import lombok.Data;

import javax.persistence.Id;

@Data
public class MongoSequence {
    @Id
    private String id;
    private Long seq;
}