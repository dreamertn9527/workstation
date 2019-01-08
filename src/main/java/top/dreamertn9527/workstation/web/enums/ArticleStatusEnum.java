package top.dreamertn9527.workstation.web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@Getter
public enum  ArticleStatusEnum {

    CREATING(0, "创建中"),

    CREATED(1, "创建成功"),

    DELETED(2, "已经删除")
    ;
    private Integer code;

    private String msg;


    private static Map<Integer, ArticleStatusEnum> MAP = new HashMap<>();

    static {
        for(ArticleStatusEnum e : ArticleStatusEnum.values()){
            MAP.put(e.code, e);
        }
    }

    public static ArticleStatusEnum fromCode(Integer code){
        return MAP.get(code);
    }

}


