package xin.cymall.common.utils;

import lombok.Data;

import java.util.List;

/**
 * Created by zzl
 * 2017/7/7.
 */
@Data
public class TreeBean {
    private String id;
    private String name;
    private String parent_id;
    private List<TreeBean>  children;
}
