package com.xike.ec.generators;


import com.xike.kbq.annotatios.PayEntryGenerator;
import com.xike.kbq.core.wechat.templates.WXPayEntryTemplate;

/**
 * Created by 傅令杰 on 2017/4/22
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.xike.ec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
