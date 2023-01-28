package org.github.kooMessage.config;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.config
 * @Author: 王飞
 * @CreateTime: 2022-10-28  11:00
 * @Description: 内置请求对象
 * @Version: 1.0
 */
public class KooMessageUrl {
    //智能信息/AIM场景-客户使用华为通道/智能信息解析/查询解析明细
    private static String RESOLVE_DETAILS_SMART_SMS = "https://koomessage.myhuaweicloud.cn/v1/aim/resolve-details";
    //智能信息/AIM场景-客户使用华为通道/智能信息解析/查询解析任务
    private static String RESOLVE_TASKS_SMART_SMS = "https://koomessage.myhuaweicloud.cn/v1/aim/resolve-tasks";
    //智能信息/AIM场景-客户使用华为通道/智能信息回执/注册智能信息回执URL
    private static String REGISTER_SMART_SMS = "https://koomessage.myhuaweicloud.cn/v1/aim/callbacks";
    //智能信息/AIM场景-客户使用华为通道/智能信息发送/查询智能信息发送明细
    private static String FIND_SMS_REPORTS = "https://koomessage.myhuaweicloud.cn/v1/aim/send-reports";
    //智能信息/AIM场景-客户使用华为通道/智能信息发送/查询智能信息发送明细
    private static String FIND_SMS_DETAILS = "https://koomessage.myhuaweicloud.cn/v1/aim/send-details";
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/删除个人模板
    private static String DELETE_PERSONAL_TEMPLATE = "https://koomessage.myhuaweicloud.cn/v1/aim/template/{tpl_id}";
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/创建个人模板
    private static String PERSONAL_TEMPLATE = "https://koomessage.myhuaweicloud.cn/v1/aim/templates";
    //智能信息/AIM场景-客户使用华为通道/撞库测试
    private static String FIND_COLLIDE = "https://koomessage.myhuaweicloud.cn/v1/aim/mobile-capabilities/check";
    //智能信息基础版/发送基础版智能信息
    private static String SEND_TASK = "https://koomessage.myhuaweicloud.cn/v1/aim/send-tasks";
    //智能信息基础版/智能信息基础版发送#查询智能信息基础版发送任务
    private static String SELECT_TASK = "https://koomessage.myhuaweicloud.cn/v1/aim-basic/send-tasks";
    //创建智能信息基础版模板
    private static String SMART_SMS_TEMPLATES = "https://koomessage.myhuaweicloud.cn/v1/aim-basic/templates";
    //智能信息服务号-企业管理-上传营业执照
    private static String SERVICE_BUSINESS_LICENSE = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/media/upload";
    //智能信息服务号-企业管理-创建企业备案
    private static String SERVICE_ENTERPRISE_FILING = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/companies";
    //智能信息服务号-查看服务号配置-查询服务号列表
    private static String FIND_SERVICE_SERVICE_NO = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/pubs";
    //智能信息服务号-查看服务号配置-修改服务号
    private static String UPDATE_SERVICE_SERVICE_NO = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/pubs/{pub_id}";
    //智能信息服务号-查看服务号配置-查询服务号主页列表
    private static String FIND_SERVICE_SERVICE_PAGE = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/portals";
    //智能信息服务号-查看服务号配置-修改服务号主页列表
    private static String EDIT_SERVICE_SERVICE_PAGE = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/portals/{portal_id}";
    //智能信息服务号-查看服务号配置-查询服务号菜单列表
    private static String FIND_SERVICE_SERVICE_MENU = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/menus";
    //智能信息服务号-服务号审批-催审-服务号主页催审
    private static String FIND_SERVICE_PAGE_EXAMINATION = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/portals/{portal_id}/push";
    //智能信息服务号-服务号审批-催审-服务号菜单催审
    private static String FIND_SERVICE_MENU_EXAMINATION = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/menus/{menu_id}/push";
    //智能信息服务号-服务号审批-修改智能信息服务号菜单
    private static String EDIT_SERVICE_MENU = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/menus/{menu_id}";
    //智能信息服务号-服务号信息更改-冻结服务号
    private static String FREEZE_SERVICE_NO = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/pubs/{pub_id}/freeze";
    //智能信息服务号-服务号信息更改-冻结服务号
    private static String UNFREEZE_SERVICE_NO = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/pubs/{pub_id}/unfreeze";
    //智能信息服务号-绑定通道号-查询通道号列表
    private static String FIND_CHANNEL_NO = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/ports";
    //智能信息服务号-绑定通道号-删除通道号列表
    private static String DELETE_CHANNEL_NO = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/ports/{id}";
    //智能信息服务号-绑定通道号-通道号绑定服务号
    private static String BIND_CHANNEL_SERVICE_NO = "https://koomessage.myhuaweicloud.cn/v1/aim-sa/ports/associate";
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/上传模板素材
    private static String MATERIAL = "https://koomessage.myhuaweicloud.com/v1/aim/template-materials";
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/删除模板素材
    private static String DELETE_MATERIAL = "https://koomessage.myhuaweicloud.com/v1/aim/template-materials/delete";
    //智能信息服务号-一站式服务号创建-创建服务号
    private static String CREATE_SERVICE_SERVICE_NO = "https://koomessage.myhuaweicloud.com/v1/aim-sa/unify/pubs";
    private static String UPLOAD_SERVICE_SERVICE_NO_RESOURCE = "https://koomessage.myhuaweicloud.com/v1/aim-sa/media/upload";
    public static void setSendTask(String sendTask) {
        SEND_TASK = sendTask;
    }

