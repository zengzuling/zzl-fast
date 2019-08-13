package xin.cymall.common.config;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import xin.cymall.common.tag.CommonTag;

import javax.annotation.PostConstruct;

/**
 * @Author zzl
 * @date 2019/8/6  15:40
 * @Des:
 */
public class FreemarkerConfig {

    @Autowired
    private Configuration configuration;
    @Autowired
    private CommonTag commonTag;

    @PostConstruct
    public void setSharedVariable(){
        configuration.setSharedVariable("orgName", commonTag);
    }
}
