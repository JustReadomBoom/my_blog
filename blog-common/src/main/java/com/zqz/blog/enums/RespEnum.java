package com.zqz.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: zqz
 * @Description: 统一响应枚举
 * @Date: Created in 14:21 2020/8/28
 */
@Getter
@AllArgsConstructor
public enum RespEnum {

    RE_00("0000", "成功"),

    RE_01("1001", "失败"),

    RE_02("1002", "参数错误"),

    RE_03("1003", "用户不存在"),

    RE_04("1004", "密码错误"),

    RE_05("1005", "无数据"),

    RE_06("1006", "评论不存在"),

    RE_07("1007", "确认密码不一致"),

    RE_08("1008", "用户名重复"),

    RE_99("9999", "系统异常");

    private String code;
    private String msg;

}
