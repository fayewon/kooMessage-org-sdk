package com.example.koomessage;
import org.github.kooMessage.core.method.KHttpMethod;
import org.github.kooMessage.core.response.ResponseBody;
import org.github.kooMessage.core.service.*;
import org.github.kooMessage.model.service.businessLicense.get.FindEnterpriseFilingTemplate;
import org.github.kooMessage.model.service.businessLicense.post.BusinessLicenseTemplate;
import org.github.kooMessage.model.service.businessLicense.post.CreateEnterpriseFilingTemplate;
import org.github.kooMessage.model.service.channelNo.create.BindChannelToServiceNoTemplate;
import org.github.kooMessage.model.service.channelNo.create.RegisterChannelNoTemplate;
import org.github.kooMessage.model.service.channelNo.create.UnBindChannelToServiceNoTemplate;
import org.github.kooMessage.model.service.channelNo.find.DeleteChannelNoTemplate;
import org.github.kooMessage.model.service.channelNo.find.FindChannelNoTemplate;
import org.github.kooMessage.model.service.examination.find.FindServiceMenuExaminationTemplate;
import org.github.kooMessage.model.service.examination.find.FindServicePageExaminationTemplate;
import org.github.kooMessage.model.service.serviceNo.create.*;
import org.github.kooMessage.model.service.serviceNo.edit.*;
import org.github.kooMessage.model.service.serviceNo.find.FindServiceMenuTemplate;
import org.github.kooMessage.model.service.serviceNo.find.FindServiceNoTemplate;
import org.github.kooMessage.model.service.serviceNo.find.FindServicePageTemplate;
import org.github.kooMessage.model.service.serviceNo.freeze.FreezeServiceNoTemplate;
import org.github.kooMessage.model.service.serviceNo.freeze.UnFreezeServiceNoTemplate;
import org.github.kooMessage.model.smartBasicSMS.template.create.Reslist;
import org.github.kooMessage.model.smartBasicSMS.template.create.SmartSmsTemplatesCreateTemplate;
import org.github.kooMessage.model.smartBasicSMS.template.find.SmartSmsTemplatesGetTemplate;
import org.github.kooMessage.model.smartSMS.collidDb.test.FindCollideTemplate;
import org.github.kooMessage.model.smartSMS.sms.create.CreateAIMSendResolve;
import org.github.kooMessage.model.smartSMS.sms.create.CreateResolveTaskParam;
import org.github.kooMessage.model.smartSMS.sms.create.SmartSmsPostTemplate;
import org.github.kooMessage.model.smartSMS.sms.create.SmsChannel;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetDetailsTemplate;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetReportsTemplate;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetResult;
import org.github.kooMessage.model.smartSMS.sms.find.SmartSmsGetTemplate;
import org.github.kooMessage.model.smartSMS.sms.register.SmartSmsURLTemplate;
import org.github.kooMessage.model.smartSMS.sms.resolve.SmartSmsResolveAnalysisTemplate;
import org.github.kooMessage.model.smartSMS.sms.resolve.SmartSmsResolveDetailsTemplate;
import org.github.kooMessage.model.smartSMS.sms.resolve.SmartSmsResolveTasksTemplate;
import org.github.kooMessage.model.smartSMS.template.create.PersonalTemplateFactoryContent;
import org.github.kooMessage.model.smartSMS.template.create.PersonalTemplateFactoryContentAction;
import org.github.kooMessage.model.smartSMS.template.create.PersonalTemplatePage;
import org.github.kooMessage.model.smartSMS.template.create.PersonalTemplateTemplate;
import org.github.kooMessage.model.smartSMS.template.delete.DeleteMaterialTemplate;
import org.github.kooMessage.model.smartSMS.template.delete.DeletePersonalTemplateTemplate;
import org.github.kooMessage.model.smartSMS.template.find.FindMaterialTemplate;
import org.github.kooMessage.model.smartSMS.template.find.FindPersonalTemplateTemplate;
import org.github.kooMessage.model.smartSMS.template.upload.UploadMaterialTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: com.example.koomessage
 * @Author: 王飞
 * @CreateTime: 2022-09-28  09:56
 * @Description: kooMessage联调测试
 * @Version: 1.0
 */
