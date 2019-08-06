package xin.cymall.common.tag;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.cymall.dao.OrganizeDao;
import xin.cymall.entity.Organize;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author zzl
 * @date 2019/8/5  15:26
 * @Des:
 */
@Component
public  class CommonTag implements TemplateDirectiveModel {
    @Autowired
    private OrganizeDao organizeDao;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        String name = params.get("name").toString();
        List<Organize> userlist = organizeDao.getList();

        env.setVariable("userList", getBeansWrapper().wrap(userlist));
        body.render(env.getOut());
    }
    public static BeansWrapper getBeansWrapper(){
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        return beansWrapper;
    }

}