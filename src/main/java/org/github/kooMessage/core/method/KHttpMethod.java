package org.github.kooMessage.core.method;

import org.github.kooMessage.config.KooMessageUrl;
import org.github.kooMessage.model.Result;
import org.github.kooMessage.model.Template;
import org.github.kooMessage.model.service.businessLicense.post.CreateEnterpriseFilingTemplate;
import org.github.kooMessage.model.service.channelNo.create.BindChannelToServiceNoTemplate;
import org.github.kooMessage.model.service.channelNo.create.RegisterChannelNoTemplate;
import org.github.kooMessage.model.service.channelNo.create.UnBindChannelToServiceNoTemplate;
import org.github.kooMessage.model.service.channelNo.find.DeleteChannelNoTemplate;
import org.github.kooMessage.model.service.channelNo.find.FindChannelNoTemplate;
import org.github.kooMessage.model.service.examination.find.FindServiceMenuExaminationTemplate;
import org.github.kooMessage.model.service.examination.find.FindServicePageExaminationTemplate;
import org.github.kooMessage.model.service.serviceNo.create.CreateServiceNoTemplate;
import org.github.kooMessage.model.service.serviceNo.create.UploadServiceNoResourceTemplate;
import org.github.kooMessage.model.service.serviceNo.edit.EditServiceMenuTemplate;
import org.github.kooMessage.model.service.serviceNo.edit.EditServicePageTemplate;
import org.github.kooMessage.model.service.serviceNo.edit.UpdateServiceNoTemplate;
import org.github.kooMessage.model.service.serviceNo.find.FindServiceMenuTemplate;
import org.github.kooMessage.model.service.serviceNo.find.FindServiceNoTemplate;
import org.github.kooMessage.model.service.serviceNo.find.FindServicePageTemplate;
import org.github.kooMessage.model.service.serviceNo.freeze.FreezeServiceNoTemplate;
import org.github.kooMessage.model.service.serviceNo.freeze.UnFreezeServiceNoTemplate;
import org.github.kooMessage.model.smartBasicSMS.template.create.SmartSmsTemplatesCreateTemplate;
import org.github.kooMessage.model.smartBasicSMS.template.find.SmartSmsTemplatesGetTemplate;
import org.github.kooMessage.model.smartSMS.collidDb.test.FindCollideTemplate;
import org.github.kooMessage.model.smartSMS.sms.create.SmartSmsPostTemplate;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetDetailsTemplate;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetReportsTemplate;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetResult;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetTemplate;
import org.github.kooMessage.model.smartSMS.sms.register.SmartSmsURLTemplate;
import org.github.kooMessage.model.smartSMS.sms.resolve.SmartSmsResolveAnalysisTemplate;
import org.github.kooMessage.model.smartSMS.sms.resolve.SmartSmsResolveDetailsTemplate;
import org.github.kooMessage.model.smartSMS.sms.resolve.SmartSmsResolveTasksTemplate;
import org.github.kooMessage.model.smartSMS.template.create.PersonalTemplateTemplate;
import org.github.kooMessage.model.smartSMS.template.delete.DeleteMaterialTemplate;
import org.github.kooMessage.model.smartSMS.template.delete.DeletePersonalTemplateTemplate;
import org.github.kooMessage.model.smartSMS.template.find.FindMaterialTemplate;
import org.github.kooMessage.model.smartSMS.template.find.FindPersonalTemplateTemplate;
import org.github.kooMessage.model.smartSMS.template.upload.UploadMaterialTemplate;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 内置注册服务请求
 */
