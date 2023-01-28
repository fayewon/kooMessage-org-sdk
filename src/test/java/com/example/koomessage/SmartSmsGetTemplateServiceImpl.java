package com.example.koomessage;

import org.github.kooMessage.core.service.KooMessageService;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetTemplate;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: com.example.koomessage
 * @Author: 王飞
 * @CreateTime: 2022-10-31  16:52
 * @Description: 推荐的标准写法 这样写执行效率更快
 * @Version: 1.0
 */
@Service
public class SmartSmsGetTemplateServiceImpl implements KooMessageService<String, SmartSmsGetTemplate> {

    @Override
    public SmartSmsGetTemplate convertData() {
        SmartSmsGetTemplate smartSmsGetTemplate = new SmartSmsGetTemplate();
        smartSmsGetTemplate.setTask_id("a6067e45-2203-4432-98d2-b9a5de4aed48");
        smartSmsGetTemplate.setTask_name("测试-长城");
        return smartSmsGetTemplate;
    }
}
