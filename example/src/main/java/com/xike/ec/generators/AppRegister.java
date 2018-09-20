package com.xike.ec.generators;

import com.xike.kbq.annotatios.AppRegisterGenerator;
import com.xike.kbq.core.wechat.templates.AppRegisterTemplate;

/**
 * Created by 傅令杰 on 2017/4/22
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.xike.ec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