@Getter
@Slf4j
public enum KHttpMethod implements KHttpMethodService {
    //智能信息/AIM场景-客户使用华为通道/智能信息解析/生成解析任务
    RESOLVE_ANALYSIS_SMART_SMS("生成解析任务",SmartSmsResolveAnalysisTemplate.class, KooMessageUrl.getResolveTasksSmartSms(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/CreateResolveTask.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/智能信息解析/查询解析明细
    RESOLVE_DETAILS_SMART_SMS("查询解析明细",SmartSmsResolveDetailsTemplate.class, KooMessageUrl.getResolveDetailsSmartSms(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ListResolveDeails.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/智能信息解析/查询解析任务
    RESOLVE_TASKS_SMART_SMS("查询解析任务",SmartSmsResolveTasksTemplate.class, KooMessageUrl.getResolveTasksSmartSms(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ListResolveTasks.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/智能信息发送/查询智能信息发送报表
    SMART_SMS_URL("查询智能信息发送报表",SmartSmsURLTemplate.class, KooMessageUrl.getRegisterSmartSms(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/AddCallBack.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/智能信息发送/查询智能信息发送报表
    FIND_SMS_REPORTS("查询智能信息发送报表",SmartSmsGetReportsTemplate.class, KooMessageUrl.getFindSmsReports(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/ListAimSendReport.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/智能信息发送/查询智能信息发送明细
    FIND_SMS_DETAILS("查询智能信息发送明细",SmartSmsGetDetailsTemplate.class, KooMessageUrl.getFindSmsDetails(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ListSendDetails.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/查询个人模板
    DELETE_TEMPLATE("删除个人模板",DeletePersonalTemplateTemplate.class, KooMessageUrl.getDeletePersonalTemplate(),HttpMethod.DELETE,null,"https://support.huaweicloud.com/api-KooMessage/DeletePersonalTemplate.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/查询个人模板
    FIND_TEMPLATE("查询个人模板",FindPersonalTemplateTemplate.class, KooMessageUrl.getPersonalTemplate(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ListAIMTemplates.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/查询模板素材
    DELETE_MATERIAL("查询模板素材",DeleteMaterialTemplate.class, KooMessageUrl.getDeleteMaterial(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/DeleteTemplateMaterial.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/查询模板素材
    FIND_MATERIAL("查询模板素材",FindMaterialTemplate.class, KooMessageUrl.getMATERIAL(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ShowTemplateMaterial.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/上传模板素材
    UPLOAD_MATERIAL("上传模板素材",UploadMaterialTemplate.class, KooMessageUrl.getMATERIAL(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/UploadTemplateMaterial.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/创建个人模板
    PERSONAL_TEMPLATE("创建个人模板",PersonalTemplateTemplate.class, KooMessageUrl.getPersonalTemplate(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/CreatePersonalTemplate.html",DataType.JSON_STRING),
    //智能信息/AIM场景-客户使用华为通道/撞库测试、查询手机号智能信息解析能力
    FIND_COLLIDE("查询手机号智能信息解析能力",FindCollideTemplate.class, KooMessageUrl.getFindCollide(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/BatchListMobileCapability.html",DataType.JSON_STRING),
    //智能信息基础版/发送基础版智能信息
    SMART_SMS_POST("发送基础版智能信息",SmartSmsPostTemplate.class, KooMessageUrl.getSendTask(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/SendAIMTask.html",DataType.JSON_STRING),
    //智能信息基础版/智能信息基础版发送#查询智能信息基础版发送任务
    SMART_SMS_GET("查询智能信息基础版发送任务",SmartSmsGetTemplate.class, KooMessageUrl.getSelectTask(),HttpMethod.GET, SmartSmsGetResult.class,"https://support.huaweicloud.com/api-KooMessage/ListVMSSendTasks.html",DataType.JSON_STRING),
    //智能信息基础版/创建智能信息基础版模板#查看基础类模板
    SMART_SMS_TEMPLATES_GET("查看基础类模板",SmartSmsTemplatesGetTemplate.class, KooMessageUrl.getSmartSmsTemplates(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ListAIMTemplates.html",DataType.JSON_STRING),
    //智能信息基础版/创建智能信息基础版模板#创建视频短信 #创建图片短信
    SMART_SMS_TEMPLATES_PICTURE("创建短信",SmartSmsTemplatesCreateTemplate.class, KooMessageUrl.getSmartSmsTemplates(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/CreateTemplate.html",DataType.JSON_STRING),
    //智能信息服务号-企业管理-上传营业执照
    SERVICE_BUSINESS_LICENSE("上传营业执照",SmartSmsTemplatesCreateTemplate.class, KooMessageUrl.getServiceBusinessLicense(),HttpMethod.POST,null,null,DataType.JSON_STRING),
    //智能信息服务号-企业管理-创建服务号 失败 文档没有参数
    CREATE_SERVICE_ENTERPRISE_FILING("创建服务号",CreateEnterpriseFilingTemplate.class, KooMessageUrl.getServiceEnterpriseFiling(),HttpMethod.POST,null,null,DataType.JSON_STRING),
    //智能信息服务号-企业管理-查询企业信息
    FIND_SERVICE_ENTERPRISE_FILING("查询企业信息",CreateEnterpriseFilingTemplate.class, KooMessageUrl.getServiceEnterpriseFiling(),HttpMethod.GET,null,null,DataType.JSON_STRING),
    //智能信息服务号-查看服务号配置-查询服务号列表
    FIND_SERVICE_SERVICE_NO("查询服务号列表",FindServiceNoTemplate.class, KooMessageUrl.getFindServiceServiceNo(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/SearchPubDetail.html",DataType.JSON_STRING),
    //智能信息服务号-查看服务号配置-查询服务号主页列表
    FIND_SERVICE_SERVICE_PAGE("查询服务号主页列表",FindServicePageTemplate.class, KooMessageUrl.getFindServiceServicePage(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ListPortals.html",DataType.JSON_STRING),
    //智能信息服务号-查看服务号配置-查询服务号主页菜单列表
    FIND_SERVICE_SERVICE_MENU("查询服务号主页菜单列表",FindServiceMenuTemplate.class, KooMessageUrl.getFindServiceServiceMenu(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/ListMenus.html",DataType.JSON_STRING),
    //智能信息服务号-服务号审批-催审-服务号主页催审
    FIND_SERVICE_PAGE_EXAMINATION("服务号主页催审",FindServicePageExaminationTemplate.class, KooMessageUrl.getFindServicePageExamination(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/PushPortalsInfo1.html",DataType.JSON_STRING),
    //智能信息服务号-服务号审批-催审-服务号菜单催审
    FIND_SERVICE_MENU_EXAMINATION("服务号菜单催审",FindServiceMenuExaminationTemplate.class, KooMessageUrl.getFindServiceMenuExamination(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/PushMenusInfol.html",DataType.JSON_STRING),
    //智能信息服务号-服务号信息更改-冻结服务号
    FREEZE_SERVICE_NO("冻结服务号",FreezeServiceNoTemplate.class, KooMessageUrl.getFreezeServiceNo(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/FreezePub.html",DataType.JSON_STRING),
    //智能信息服务号-服务号信息更改-解冻服务号
    UNFREEZE_SERVICE_NO("解冻服务号",UnFreezeServiceNoTemplate.class, KooMessageUrl.getUnfreezeServiceNo(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/UnfreezePub.html",DataType.JSON_STRING),
    //智能信息服务号-绑定通道号-查询通道号列表
    FIND_CHANNEL_NO("查询通道号列表",FindChannelNoTemplate.class, KooMessageUrl.getFindChannelNo(),HttpMethod.GET,null,"https://support.huaweicloud.com/api-KooMessage/SearchPort.html",DataType.JSON_STRING),
    //智能信息服务号-绑定通道号-删除通道号列表
    DELETE_CHANNEL_NO("删除通道号列表",DeleteChannelNoTemplate.class, KooMessageUrl.getDeleteChannelNo(),HttpMethod.DELETE,null,"https://support.huaweicloud.com/api-KooMessage/DeletePort.html",DataType.JSON_STRING),
    //智能信息服务号-绑定通道号-注册通道号列表
    REGISTER_CHANNEL_NO("注册通道号列表",RegisterChannelNoTemplate.class, KooMessageUrl.getFindChannelNo(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/RegisterPort.html",DataType.JSON_STRING),
    //智能信息服务号-绑定通道号-通道号绑定服务号
    BIND_CHANNEL_SERVICE_NO("通道号绑定服务号",BindChannelToServiceNoTemplate.class, KooMessageUrl.getBindChannelServiceNo(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/LockPortDetails.html",DataType.JSON_STRING),
    //智能信息服务号-绑定通道号-通道号解绑服务号
    UNBIND_CHANNEL_SERVICE_NO("通道号解绑服务号",UnBindChannelToServiceNoTemplate.class, KooMessageUrl.getBindChannelServiceNo(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/UnlockPort.html",DataType.JSON_STRING),
    //智能信息服务号-服务号审批-修改智能信息服务号菜单
    EDIT_SERVICE_MENU("修改智能信息服务号菜单",EditServiceMenuTemplate.class, KooMessageUrl.getEditServiceMenu(),HttpMethod.PUT,null,"https://support.huaweicloud.com/api-KooMessage/UpdateMenu.html",DataType.JSON_STRING),
    //智能信息服务号-查看服务号配置-修改服务号
    UPDATE_SERVICE_SERVICE_NO("修改服务号",UpdateServiceNoTemplate.class, KooMessageUrl.getUpdateServiceServiceNo(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/UpdatePubInfo.html",DataType.JSON_STRING),
    //智能信息服务号-查看服务号配置-修改主页信息
    UPDATE_SERVICE_SERVICE_PAGE("修改主页信息",EditServicePageTemplate.class, KooMessageUrl.getEditServiceServicePage(),HttpMethod.PUT,null,"https://support.huaweicloud.com/api-KooMessage/UpdatePortal.html",DataType.JSON_STRING),
    //智能信息服务号-一站式服务号创建-创建服务号
    CREATE_SERVICE_SERVICE_NO("创建服务号",CreateServiceNoTemplate.class, KooMessageUrl.getCreateServiceServiceNo(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/CreatePubInfo.html",DataType.JSON_STRING),
    //智能信息服务号-一站式服务号创建-上传智能信息服务号图片资源
    UPLOAD_SERVICE_SERVICE_NO_RESOURCE("上传智能信息服务号图片资源",UploadServiceNoResourceTemplate.class, KooMessageUrl.getUploadServiceServiceNoResource(),HttpMethod.POST,null,"https://support.huaweicloud.com/api-KooMessage/UploadMedia.html",DataType.FORM_DATA);
    private String requestName;
    private Class< ? extends Template> template;
    private String url;
    private HttpMethod method;
    private Class< ? extends Result> result;
    private String documentUrl;

    private DataType dataType;

    KHttpMethod(String requestName,Class< ? extends Template> template, String url, HttpMethod method, Class< ? extends Result> result, String documentUrl, DataType dataType){
        this.requestName = requestName;
        this.template = template;
        this.url = url;
        this.method = method;
        this.result = result;
        this.documentUrl = documentUrl;
        this.dataType = dataType;
        KHttpMethodBody kHttpMethodBody = new KHttpMethodBody(template,url,method);
        kHttpMethodBody.setRequestName(requestName);
        kHttpMethodBody.setResult(result);
        kHttpMethodBody.setDocumentUrl(documentUrl);
        kHttpMethodBody.setDataType(dataType);
        //添加请求到注册表
        this.executeNewConfig(kHttpMethodBody);
    }


    /**
     * 加载到注册表
     */
    public  static void loadRegistry() {
        KHttpMethod.values();
        KHttpMethodService.printRegistry();
    }

    public static Map<Class,KHttpMethodBody> get( ){
        return registry;
    }
}
