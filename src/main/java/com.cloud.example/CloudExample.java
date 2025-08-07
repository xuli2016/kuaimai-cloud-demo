package com.cloud.example;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.kuaimai.core.bean.ResponseEnvelope;
import com.kuaimai.core.client.KuaimaiClient;
import com.kuaimai.core.request.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuli
 * @Date: 2021-07-20 15:36
 */
public class CloudExample {

    public final static String accessKey="快麦开放平台申请的appid";
    public final static String secret="快麦开放平台申请的secret";
    private static String testSn="打印机的序列号";

    public static void main(String[] args) throws Exception{
        KuaimaiClient kuaimaiClient=KuaimaiClient.createClient(accessKey,secret);

        /**
         * 以下函数可以对照https://cloudprint.kuaimai.com/#/openDev文档中查看参数含义
         */

        /**绑定设备
        BindDeviceRequest bindDeviceRequest=new BindDeviceRequest();
        bindDeviceRequest.setSn(testSn);
        bindDeviceRequest.setDeviceKey("123456");
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(bindDeviceRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        /**查询设备状态
         QueryDeviceStatusRequest queryDeviceStatusRequest=new QueryDeviceStatusRequest();
         JSONArray array=new JSONArray();
         array.add(testSn);
         queryDeviceStatusRequest.setSns(array.toString());
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(queryDeviceStatusRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /** 小票模板-连续纸打印
         EscTemplatePrintRequest escTemplatePrintRequest=new EscTemplatePrintRequest();
         escTemplatePrintRequest.setSn(testSn);
         escTemplatePrintRequest.setTemplateId(1634960019L);
         escTemplatePrintRequest.setRenderData("{\"table_test\":[{\"key_test\":\"3449394\"}]}");
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(escTemplatePrintRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /** 标签模板-间隙纸打印
         TsplTemplatePrintRequest tsplTemplatePrintRequest=new TsplTemplatePrintRequest();
         tsplTemplatePrintRequest.setSn(testSn);
         tsplTemplatePrintRequest.setTemplateId(1634981612L);
         tsplTemplatePrintRequest.setRenderDataArray("[{\"table_test\":[{\"key_test\":\"3449394\"}]}]");
         tsplTemplatePrintRequest.setPrintTimes(1);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplTemplatePrintRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /** 小票模板-间隙纸打印
        TsplTemplateWriteRequest tsplTemplateWriteRequest=new TsplTemplateWriteRequest();
        tsplTemplateWriteRequest.setSn(testSn);
        tsplTemplateWriteRequest.setTemplateId(1634960019L);

        String renderData="{\"table_test\":[{\"key_test\":\"3449394\"}]}";
        tsplTemplateWriteRequest.setRenderData(renderData);
        tsplTemplateWriteRequest.setPrintTimes(2);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplTemplateWriteRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /**自定义xml-间隙纸打印
        TsplXmlWriteRequest tsplXmlWriteRequest=new TsplXmlWriteRequest();
        tsplXmlWriteRequest.setSn(testSn);
        tsplXmlWriteRequest.setXmlStr("<page><render><t>hello,word</t></render></page>");
        tsplXmlWriteRequest.setPrintTimes(1);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplXmlWriteRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/



        /**自定义xml-连续纸打印
         EscXmlWriteRequest escXmlWriteRequest=new EscXmlWriteRequest();
         escXmlWriteRequest.setSn(testSn);
         escXmlWriteRequest.setInstructions("<page><render><t size='01' feed='9'>hello,word</t></render></page>");
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(escXmlWriteRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/



        /**打印结果查询, 打印结果也可以在注册后台配置打印回调地址，通过推送的形式获取
         ResultRequest resultRequest=new ResultRequest();
         resultRequest.setSn(testSn);
         JSONArray jsonArray=new JSONArray();
         jsonArray.add("1718335259087");
         resultRequest.setJobIds(jsonArray);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(resultRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /**图片直接打印（间隙纸)
        TsplImageRequest tsplImageRequest=new TsplImageRequest();
        tsplImageRequest.setSn(testSn);
        tsplImageRequest.setImageBase64("data:image/png;base64,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");
        tsplImageRequest.setPrintTimes(1);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplImageRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        /**语言播报
        BroadcastRequest broadcastRequest=new BroadcastRequest();
        broadcastRequest.setSn(testSn);
        broadcastRequest.setVolume(80);
        broadcastRequest.setVolumeContent("测试语言播报");
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(broadcastRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse)); **/

        /**取消打印任务
        CancelJobRequest cancelJobRequest=new CancelJobRequest();
        cancelJobRequest.setSn(testSn);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(cancelJobRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        /**解绑设备
        UnbindDeviceRequest unbindDeviceRequest=new UnbindDeviceRequest();
        unbindDeviceRequest.setSn(testSn);
        unbindDeviceRequest.setDeviceKey("123456");
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(unbindDeviceRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        /**调节设备浓度，打印默认浓度值为8，浓度调节范围为1-15；支持机型为:KM118系列，KME31系列，KME41系列； 支持在标签模式（自检页中指令：tspl）下调节浓度
        AdjustDeviceDensityRequest  adjustDeviceDensityRequest = new AdjustDeviceDensityRequest();
        adjustDeviceDensityRequest.setSn(testSn);
        adjustDeviceDensityRequest.setDensity(8);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(adjustDeviceDensityRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        /********云打印KM360C专用start********/

        //1.KM360C获取云打印机code,code有效期时间为5分钟**/
        /**GetCainiaoCodeRequest getCainiaoCodeRequest = new GetCainiaoCodeRequest();
        getCainiaoCodeRequest.setImei("1233");
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(getCainiaoCodeRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        //2.KM360C绑定云打印机
        /**CainiaoBindRequest cainiaoBindRequest = new CainiaoBindRequest();
        cainiaoBindRequest.setImei("123");
        cainiaoBindRequest.setCode("0597");
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(cainiaoBindRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        //3.KM360C图片打印**/
        /**CainiaoPrintRequest cainiaoPrintRequest = new CainiaoPrintRequest();
        cainiaoPrintRequest.setImei("1234");
        cainiaoPrintRequest.setImageBase64Data("data:image/png;base64,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");
        ResponseEnvelope acsResponse =kuaimaiClient.getAcsResponse(cainiaoPrintRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));

         //KM360C云打印机标签模板-间隙纸打印
         TsplTemplatePrintRequest tsplTemplatePrintRequest=new TsplTemplatePrintRequest();
         tsplTemplatePrintRequest.setImei("123");
         tsplTemplatePrintRequest.setTemplateId(1634959702L);
         tsplTemplatePrintRequest.setRenderDataArray("[{\"table_test\":[{\"key_test\":\"3449394\"}]}]");
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplTemplatePrintRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        /********云打印KM360C专用end********/
    }


}
