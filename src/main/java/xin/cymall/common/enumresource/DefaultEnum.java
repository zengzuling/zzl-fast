package xin.cymall.common.enumresource;

import xin.cymall.common.utils.EnumMessage;

/**
 * @Author: zzl
 * @Description: 默认密码
 * @Date: 2017/9/2 21:27
 */
public enum DefaultEnum implements EnumMessage {
    PARENT_ACCOUNT("zzl","默认上级账号"),
    PASSWORD("123456","默认会员密码");
    private final String code;
    private final String value;
    private DefaultEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
    @Override
    public String getCode() { return code;}
    @Override
    public String getValue() { return value; }
}