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
         tsplTemplatePrintRequest.setPrintTimes(2);
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



        /**打印结果查询
         ResultRequest resultRequest=new ResultRequest();
         resultRequest.setSn(testSn);
         JSONArray jsonArray=new JSONArray();
         jsonArray.add("1718335259087");
         resultRequest.setJobIds(jsonArray);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(resultRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));
         **/



    }


}