    public static String getSelectTask() {
        return SELECT_TASK;
    }

    public static void setSelectTask(String selectTask) {
        SELECT_TASK = selectTask;
    }

    public static String getSmartSmsTemplates() {
        return SMART_SMS_TEMPLATES;
    }

    public static void setSmartSmsTemplates(String smartSmsTemplates) {
        SMART_SMS_TEMPLATES = smartSmsTemplates;
    }

    public static String getServiceBusinessLicense() {
        return SERVICE_BUSINESS_LICENSE;
    }

    public static void setServiceBusinessLicense(String serviceBusinessLicense) {
        SERVICE_BUSINESS_LICENSE = serviceBusinessLicense;
    }

    public static String getSendTask() {
        return SEND_TASK;
    }

    public static String getServiceEnterpriseFiling() {
        return SERVICE_ENTERPRISE_FILING;
    }

    public static void setServiceEnterpriseFiling(String serviceEnterpriseFiling) {
        SERVICE_ENTERPRISE_FILING = serviceEnterpriseFiling;
    }

    public static String getFindServiceServiceNo() {
        return FIND_SERVICE_SERVICE_NO;
    }

    public static void setFindServiceServiceNo(String findServiceServiceNo) {
        FIND_SERVICE_SERVICE_NO = findServiceServiceNo;
    }

    public static String getFindServiceServicePage() {
        return FIND_SERVICE_SERVICE_PAGE;
    }

    public static void setFindServiceServicePage(String findServiceServicePage) {
        FIND_SERVICE_SERVICE_PAGE = findServiceServicePage;
    }

    public static String getFindServiceServiceMenu() {
        return FIND_SERVICE_SERVICE_MENU;
    }

    public static void setFindServiceServiceMenu(String findServiceServiceMenu) {
        FIND_SERVICE_SERVICE_MENU = findServiceServiceMenu;
    }

    public static String getFindServicePageExamination() {
        return FIND_SERVICE_PAGE_EXAMINATION;
    }

    public static void setFindServicePageExamination(String findServicePageExamination) {
        FIND_SERVICE_PAGE_EXAMINATION = findServicePageExamination;
    }

    public static String getFindServiceMenuExamination() {
        return FIND_SERVICE_MENU_EXAMINATION;
    }

    public static void setFindServiceMenuExamination(String findServiceMenuExamination) {
        FIND_SERVICE_MENU_EXAMINATION = findServiceMenuExamination;
    }

    public static String getFreezeServiceNo() {
        return FREEZE_SERVICE_NO;
    }

    public static void setFreezeServiceNo(String freezeServiceNo) {
        FREEZE_SERVICE_NO = freezeServiceNo;
    }

    public static String getUnfreezeServiceNo() {
        return UNFREEZE_SERVICE_NO;
    }

    public static void setUnfreezeServiceNo(String unfreezeServiceNo) {
        UNFREEZE_SERVICE_NO = unfreezeServiceNo;
    }

    public static String getFindChannelNo() {
        return FIND_CHANNEL_NO;
    }

    public static void setFindChannelNo(String findChannelNo) {
        FIND_CHANNEL_NO = findChannelNo;
    }

