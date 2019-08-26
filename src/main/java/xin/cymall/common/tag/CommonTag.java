package xin.cymall.common.tag;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.cymall.dao.OrganizeDao;

import java.io.IOException;
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
//        String id = params.get("id").toString();
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        env.setVariable("orgName", builder.build().wrap("11"));
        body.render(env.getOut());
    }

}