package xin.cymall.common.enumresource;


import xin.cymall.common.utils.EnumMessage;

/**
 * Created by zzl
 * 2017/7/20.
 */
public enum StateEnum implements EnumMessage {
    ENABLE("1","正常"),
    LIMIT("0","禁用");
    private final String code;
    private final String value;
    private StateEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
    @Override
    public String getCode() { return code;}
    @Override
    public String getValue() { return value; }
}