    public static String getDeleteChannelNo() {
        return DELETE_CHANNEL_NO;
    }

    public static void setDeleteChannelNo(String deleteChannelNo) {
        DELETE_CHANNEL_NO = deleteChannelNo;
    }

    public static String getBindChannelServiceNo() {
        return BIND_CHANNEL_SERVICE_NO;
    }

    public static void setBindChannelServiceNo(String bindChannelServiceNo) {
        BIND_CHANNEL_SERVICE_NO = bindChannelServiceNo;
    }

    public static String getFindCollide() {
        return FIND_COLLIDE;
    }

    public static void setFindCollide(String findCollide) {
        FIND_COLLIDE = findCollide;
    }

    public static String getPersonalTemplate() {
        return PERSONAL_TEMPLATE;
    }

    public static void setPersonalTemplate(String personalTemplate) {
        PERSONAL_TEMPLATE = personalTemplate;
    }

    public static String getMATERIAL() {
        return MATERIAL;
    }

    public static void setMATERIAL(String MATERIAL) {
        KooMessageUrl.MATERIAL = MATERIAL;
    }

    public static String getDeleteMaterial() {
        return DELETE_MATERIAL;
    }

    public static void setDeleteMaterial(String deleteMaterial) {
        DELETE_MATERIAL = deleteMaterial;
    }

    public static String getDeletePersonalTemplate() {
        return DELETE_PERSONAL_TEMPLATE;
    }

    public static void setDeletePersonalTemplate(String deletePersonalTemplate) {
        DELETE_PERSONAL_TEMPLATE = deletePersonalTemplate;
    }
    public static String getFindSmsDetails() {
        return FIND_SMS_DETAILS;
    }

    public static void setFindSmsDetails(String findSmsDetails) {
        FIND_SMS_DETAILS = findSmsDetails;
    }

    public static String getFindSmsReports() {
        return FIND_SMS_REPORTS;
    }

    public static void setFindSmsReports(String findSmsReports) {
        FIND_SMS_REPORTS = findSmsReports;
    }

    public static String getRegisterSmartSms() {
        return REGISTER_SMART_SMS;
    }

    public static void setRegisterSmartSms(String registerSmartSms) {
        REGISTER_SMART_SMS = registerSmartSms;
    }

    public static String getResolveDetailsSmartSms() {
        return RESOLVE_DETAILS_SMART_SMS;
    }

    public static void setResolveDetailsSmartSms(String resolveDetailsSmartSms) {
        RESOLVE_DETAILS_SMART_SMS = resolveDetailsSmartSms;
    }

    public static String getResolveTasksSmartSms() {
        return RESOLVE_TASKS_SMART_SMS;
    }

    public static void setResolveTasksSmartSms(String resolveTasksSmartSms) {
        RESOLVE_TASKS_SMART_SMS = resolveTasksSmartSms;
    }

    public static String getEditServiceMenu() {
        return EDIT_SERVICE_MENU;
    }

    public static void setEditServiceMenu(String editServiceMenu) {
        EDIT_SERVICE_MENU = editServiceMenu;
    }

    public static String getUpdateServiceServiceNo() {
        return UPDATE_SERVICE_SERVICE_NO;
    }

    public static void setUpdateServiceServiceNo(String updateServiceServiceNo) {
        UPDATE_SERVICE_SERVICE_NO = updateServiceServiceNo;
    }

    public static String getEditServiceServicePage() {
        return EDIT_SERVICE_SERVICE_PAGE;
    }

    public static void setEditServiceServicePage(String editServiceServicePage) {
        EDIT_SERVICE_SERVICE_PAGE = editServiceServicePage;
    }

    public static String getCreateServiceServiceNo() {
        return CREATE_SERVICE_SERVICE_NO;
    }

    public static void setCreateServiceServiceNo(String createServiceServiceNo) {
        CREATE_SERVICE_SERVICE_NO = createServiceServiceNo;
    }

    public static String getUploadServiceServiceNoResource() {
        return UPLOAD_SERVICE_SERVICE_NO_RESOURCE;
    }

    public static void setUploadServiceServiceNoResource(String uploadServiceServiceNoResource) {
        UPLOAD_SERVICE_SERVICE_NO_RESOURCE = uploadServiceServiceNoResource;
    }
}
