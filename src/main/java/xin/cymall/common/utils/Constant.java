package xin.cymall.common.utils;

/**
 * 常量
 * 
 * @author zzl
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {
    /**包路径**/
    public final static String PACKAGE_NAME = "xin.cymall.common.enumresource";
	/** 超级管理员ID */
	public static final int SUPER_ADMIN = 1;
	/**默认角色*/
	public static final Long DEFAULT_ADMIN = 6L;

	/**
	 * 菜单类型
	 * 
	 * @author zzl
	 * @date 2016年11月15日 下午1:24:29
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        private MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    /**
     * 定时任务状态
     * 
     * @author zzl
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(0),
        /**
         * 暂停
         */
    	PAUSE(1);

        private int value;

        private ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        private CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * REDIS存放的枚举 key xxx_id
     */
    public enum RedisEnum{
        //个人信息
        USERINFO("userinfo_");
        private String value;
        private RedisEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
