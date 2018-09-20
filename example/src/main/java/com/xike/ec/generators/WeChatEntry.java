package com.xike.ec.generators;


import com.xike.kbq.annotatios.EntryGenerator;
import com.xike.kbq.core.wechat.templates.WXEntryTemplate;

/**
 * Created by 傅令杰 on 2017/4/22
 */

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.xike.ec",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
