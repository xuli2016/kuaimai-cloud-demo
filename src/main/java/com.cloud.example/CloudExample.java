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
         * 以下函数可以对照https://cloudprint.kuaimai.com/#/openDev，http协议对接文档部分说明使用
         */

        /**绑定设备
        BindDeviceRequest bindDeviceRequest=new BindDeviceRequest();
        bindDeviceRequest.setSn(testSn);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(bindDeviceRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

        /**查询设备是否存在
         QueryDeviceExistRequest queryDeviceExistRequest=new QueryDeviceExistRequest();
         queryDeviceExistRequest.setSn(testSn);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(queryDeviceExistRequest);
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
         tsplTemplatePrintRequest.setTemplateId(1634959702L);
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
        tsplXmlWriteRequest.setPrintTimes(2);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplXmlWriteRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));
         **/


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
         System.out.println(JSONUtil.toJsonStr(acsResponse));
         **/

        /**图片直接打印（间隙纸)
        TsplImageRequest tsplImageRequest=new TsplImageRequest();
        tsplImageRequest.setSn(testSn);
        tsplImageRequest.setImageBase64("data:image/png;base64,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IAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQgAAEIQAACEIAABCAAAQhAAAIQgAAEIAABCEAAAhCAAAQg4Efg/wOUiz7H4nlhPwAAAABJRU5ErkJggg==");
        tsplImageRequest.setPrintTimes(1);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplImageRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));**/

    }


}
