package xin.cymall.entity;

import lombok.Data;

/**
 * 列的属性
 * 
 * @author zzl
 * @date 2016年12月20日 上午12:01:45
 */
@Data
public class Column {
	//列名
    private String columnName;
    //列名类型
    private String dataType;
    private String maxLength;
    //列名备注
    private String comments;

    //属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    //属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    //属性类型
    private String attrType;
    //auto_increment
    private String extra;
    }
