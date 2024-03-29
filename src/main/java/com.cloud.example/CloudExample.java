package com.cloud.example;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.kuaimai.core.bean.ResponseEnvelope;
import com.kuaimai.core.client.KuaimaiClient;
import com.kuaimai.core.request.BindDeviceRequest;
import com.kuaimai.core.request.QueryDeviceStatusRequest;

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

        /**绑定设备 **/
        BindDeviceRequest bindDeviceRequest=new BindDeviceRequest();
        bindDeviceRequest.setSn(testSn);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(bindDeviceRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));

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


        /** 小票模板esc打印
         EscTemplatePrintRequest escTemplatePrintRequest=new EscTemplatePrintRequest();
         escTemplatePrintRequest.setSn(testSn);
         escTemplatePrintRequest.setTemplateId(111L);
         escTemplatePrintRequest.setType(2);
         JSONObject renderDataJson=new JSONObject();
         JSONArray jsonArray=new JSONArray();
         JSONObject jsonObject=new JSONObject();
         jsonObject.put("key_test","3449394");
         jsonArray.add(jsonObject);
         renderDataJson.put("table_test",jsonArray);
         escTemplatePrintRequest.setRenderDataJson(renderDataJson);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(escTemplatePrintRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /** 标签模板tspl打印
         TsplTemplatePrintRequest tsplTemplatePrintRequest=new TsplTemplatePrintRequest();
         tsplTemplatePrintRequest.setSn(testSn);
         tsplTemplatePrintRequest.setTemplateId(111L);

         JSONArray renderDataJsonArray=new JSONArray();
         JSONObject renderDataJson=new JSONObject();
         JSONArray jsonArray=new JSONArray();
         JSONObject jsonObject=new JSONObject();
         jsonObject.put("key_test","3449394");
         jsonArray.add(jsonObject);
         renderDataJson.put("table_test",jsonArray);
         renderDataJsonArray.add(renderDataJson);
         tsplTemplatePrintRequest.setRenderDataJsonArray(renderDataJsonArray);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplTemplatePrintRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /** 小票模板tspl打印
        TsplTemplateWriteRequest tsplTemplateWriteRequest=new TsplTemplateWriteRequest();
        tsplTemplateWriteRequest.setSn(testSn);
        tsplTemplateWriteRequest.setTemplateId(111L);

        JSONObject renderDataJson=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("key_test","3449394");
        jsonArray.add(jsonObject);
        renderDataJson.put("table_test",jsonArray);
        tsplTemplateWriteRequest.setRenderDataJson(renderDataJson);
        ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplTemplatePrintRequest);
        System.out.println(JSONUtil.toJsonStr(acsResponse));
         **/

        /**esc打印(小票机）
         EscInstructRequest escInstructRequest=new EscInstructRequest();
         escInstructRequest.setSn(testSn);
         String instructions="H3MCAAAAAAD/AAAdIQAbYQG687P4waoNCiM0IMPAzcXN4sL0DQodIQAbYQC2qbWlusWjujkwODg5NzMxNDAzMDc2Mzc0DQ" +
         "rPwrWlyrG85DoyMDIxLTA0LTA2IDIxOjU3OjUzDQrG2s37y8207zrBory0y8207w0KHSEBHSEBHSEAG0UBLS0tLS0tLS0tLS0tMbrFv9q0/C0tLS0tLS0tLS0tLQ0KHSEBG0UA0eC9yCi8prmr7NLPtcHQ16jK9CkNCiAgICAgICAgICAgICAgocExICA" +
         "gICAgICAgICAgNy4wDQq98NXrub0ovKa5q+zSz7XB0NeoyvQpDQogICAgICAgICAgICAgIKHBMSAgICAgICAgICAgIDYuMA0Kw+a97ii8prmr7NLPtcHQ16jK9CkNCiAgICAgICAgICAgICAgocExICAgICAgICAgICAgNi4wDQq/7bfbKLymuavs0s+1" +
         "wdDXqMr0KQ0KICAgICAgICAgICAgICChwTEgICAgICAgICAgICA2LjANCsj2xPLFo83oKLymuavs0s+1wdDXqMr0KQ0KICAgICAgICAgICAgICChwTEgICAgICAgICAgICA3LjANCsXFucfs0tbQt90ov8nS1LzTssssw9e3udDotaW14ykozqLAsSkgI" +
         "CAgICAgICChwTEgICAgICAgICAgIDU1LjANCg0KHSEAG0UBLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0NChtFAB0hABthAtStvNs6OTMuMA0KyrW4tjo5Mi4wDQoo0tHU2s/f1qe4tikNCg0KDQobZAQ=";
         escInstructRequest.setInstructions(instructions);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(escInstructRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));
         **/
        /**esc自己组装指令打印
         EscInstructRequest escInstructRequest1=new EscInstructRequest();
         escInstructRequest1.setSn(testSn);
         EscInstructCreator escInstructCreator=new EscInstructCreator();
         //添加文本
         escInstructCreator.addText(escInstructCreator,"helloword");
         //添加条形码
         escInstructCreator.addBarcode(escInstructCreator,"12345678");
         //添加二维码
         escInstructCreator.addQrcode(escInstructCreator,"9901text");
         String imgBase64="/9j/4AAQSkZJRgABAQAASABIAAD/4QCMRXhpZgAATU0AKgAAAAgABQESAAMAAAABAAEAAAEaAAUAAAABAAAASgEbAAUAAAABAAAAUgEoAAMAAAABAAIAAIdpAAQAAAABAAAAWgAAAAAAAABIAAAAAQAAAEgAAAABAAOgAQADAAAAAQABAACgAgAEAAAAAQAAACigAwAEAAAAAQAAABsAAAAA/8AAEQgAGwAoAwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/bAEMAAgICAgICAwICAwUDAwMFBgUFBQUGCAYGBgYGCAoICAgICAgKCgoKCgoKCgwMDAwMDA4ODg4ODw8PDw8PDw8PD//bAEMBAgICBAQEBwQEBxALCQsQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEP/dAAQAA//aAAwDAQACEQMRAD8A/n/r93P+CLPhTwxc+IPiT4q1yG1a/wBPsNLs7UzqPMEN7LcSTMokXG1zFGmQeSmD0FfhRAYlmjM4LRhhuA4JXPOPwr9qf+Cf8P7JHxY8RWPwk8Y+HpY9e1vR7KaK4e+uIQ2q6dDcWl1bDDoG+0W7faYVXegPm7djxigD+gJfg78IIdVfxGngrRE1Jvma6GnWwlJ65MmzOeSc5r+XX/gqf4v07xD+1l4l0fS9Pt7K38OW2l6YrwMrCcxW5uTIQigL/wAfXl4yceXyR0H9Bmsfszfs5W/wx0v4A63cak/hvUdTeGC1m8Q3xlmvDauTb7muvMePyY2IthmNSPM8sEF6/nh/4KI6L+zf4P8AjTc+DPgpDPcXOjQyQa5dLdmaKTV2ZTsQncgNug2TqgX5ztPzoxAB+ddFBxniigD/0P5/69c+BvxR1b4N/E/w98RtESN7zQbyO8iWRC6syKyEbQRklHYKMgb9ueM15HRQB/T14w8L+CdG8D3n7ZOm/FLUryeDQhrlp4n36HH4iuhJbeXFpBhOmJbpESV4KmTzCUwK/mq8X+INY8UeJdS17X7v7dqN9cz3FzNhVEk88rSzOAiqoDSuzAAAAHGKxzf3DReURHj+95Sb/rv27s++c1SoAKKKKAP/2Q==";
         //添加图片
         escInstructCreator.addImg(escInstructCreator,imgBase64);
         escInstructCreator.addText(escInstructCreator,"end----",null,null,8);
         escInstructCreator.print(escInstructCreator);
         escInstructRequest1.setInstructions(escInstructCreator.getInstructions());
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(escInstructRequest1);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/



        /**tspl打印（标签，面单机）
         TsplInstructRequest tsplInstructRequest=new TsplInstructRequest();
         tsplInstructRequest.setSn(testSn);
         String instructs="CLS\r\nSIZE 75mm,100mm\r\nTEXT 50,50,\"0\",0,1,1,\"Hello World!\"\r\nPRINT 1\r\n";
         tsplInstructRequest.setInstructs(instructs);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplInstructRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/




        /**tspl打印结果查询（标签，面单机）
         ResultRequest resultRequest=new ResultRequest();
         resultRequest.setSn(testSn);
         JSONArray jsonArray=new JSONArray();
         jsonArray.add("1676539452399");
         resultRequest.setJobIds(jsonArray);
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(resultRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));**/


        /**利用tspl指令构造器打印
         TsplInstructRequest tsplInstructRequest=new TsplInstructRequest();
         tsplInstructRequest.setSn(testSn);
         JSONArray jsonArray=new JSONArray();
         TsplInstructCreator instructCreator=new TsplInstructCreator();
         //设置大小
         instructCreator.setSize(instructCreator,75,100);
         //添加文本
         instructCreator.addText(instructCreator,"1234567",20,10);
         //添加条形码
         instructCreator.addBarcode(instructCreator,"88899",20,30);
         //添加二维码
         instructCreator.addQrcode(instructCreator,"ilovechina",20,170);
         String imgBase64="/9j/4AAQSkZJRgABAQAASABIAAD/4QCMRXhpZgAATU0AKgAAAAgABQESAAMAAAABAAEAAAEaAAUAAAABAAAASgEbAAUAAAABAAAAUgEoAAMAAAABAAIAAIdpAAQAAAABAAAAWgAAAAAAAABIAAAAAQAAAEgAAAABAAOgAQADAAAAAQABAACgAgAEAAAAAQAAACigAwAEAAAAAQAAABsAAAAA/8AAEQgAGwAoAwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/bAEMAAgICAgICAwICAwUDAwMFBgUFBQUGCAYGBgYGCAoICAgICAgKCgoKCgoKCgwMDAwMDA4ODg4ODw8PDw8PDw8PD//bAEMBAgICBAQEBwQEBxALCQsQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEP/dAAQAA//aAAwDAQACEQMRAD8A/n/r93P+CLPhTwxc+IPiT4q1yG1a/wBPsNLs7UzqPMEN7LcSTMokXG1zFGmQeSmD0FfhRAYlmjM4LRhhuA4JXPOPwr9qf+Cf8P7JHxY8RWPwk8Y+HpY9e1vR7KaK4e+uIQ2q6dDcWl1bDDoG+0W7faYVXegPm7djxigD+gJfg78IIdVfxGngrRE1Jvma6GnWwlJ65MmzOeSc5r+XX/gqf4v07xD+1l4l0fS9Pt7K38OW2l6YrwMrCcxW5uTIQigL/wAfXl4yceXyR0H9Bmsfszfs5W/wx0v4A63cak/hvUdTeGC1m8Q3xlmvDauTb7muvMePyY2IthmNSPM8sEF6/nh/4KI6L+zf4P8AjTc+DPgpDPcXOjQyQa5dLdmaKTV2ZTsQncgNug2TqgX5ztPzoxAB+ddFBxniigD/0P5/69c+BvxR1b4N/E/w98RtESN7zQbyO8iWRC6syKyEbQRklHYKMgb9ueM15HRQB/T14w8L+CdG8D3n7ZOm/FLUryeDQhrlp4n36HH4iuhJbeXFpBhOmJbpESV4KmTzCUwK/mq8X+INY8UeJdS17X7v7dqN9cz3FzNhVEk88rSzOAiqoDSuzAAAAHGKxzf3DReURHj+95Sb/rv27s++c1SoAKKKKAP/2Q==";
         //添加图片
         instructCreator.addImg(instructCreator,imgBase64,20,330);
         //添加线框
         instructCreator.addBox(instructCreator,20,400,100,500);
         //添加横线
         instructCreator.addBar(instructCreator,20,510,80,2);
         //添加竖线
         instructCreator.addBar(instructCreator,150,505,2,100);
         //添加圆
         instructCreator.addCircle(instructCreator,20,550);
         //添加椭圆
         instructCreator.addEllipse(instructCreator,20,700);

         tsplInstructRequest.setInstructs(instructCreator.print(tsplInstructRequest,instructCreator));
         ResponseEnvelope acsResponse = kuaimaiClient.getAcsResponse(tsplInstructRequest);
         System.out.println(JSONUtil.toJsonStr(acsResponse));
         **/



        /**EscInstructCreator，组建指令模版示例
         EscInstructCreator creator=new EscInstructCreator();
         creator.addText(creator,"示例模版","11")
         .addText(creator,"店铺名称")
         .addText(creator,"#3 美团外卖")
         .addText(creator,"下单时间：2021-01-10 15:15:15",null,"left")
         .addText(creator,"期望送达：立即送达",null,"left")
         .addText(creator,"-------------------------------",null,"left")
         .addText(creator,"备注：不加辣！不加葱！",null,"left",null,null)
         .addText(creator,"-------------1号袋-------------",null,"left")
         .addText(creator,"米饭",null,"left",0,170).addText(creator,"*1",null,"left",0,310).addText(creator,"0.3",null,"left")
         .addText(creator,"-------------其他--------------")
         .addText(creator,"配送费:",null,"left",0,300).addText(creator,"10.0",null,"left")
         .addText(creator,"餐盒费:",null,"left",0,310).addText(creator,"1.0",null,"left")
         .addText(creator,"优惠:",null,"left",0,300).addText(creator,"-1.0",null,"left")
         .addText(creator,"-------------------------------")
         .addText(creator,"原价：5.8",null,"right")
         .addText(creator,"(已在线支付）实付：1.8",null,"right")
         .addText(creator,"-------------------------------")
         .addText(creator,"张三",null,"left")
         .addText(creator,"157****9800",null,"left")
         .addText(creator,"虚拟号15669988456",null,"left")
         .addText(creator,"长河街道江南大道588号恒鑫大厦9楼9001",null,"left",3)
         .addBarcode(creator,"123567891234567",80,2,1,null,null,"center",1)
         .addQrcode(creator,"http://www.baidu.com",6,"center",5)
         .print(creator);**/


        /**TsplInstructCreator，组建指令模版示例
         TsplInstructCreator creator=new TsplInstructCreator();
         creator.setSize(creator,76,125);
         creator.addText(creator,"2021/07/16 10:44:13 第1/1个",5,60,"0",null,null,null,null)
         .addText(creator,"标准",500,10,null,1,2,2)
         .addText(creator,"快递",500,45,null,1,2,2)
         .addBox(creator,1,90,800,990)
         .addBarcode(creator,"1168866645557",30,110,null,80,4,4)
         .addBox(creator,1,220,800,220)
         .addBox(creator,1,300,800,300)
         .addText(creator,"滨江06",185,220,"0",null,3,3)
         .addBox(creator,1,350,420,350)
         .addBox(creator,1,520,600,520)
         .addBox(creator,1,610,600,610)
         .addBox(creator,1,690,600,690)
         .addBox(creator,420,300,420,610)
         .addBox(creator,170,610,170,690)
         .addBox(creator,1,860,600,860)
         .addText(creator,"集   110浙A",10,320,"0",1)
         .addText(creator,"收",10,370,"0",1)
         .addText(creator,"白先生  15588990077",50,360,"0")
         .addText(creator,"浙江省杭州市滨江区江南大道108号",50,390,"0")
         .addText(creator,"寄",5,530,"0",1)
         .addText(creator,"白亚斌 18890456789 浙江省杭州市",50,530,"0")
         .addText(creator,"西湖区小路109号",50,560,"0")
         .addBarcode(creator,"11578904944095",210,618,null,50,3,3)
         .addText(creator,"本包裹由快麦提供技术支持",120,900,"0",1)
         .addQrcode(creator,"http://www.kuaimai.com",440,860,5);
         **/

        /**面单机打印esc指令
         EscInstructCreator creator=new EscInstructCreator();
         creator.addText(creator,"示例模版");
         creator.addBarcode(creator,"123567891234567",80,2,1,null,null,"center",1);
         creator.addQrcode(creator,"http://www.baidu.com",6,"center",5);
         creator.print(creator);
         //combinationRequest.setInstructs(creator.getInstructions());
         //...省略了组装指令部分
         CombinationRequest combinationRequest=new CombinationRequest();
         combinationRequest.setSn(testSn);
         String instructs="GxEBHUwAABthAB0hABthAR0hEU9UKM/6ytu1pSkdIQAKHUwAABthAB0hAAodTAAAG2EAHSEAtaW6xaO6MDA1MTA0ICAgICAgICDKsbzko7oyMDIyLTAzLTE3IDEwOjU4OjQ3ICAKHUwAABthAB0hAL/Nu6ejutaus/UxteoKHUwAABthAB0hALXq1LGjutK7usUKHUwAABthAB0hAC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtCh1MAAAbYQAdIQC/7rrFLMP7s8YgICAgICAgICAgICAgICDK/cG/ICAgtPKw/LzbICAgICAg0KG8xgodTAAAG2EAHSEANTQ2NjA5NzUs0MLU9snMxrdBMjU4ICAgMSAgICAgIDI4MCAgICAgICAgICAyODAKHUwAABthAB0hACAgICAgICAgICAgICBTICAgICAgICAgCh1MAAAbYQAdIQC67MmrICAgICAgICAgMSAgICAgICAgIAodTAAAG2EAHSEALSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0KHUwAABthAB0hALrPvMY6Mbz+ICAgICAgICAgICAgICAgICAgICAgICAgICAgICDX3LbuOjI4MNSqCh1MAAAbYQAdIQAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLQodTAAAG2EAHSEA1fu1pdPFu92juiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAtMTUKHUwAABthAB0hAMbky/u30dPDo7ogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICA2Ch1MAAAbYQAdIQDEqMHjvfC27qO6ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAtMQodTAAAG2EAHSEAHSERus+8xqO6ICAgICAgICAgICAgICAgMjcwHSEACh1MAAAbYQAdIQAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLQodTAAAG2EAHSEAsb61pdOmytWjuiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAyNzAKHUwAABthAB0hABtHAcnPtM7T4Lbuo7o4MDcgsb60zr3h0+CjujAgwNu8xtPgtu6jujgwNxtHAAodTAAAG2EAHSEALSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0KHUwAABthAB0hAB0hEbG+taXKtcrVo7ogICAgICAgICAgIDI3MB0hAAodTAAAG2EAHSEAHUwAABthAii747/uOqOkMjcwKQodTAAAG2EAHSEALSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0KHUwAABthAB0hAMzh0NE6yOfT0M7KzOLG38zsxNq197u709DQp6Ossru7u7/uo6yyu73Tyty2/rTOzcu79aOs0LvQu7rP1/ejoQodTAAAG2EAHSEAterGzLXY1rejutXjva3Kobq81t3K0MnPs8fH+L7FzOy5+rzKNMKlRDEzNrW1Ch1MAAAbYQAdIQC157uwo7oxNTM1NTAyNjg2NwodTAAAG2EAHSEACh1MAAAbYQAdIQDK1b/uyMujusLe0MK93AodTAAAG2EAHSEAytW/7tL40NCjusWp0rXS+NDQury6o9an0NAKHUwAABthAB0hAMrVv+7Vy7rFo7o2MjI4NDUwMzIwMDIyNjk2NjE5Ch1MAAAbYQAdIQAKHUwAABthAB0hALTy06HKsbzko7oyMDIyLTAzLTE4IDE3OjM1Ch1MAAAbYQAdIQAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLQodTAAAG2EAHSEA1MZlsaYt16jStcWu17C53MDtz7XNsyAtQW5kcm9pZCBWMS4wLjkxCh1MAAAbYQAdIQC/zbf+yMjP36O6NDAwIDYwNCA3Njg4Ch1MAAAbYQAdIQAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLSAtIC0gLQodTAAAG2EAHSEAG0wdUMvLG1cAAAAAgAKwABskCAAdJAAAHShrAwAxQwUdKGsDADFFMB0oayoAMVAwaHR0cDovL3llYi5tcG0uaW5rL3Rlc3Qtbm9ybWFsL2VQbFN2MmRHHShrAwAxUTAJGyTQAB0kAAAdKGsDADFDBR0oawMAMUUwHShrLwAxUDBodHRwczovL3Uud2VjaGF0LmNvbS9NS0hISlI2Y3h6MlctRGx3VGVza3pZMB0oawMAMVEwGwwYG1MdTAAAG2EAHSEAICAgyajC68jrv+IgICAgyajD6Lb+zqzC68ztvNMgICAgICAgICAgICAgICAgICAgICC6w9PRICAgICAgChVCG2QCHVYBG2QC";
         combinationRequest.setInstructs(instructs);
         combinationRequest.setExtra("0");
         kuaimaiClient.getAcsResponse(combinationRequest);
         **/


    }


}