@Slf4j
public class KooMessageTest {
    static {
        KHttpMethod.
                loadRegistry();
    }
    //智能信息基础版/智能信息基础版发送#智能信息发送 成功  群发、个性化、自定义短码
    @Test
    public void smartSmsPost(){
        StringKMActuator<SmartSmsPostTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsPostTemplate>() {
                    @Override
                    public SmartSmsPostTemplate convertData() {
                        CreateResolveTaskParam createResolveTaskParam = new CreateResolveTaskParam("1538705XXXX");
                        //createResolveTaskParam.setCustom_short_code("asdc24");
                        CreateResolveTaskParam[] array = new CreateResolveTaskParam[]{createResolveTaskParam};
                        SmsChannel smsChannel = new SmsChannel("8822082325917","15100556","XXXX","APP_NAME");
                        CreateAIMSendResolve createAIMSendResolve = new CreateAIMSendResolve("600156386",1,"individual",1,array);
                        //createAIMSendResolve.setGeneration_type(2);
                        SmartSmsPostTemplate smartSmsTemplate = new SmartSmsPostTemplate("XXXXX",smsChannel,createAIMSendResolve);
                        return smartSmsTemplate;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getData());
    }

    public String addSpace(int index){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<index;i++){
            sb.append(' ');
        }
        return sb.toString();
    }

    public String addChinese(String requestName) {
        StringBuilder sb = new StringBuilder(requestName);
        int maxLength = 13;
        if( requestName.length() < maxLength ){
            for (int i=0;i<maxLength-requestName.length();i++) {
                sb.append('》');
            }
        }
        return sb.toString();
    }
    @Test
    public void print() {
        String requestName = "|             请求名称             |";
        String template = "                 参数模板                |";
        String dataType = "     数据类型   |";
        String method = "  请求类型 |";
        String url = "                                     URL                                    |";
        String result = "                返回模板                |";
        String documentUrl = "                                        文档                                       |";
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n"+"————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————"+"\r\n");
        sb.append(requestName+template+dataType+method+url+result+documentUrl+"\r\n");
        KHttpMethod.get().values().forEach((body)->{
            String requestNameName = body.getRequestName() == null ? "未设置":body.getRequestName();
            requestNameName = addChinese(requestNameName);
            String templateName = body.getTemplate().getSimpleName();
            String dataTypeName = body.getDataType().toString();
            String methodName = body.getMethod().toString();
            String urlName = body.getUrl();
            String resultName = body.getResult() == null ? "Not set":body.getResult().getSimpleName().toString();
            String documentUrlName = body.getDocumentUrl() == null ? "Not set":body.getDocumentUrl().toString();
            String space0 = addSpace(requestName.length() - requestNameName.length()-11);
            String space1 = addSpace(template.length() - templateName.length()-2);
            String space2 = addSpace(dataType.length() - dataTypeName.length());
            String space3 = addSpace(method.length() - methodName.length()-1);
            String space4 = addSpace(url.length() - urlName.length()-5);
            String space5 = addSpace(result.length() - resultName.length()-3);
            String space6 = addSpace(documentUrl.length() - documentUrlName.length()-4);
            sb.append("|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\r\n");
            sb.append("|  "+requestNameName+space0+"  |  "+templateName+space1+"|  "+dataTypeName+space2+"|  "+methodName+space3+"|  "+urlName+space4+"  |  "+resultName+space5+"  |  "+documentUrlName+space6+"  |"+"\r\n");

        });
        sb.append("————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————"+"\r\n");
        log.info(sb.toString());

    }

