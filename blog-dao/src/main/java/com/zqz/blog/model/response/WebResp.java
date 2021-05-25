package com.zqz.blog.model.response;

import com.zqz.blog.enums.RespEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:10 2021/5/21
 */
@Data
public class WebResp<T> implements Serializable {
    private static final long serialVersionUID = 911794427680201966L;

    private String code;

    private String msg;

    private T data;

    public WebResp() {
        super();
        this.code = RespEnum.RE_00.getCode();
        this.msg = RespEnum.RE_00.getMsg();
        this.data = null;
    }

    public WebResp(T data) {
        super();
        this.code = RespEnum.RE_00.getCode();
        this.msg = RespEnum.RE_00.getMsg();
        this.data = data;
    }


    public WebResp(String msg) {
        super();
        this.msg = StringUtils.isNotBlank(msg) ? msg : RespEnum.RE_99.getMsg();
        this.code = RespEnum.RE_99.getCode();
    }

    public WebResp(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public WebResp(RespEnum respEnum){
        super();
        this.code = respEnum.getCode();
        this.msg = respEnum.getMsg();
    }

}
