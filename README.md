# kuaimai-cloud-demo

引入kuaimai-core-1.1.1.jar;在lib文件夹中

1.使用之前需要去快麦开放平台 https://open.iot.kuaimai.com/#/home 申请appid和secret

2.初始化:

    KuaimaiClient kuaimaiClient=KuaimaiClient.createClient(appid,secret);
    
3.初始化入参:

    QueryDeviceExistRequest queryDeviceExistRequest=new QueryDeviceExistRequest();
    
    queryDeviceExistRequest.setSn(testSn);
    
4.调用sdk

    kuaimaiClient.getAcsResponse(queryDeviceExistRequest);
    


