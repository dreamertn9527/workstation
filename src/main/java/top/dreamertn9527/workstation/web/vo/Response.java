package top.dreamertn9527.workstation.web.vo;

import lombok.Data;


@Data
public class Response<T> {

    private Long code;

    private String msg;

    private T data;
}
