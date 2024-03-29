package xin.cymall.common.enumresource;

/**
 * Created by zzl on 2017/12/7.
 * 顶级菜单
 */
public enum TopCatEnum {
    TopCat("0","顶级分类");
    private final String desc;
    private final String code;

    private TopCatEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }
}