    //智能信息基础版/智能信息基础版发送#查询智能信息基础版发送任务 成功
    @Test
    public void smartSmsGet () {
        ModelKMActuator<SmartSmsGetResult,SmartSmsGetTemplate> kooMessageActuator = new ModelKMActuator();
        ResponseBody<SmartSmsGetResult> result = kooMessageActuator.request(new KooMessageService<SmartSmsGetResult, SmartSmsGetTemplate>() {
            @Override
            public SmartSmsGetTemplate convertData() {
                SmartSmsGetTemplate smartSmsGetTemplate = new SmartSmsGetTemplate();
                smartSmsGetTemplate.setTask_id("a6067e45-2203-4432-98d2-b9a5de4aed48");
                smartSmsGetTemplate.setTask_name("测试-长城");
                return smartSmsGetTemplate;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData().getMessage());
    }

    //智能信息基础版/智能信息基础版发送#查询智能信息基础版发送任务 成功
    @Test
    public void smartSmsGet2 () {
        StringKMActuator<SmartSmsGetTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsGetTemplate>() {
            @Override
            public SmartSmsGetTemplate convertData() {
                SmartSmsGetTemplate smartSmsGetTemplate = new SmartSmsGetTemplate();
                //smartSmsGetTemplate.setTask_id("a6067e45-2203-4432-98d2-b9a5de4aed48");
                //smartSmsGetTemplate.setTask_name("测试-长城");
                return smartSmsGetTemplate;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息基础版/创建智能信息基础版模板#查看基础类模板 成功
    @Test
    public void smartSmsTemplatesGet () {
        KMActuator<String,SmartSmsTemplatesGetTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsGetResult> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsTemplatesGetTemplate>() {
            @Override
            public SmartSmsTemplatesGetTemplate convertData() {
                SmartSmsTemplatesGetTemplate smartSmsTemplatesGetTemplate = new SmartSmsTemplatesGetTemplate();
                smartSmsTemplatesGetTemplate.setLimit(1);
                smartSmsTemplatesGetTemplate.setOffset(1);
                smartSmsTemplatesGetTemplate.setTpl_type("private");
                return smartSmsTemplatesGetTemplate;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());

    }

    //智能信息基础版/创建智能信息基础版模板#创建图片短信 失败 对方服务器返回：500
    @Test
    public void smartSmsTemplatesPicture () {
        StringKMActuator<SmartSmsTemplatesCreateTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsTemplatesCreateTemplate> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsTemplatesCreateTemplate>() {
            @Override
            public SmartSmsTemplatesCreateTemplate convertData() {
                SmartSmsTemplatesCreateTemplate template = new SmartSmsTemplatesCreateTemplate();
                Reslist reslist = new Reslist();
                template.setTpl_name("测试-图片短信");
                template.setTitle("测试-图片短信标题");
                template.setExpiration_time(10);
                template.setRemarks("备注信息测试");
                template.setCallbackurl("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=2&spn=0&di=7136437450519347201&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2629382788%2C1187737269&os=2732548242%2C2484883904&simid=4131166295%2C673822061&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%9B%BE%E7%89%87&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F1208%2F0759%2Fbizhi-0759-8796.jpg%26refer%3Dhttp%3A%2F%2Fimg2.niutuku.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Dauto%3Fsec%3D1667119091%26t%3Daad6d3d1fd83f46268fc6897bf29c088&fromurl=ippr_z2C%24qAzdH3FAzdH3Fgt7p7h7_z%26e3Bv54AzdH3FktzitAzdH3F8nnldAzdH3Fdm9mlb_z%26e3Bfip4s&gsm=300000000000003&islist=&querylist=&dyTabStr=MCwzLDYsMSw0LDUsMiw3LDgsOQ%3D%3D");
                reslist.setContent("【华为云】测试-bilibili周年庆钜惠最后12小时！超多红包神券等你来，下单还有机会赢iphone13等实物大奖！https://b23.tv/lXD9FTS");
                reslist.setName("KM1234.png");
                reslist.setSource("file");
                reslist.setType("png");
                template.setReslist(new Reslist[]{reslist});
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息基础版/创建智能信息基础版模板#创建视频短信 失败 对方服务器返回：500
    @Test
    public void smartSmsTemplatesVideo () {
        StringKMActuator<SmartSmsTemplatesCreateTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsTemplatesCreateTemplate> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsTemplatesCreateTemplate>() {
            @Override
            public SmartSmsTemplatesCreateTemplate convertData() {
                SmartSmsTemplatesCreateTemplate template = new SmartSmsTemplatesCreateTemplate();
                Reslist reslist = new Reslist();
                template.setTpl_name("测试-视频短信");
                template.setTitle("测试-视频短信");
                template.setExpiration_time(10);
                template.setRemarks("");
                template.setCallbackurl("");
                template.setReslist(new Reslist[]{reslist});
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-企业管理-上传营业执照 失败 文档没有参数
    @Test
    public void businessLicense () {
        StringKMActuator<BusinessLicenseTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<BusinessLicenseTemplate> result = kooMessageActuator.request(new KooMessageService<String, BusinessLicenseTemplate>() {
            @Override
            public BusinessLicenseTemplate convertData() {
                BusinessLicenseTemplate template = new BusinessLicenseTemplate();
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-企业管理-创建服务号 失败 文档没有参数
    @Test
    public void createEnterpriseFiling () {
        StringKMActuator<CreateEnterpriseFilingTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<CreateEnterpriseFilingTemplate> result = kooMessageActuator.request(new KooMessageService<String, CreateEnterpriseFilingTemplate>() {
            @Override
            public CreateEnterpriseFilingTemplate convertData() {
                CreateEnterpriseFilingTemplate template = new CreateEnterpriseFilingTemplate();
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-企业管理-查询企业信息 失败 文档没有参数
    @Test
    public void FindEnterpriseFiling () {
        StringKMActuator<FindEnterpriseFilingTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<CreateEnterpriseFilingTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindEnterpriseFilingTemplate>() {
            @Override
            public FindEnterpriseFilingTemplate convertData() {
                FindEnterpriseFilingTemplate template = new FindEnterpriseFilingTemplate();
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-查看服务号配置-查询服务号列表 成功
    @Test
    public void findServiceNo () {
        StringKMActuator<FindServiceNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindServiceNoTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindServiceNoTemplate>() {
            @Override
            public FindServiceNoTemplate convertData() {
                FindServiceNoTemplate template = new FindServiceNoTemplate();
                template.setLimit(1);
                template.setOffset(1);
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-查看服务号配置-查询服务号主页列表 成功
    @Test
    public void findServicePage () {
        StringKMActuator<FindServicePageTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindServicePageTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindServicePageTemplate>() {
            @Override
            public FindServicePageTemplate convertData() {
                FindServicePageTemplate template = new FindServicePageTemplate();
                template.setLimit(1);
                template.setOffset(1);
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-查看服务号配置-查询服务号主页菜单列表 成功
    @Test
    public void findServiceMenu () {
        StringKMActuator<FindServiceMenuTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindServiceMenuTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindServiceMenuTemplate>() {
            @Override
            public FindServiceMenuTemplate convertData() {
                FindServiceMenuTemplate template = new FindServiceMenuTemplate();
                template.setLimit(1);
                template.setOffset(1);
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-03-服务号审批-催审-服务号主页催审 成功
    @Test
    public void FindServicePageExamination () {
        StringKMActuator<FindServicePageExaminationTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindServicePageExaminationTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindServicePageExaminationTemplate>() {
            @Override
            public FindServicePageExaminationTemplate convertData() {
                FindServicePageExaminationTemplate template = new FindServicePageExaminationTemplate("ae3affff624147c09c813a553a6a971a");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-03-服务号审批-催审-服务号菜单催审 成功
    @Test
    public void FindServiceMenuExamination () {
        StringKMActuator<FindServiceMenuExaminationTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindServicePageExaminationTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindServiceMenuExaminationTemplate>() {
            @Override
            public FindServiceMenuExaminationTemplate convertData() {
                FindServiceMenuExaminationTemplate template = new FindServiceMenuExaminationTemplate("012c03422c7941ab9ee6a49f2fee1f8e");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-服务号信息更改-冻结服务号 成功
    @Test
    public void FreezeServiceNo () {
        StringKMActuator<FreezeServiceNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FreezeServiceNoTemplate> result = kooMessageActuator.request(new KooMessageService<String, FreezeServiceNoTemplate>() {
            @Override
            public FreezeServiceNoTemplate convertData() {
                FreezeServiceNoTemplate template = new FreezeServiceNoTemplate("8fba8d3f4c4245c9b70f00041aa0aba4","服务号冻结原因");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-服务号信息更改-解冻服务号 成功
    @Test
    public void UnFreezeServiceNo () {
        StringKMActuator<UnFreezeServiceNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<UnFreezeServiceNoTemplate> result = kooMessageActuator.request(new KooMessageService<String, UnFreezeServiceNoTemplate>() {
            @Override
            public UnFreezeServiceNoTemplate convertData() {
                UnFreezeServiceNoTemplate template = new UnFreezeServiceNoTemplate("8fba8d3f4c4245c9b70f00041aa0aba4","服务号冻结原因");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-绑定通道号-查询通道号列表 成功
    @Test
    public void FindChannelNo () {
        ResponseBody<DeleteChannelNoTemplate> result =
                new StringKMActuator().request(
                        new KooMessageService<String, FindChannelNoTemplate>() {
                            @Override
                            public FindChannelNoTemplate convertData() {
                                FindChannelNoTemplate template = new FindChannelNoTemplate();
                                template.setLimit(1);
                                return template;
                            }
                        }
                        ).execute()
                        .then(new ThenKooMessageService<String, FindCollideTemplate>() {
                            @Override
                            public FindCollideTemplate convertData(ResponseBody responseBody) {
                                System.out.println("responseBody1:  "+responseBody.getData());
                                FindCollideTemplate template = new FindCollideTemplate(new String[]{"15387053464"});
                                return template;
                            }
                        })
                        .then(new ThenKooMessageService<String, FindCollideTemplate>() {
                            @Override
                            public FindCollideTemplate convertData(ResponseBody responseBody) {
                                System.out.println("responseBody2:  "+responseBody.getData());
                                FindCollideTemplate template = new FindCollideTemplate(new String[]{"15387053464"});
                                return template;
                            }
                        })
                        .result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-绑定通道号-删除通道号列表 成功
    @Test
    public void DeleteChannelNo () {
        StringKMActuator<DeleteChannelNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<DeleteChannelNoTemplate> result = kooMessageActuator.request(new KooMessageService<String, DeleteChannelNoTemplate>() {
            @Override
            public DeleteChannelNoTemplate convertData() {
                DeleteChannelNoTemplate template = new DeleteChannelNoTemplate("63163d5452134de9be591c811ec0246c");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息服务号-绑定通道号-注册通道号 成功
    @Test
    public void RegisterChannelNo () {
        StringKMActuator<RegisterChannelNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<RegisterChannelNoTemplate> result = kooMessageActuator.request(new KooMessageService<String, RegisterChannelNoTemplate>() {
            @Override
            public RegisterChannelNoTemplate convertData() {
                RegisterChannelNoTemplate template = new RegisterChannelNoTemplate("3",new String[]{"通道号签名测试3"},1,1,new String[]{"f45d05c587284aa2b7d14e994e476bf8:AimSauploadService/7b962751d1a340e39d4086d345391595智能信息业务签名授权函.PNG"});
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }
    //智能信息服务号-绑定通道号-通道号绑定服务号 成功
    @Test
    public void BindChannelNo () {
        StringKMActuator<BindChannelToServiceNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<BindChannelToServiceNoTemplate> result = kooMessageActuator.request(new KooMessageService<String, BindChannelToServiceNoTemplate>() {
            @Override
            public BindChannelToServiceNoTemplate convertData() {
                BindChannelToServiceNoTemplate template = new BindChannelToServiceNoTemplate("f23ac3e698d7407f9bbbf38d7b055bfb","3",new String[]{"通道号签名测试3"},"陕西省");
                template.setMerchant_id("2b57a7b50709446ab25401567c1dbff1");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }
    //智能信息服务号-绑定通道号-通道号解绑服务号 成功
    @Test
    public void UnBindChannelNo () {
        StringKMActuator<UnBindChannelToServiceNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<UnBindChannelToServiceNoTemplate> result = kooMessageActuator.request(new KooMessageService<String, UnBindChannelToServiceNoTemplate>() {
            @Override
            public UnBindChannelToServiceNoTemplate convertData() {
                UnBindChannelToServiceNoTemplate template = new UnBindChannelToServiceNoTemplate("b7e67a1935524f439019b4e874f186c7");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息/01-AIM场景-客户使用华为通道/撞库测试 成功
    @Test
    public void FindCollide () {
        StringKMActuator<FindCollideTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindCollideTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindCollideTemplate>() {
            @Override
            public FindCollideTemplate convertData() {
                FindCollideTemplate template = new FindCollideTemplate(new String[]{"15387053464"});
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/创建个人模板 成功
    @Test
    public void PersonalTemplate () {
        StringKMActuator<PersonalTemplateTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<PersonalTemplateTemplate> result = kooMessageActuator.request(new KooMessageService<String, PersonalTemplateTemplate>() {
            @Override
            public PersonalTemplateTemplate convertData() {
                PersonalTemplateFactoryContent page1 = new PersonalTemplateFactoryContent("text",1);
                page1.setContent("测试乘车路线");
                page1.setIs_text_title("false");
                PersonalTemplateFactoryContent page2 = new PersonalTemplateFactoryContent("text",2);
                page2.setContent("北京-深圳");
                page2.setIs_text_title("false");
                PersonalTemplateFactoryContent page3 = new PersonalTemplateFactoryContent("text",3);
                page3.setContent("测试乘车时间");
                page3.setIs_text_title("false");
                PersonalTemplateFactoryContent page4 = new PersonalTemplateFactoryContent("text",4);
                page4.setContent("2020年12月31日 18:00");
                page4.setIs_text_title("false");
                PersonalTemplateFactoryContent page5 = new PersonalTemplateFactoryContent("text",5);
                page5.setContent("测试行程单号");
                page5.setIs_text_title("false");
                PersonalTemplateFactoryContent page6 = new PersonalTemplateFactoryContent("text",6);
                page6.setContent("1364000000000001");
                page6.setIs_text_title("false");
                PersonalTemplateFactoryContent page7 = new PersonalTemplateFactoryContent("button",7);
                page7.setContent("测试地铁路线");
                PersonalTemplateFactoryContentAction action1 = new PersonalTemplateFactoryContentAction("https://www.xxxx.com");
                page7.setAction(action1);
                page7.setAction_type("OPEN_URL");
                PersonalTemplateFactoryContent page8 = new PersonalTemplateFactoryContent("button",8);
                page8.setContent("测试查看详情");
                PersonalTemplateFactoryContentAction action2 = new PersonalTemplateFactoryContentAction("https://www.xxxx.com");
                page8.setAction(action2);
                page8.setAction_type("OPEN_URL");
                PersonalTemplateFactoryContent page9 = new PersonalTemplateFactoryContent("image",9);
                page8.setContent("测试查看详情");
                PersonalTemplateFactoryContentAction action3 = new PersonalTemplateFactoryContentAction("https://www.xxxx.com");
                page9.setAction(action3);
                page9.setAction_type("OPEN_URL");
                page9.setSrc("720500945179422721");
                page9.setSrc_type(1);



                PersonalTemplatePage personalTemplatePage = new PersonalTemplatePage(1,new PersonalTemplateFactoryContent[]{page1,page2,page3,page4,page5,page6,page7,page8,page9});
                PersonalTemplateTemplate template = new PersonalTemplateTemplate("Notification1",2,"测试购票通知模板",new PersonalTemplatePage[]{personalTemplatePage});
                template.setScene("测试乘车购票通知");
                template.setSms_example("测试订票成功！请查看");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/上传模板素材（缩略图、视频、图片） 成功
    @Test
    public void Material () {
        StringKMActuator<UploadMaterialTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<UploadMaterialTemplate> result = kooMessageActuator.request(new KooMessageService<String, UploadMaterialTemplate>() {
            @Override
            public UploadMaterialTemplate convertData() {
                UploadMaterialTemplate template = new UploadMaterialTemplate("image","url");
                template.setImage_rate("oneToOne");
                template.setFile_name("uploadMaterial.jpeg");
                template.setFile_url("");
                template.setDescription("描述信息");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/查询模板素材（视频） 成功
    @Test
    public void FindMaterialVideo () {
        StringKMActuator<FindMaterialTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindMaterialTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindMaterialTemplate>() {
            @Override
            public FindMaterialTemplate convertData() {
                FindMaterialTemplate template = new FindMaterialTemplate("video",1,1);

                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/查询模板素材（图片） 成功
    @Test
    public void FindMaterialImage () {
        StringKMActuator<FindMaterialTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindMaterialTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindMaterialTemplate>() {
            @Override
            public FindMaterialTemplate convertData() {
                FindMaterialTemplate template = new FindMaterialTemplate("image",1,10);
                template.setFile_name("uploadMaterial.jpeg");

                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/删除模板素材（图片） 成功
    @Test
    public void DeleteMaterialImage () {
        StringKMActuator<DeleteMaterialTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<DeleteMaterialTemplate> result = kooMessageActuator.request(new KooMessageService<String, DeleteMaterialTemplate>() {
            @Override
            public DeleteMaterialTemplate convertData() {
                DeleteMaterialTemplate template = new DeleteMaterialTemplate(new String[]{"c08fff7f-0837-4e2e-80eb-765080c165e2"});

                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/查询个人模板 成功
    @Test
    public void FindTemplate () {
        StringKMActuator<FindPersonalTemplateTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<FindPersonalTemplateTemplate> result = kooMessageActuator.request(new KooMessageService<String, FindPersonalTemplateTemplate>() {
            @Override
            public FindPersonalTemplateTemplate convertData() {
                FindPersonalTemplateTemplate template = new FindPersonalTemplateTemplate(1,10);
                //template.setTpl_id("600141515");
                //template.setTpl_name("XX中秋-测试");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }
    //智能信息/AIM场景-客户使用华为通道/创建智能信息个人模板/删除个人模板 成功
    @Test
    public void DeleteTemplate () {
        StringKMActuator<DeletePersonalTemplateTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<DeletePersonalTemplateTemplate> result = kooMessageActuator.request(new KooMessageService<String, DeletePersonalTemplateTemplate>() {
            @Override
            public DeletePersonalTemplateTemplate convertData() {
                DeletePersonalTemplateTemplate template = new DeletePersonalTemplateTemplate("600141520");
                //template.setTpl_id("600110099");
                //template.setTpl_name("XX中秋-测试");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //查询智能信息发送明细 成功
    @Test
    public void SmartSmsGetDetails () {
        StringKMActuator<SmartSmsGetDetailsTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsGetDetailsTemplate> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsGetDetailsTemplate>() {
            @Override
            public SmartSmsGetDetailsTemplate convertData() {
                SmartSmsGetDetailsTemplate template = new SmartSmsGetDetailsTemplate(1,10);
                //template.setTpl_id("600110099");
                //template.setTpl_name("XX中秋-测试");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //查询智能信息发送报表 成功
    @Test
    public void SmartSmsGetReports () {
        StringKMActuator<SmartSmsGetReportsTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsGetReportsTemplate> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsGetReportsTemplate>() {
            @Override
            public SmartSmsGetReportsTemplate convertData() {
                SmartSmsGetReportsTemplate template = new SmartSmsGetReportsTemplate("2");
                //template.setTpl_id("600110099");
                //template.setTpl_name("XX中秋-测试");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //注册智能信息回执URL 成功
    @Test
    public void RegisterSmartSmsURL () {
        StringKMActuator<SmartSmsURLTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsURLTemplate> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsURLTemplate>() {
            @Override
            public SmartSmsURLTemplate convertData() {
                SmartSmsURLTemplate template = new SmartSmsURLTemplate("");
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }

    //查询解析任务 成功
    @Test
    public void SmartSmsResolve () {
        StringKMActuator<SmartSmsResolveTasksTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsResolveTasksTemplate> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsResolveTasksTemplate>() {
            @Override
            public SmartSmsResolveTasksTemplate convertData() {
                SmartSmsResolveTasksTemplate template = new SmartSmsResolveTasksTemplate();
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());
    }
    //查询解析明细 成功
    @Test
    public void SmartSmsResolveDetails () {
        StringKMActuator<SmartSmsResolveDetailsTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsResolveTasksTemplate> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsResolveDetailsTemplate>() {
            @Override
            public SmartSmsResolveDetailsTemplate convertData() {
                SmartSmsResolveDetailsTemplate template = new SmartSmsResolveDetailsTemplate(1,10);
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result.getData());


        StringKMActuator<SmartSmsResolveDetailsTemplate> kooMessageActuator2 = new StringKMActuator();
        ResponseBody<SmartSmsResolveTasksTemplate> result2 = kooMessageActuator.request(new KooMessageService<String, SmartSmsResolveDetailsTemplate>() {
            @Override
            public SmartSmsResolveDetailsTemplate convertData() {
                SmartSmsResolveDetailsTemplate template = new SmartSmsResolveDetailsTemplate(1,10);
                return template;
            }
        }).execute().result();
        System.out.println("result:  "+result2.getData());
    }

    //生成解析任务 成功
    @Test
    public void SmartSmsResolveAnalysis(){
        StringKMActuator<SmartSmsResolveAnalysisTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, SmartSmsResolveAnalysisTemplate>() {
                    @Override
                    public SmartSmsResolveAnalysisTemplate convertData() {

                        CreateResolveTaskParam createResolveTaskParam = new CreateResolveTaskParam("15387053464");
                        SmartSmsResolveAnalysisTemplate template = new SmartSmsResolveAnalysisTemplate("600110099",new String[]{"XX"},1,"individual",1,new CreateResolveTaskParam[]{createResolveTaskParam});
                        return template;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getData());
    }

    //修改智能信息服务号菜单 成功
    @Test
    public void EditServiceMenu(){
        StringKMActuator<EditServiceMenuTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, EditServiceMenuTemplate>() {
                    @Override
                    public EditServiceMenuTemplate convertData() {
                        MenuItem menuItems = new MenuItem("OPEN_URL","子菜单名称");
                        Menus menu = new Menus(new MenuItem[]{menuItems});
                        EditServiceMenuTemplate template = new EditServiceMenuTemplate("600110099","说明",menu);
                        return template;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getData());
    }

    //更新服务号信息 成功
    @Test
    public void UpdateServiceNo(){
        StringKMActuator<UpdateServiceNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, UpdateServiceNoTemplate>() {
                    @Override
                    public UpdateServiceNoTemplate convertData() {
                        UpdateServiceNoTemplate template = new UpdateServiceNoTemplate("600110099","说明","服务号介绍。。。。");
                        return template;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getData());
    }

    //更新服务号主页 成功
    @Test
    public void EditServicePage(){
        StringKMActuator<EditServicePageTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, EditServicePageTemplate>() {
                    @Override
                    public EditServicePageTemplate convertData() {
                        EditServicePageTemplate template = new EditServicePageTemplate("600110099","修改原因。");
                        return template;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getData());
    }

    //一站式创建服务号
    @Test
    public void CreateServiceNo(){
        StringKMActuator<CreateServiceNoTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, CreateServiceNoTemplate>() {
                    @Override
                    public CreateServiceNoTemplate convertData() {
                        PubCreateRequestBody pub_request_body = new PubCreateRequestBody("cecea7b5e1c24b4a85175e432ec1d5cb","服务号名称","服务号摘要",new String[]{"9cb72cd69d554a80a3792cacff8c1393"});
                        PortalRequestBody portal_request_body = new PortalRequestBody("9fb388d956a4477595176e122c28198a","主页简介");
                        MenuItem menuItem = new MenuItem("OPEN_URL","打开商城");
                        menuItem.setContent("https://support.huaweicloud.com/api-KooMessage/CreatePubInfo.html");
                        Menus menus = new Menus(new MenuItem[]{menuItem});
                        MenuRequestBody menu_request_body = new MenuRequestBody(menus);
                        CreateServiceNoTemplate template = new CreateServiceNoTemplate(pub_request_body,portal_request_body,menu_request_body);
                        return template;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getData());
    }

    /**
     * 上传智能信息服务号图片资源 成功
     * PUB_LOGO：上传服务号LOGO
     *
     * BG_IMAGE：上传服务号主页背景图
     *
     * FASTAPP_LOGO：上传快应用LOGO
     *
     * OTHER：上传授权证明和营业执照等
     */

    @Test
    public void UploadServiceNoResource(){
        StringKMActuator<UploadServiceNoResourceTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<String> result = kooMessageActuator.request(new KooMessageService<String, UploadServiceNoResourceTemplate>() {
                    @Override
                    public UploadServiceNoResourceTemplate convertData() {
                        UploadServiceNoResourceTemplate template = new UploadServiceNoResourceTemplate(new File("C:\\Users\\v-feiwanga\\Desktop\\kooMessage\\uploadMaterial.jpeg"),"PUB_LOGO");
                        return template;
                    }
                })
                .execute()
                .result();
        System.out.println("result:  "+result.getStatus());
        System.out.println("result:  "+result.getData());
    }

    /**
     * 推荐的标准写法 这样写执行效率更快 内存占有率低很多很多
     */
    @Autowired
    private SmartSmsGetTemplateServiceImpl smartSmsGetTemplateServiceImpl;
    @Test
    public void smartSmsGet22 () {
        StringKMActuator<SmartSmsGetTemplate> kooMessageActuator = new StringKMActuator();
        ResponseBody<SmartSmsGetResult> result = kooMessageActuator.
                request(smartSmsGetTemplateServiceImpl).
                execute().
                result();
        System.out.println("result:  "+result.getData().getMessage());
    }
}


