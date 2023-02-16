# kuaimai-cloud-demo

引入kuaimai-core-1.0.3.jar;在lib文件夹中

1.使用之前需要去快麦开放平台 https://open.iot.kuaimai.com/#/home 申请appid和secret

2.初始化:

    KuaimaiClient kuaimaiClient=KuaimaiClient.createClient(appid,secret);
    
3.初始化入参:

    QueryDeviceExistRequest queryDeviceExistRequest=new QueryDeviceExistRequest();
    
    queryDeviceExistRequest.setSn(testSn);
    
4.调用sdk

    kuaimaiClient.getAcsResponse(queryDeviceExistRequest);
    

入参说明：

    QueryDeviceExistRequest：查询设备是否存在
    
    QueryDeviceStatusRequest:查询设备状态
    
    EscTemplatePrintRequest：小票模版esc打印
    
    TsplTemplatePrintRequest：标签模版tspl打印
    
    TsplTemplateWriteRequest: 小票模版tspl打印
    
    EscInstructRequest:esc打印
    
    EscInstructCreator:esc指令组装器
    
    TsplInstructRequest:tspl打印
    
    TsplInstructCreator:tspl指令组装器
    
    ResultRequest:标签，面单机打印结果查询
    
    CombinationRequest:标签，面单机打印esc指令



EscInstructCreator:

    //添加文本
    
    addText(EscInstructCreator escInstructCreator, String content, String font, String align, Integer feed, Integer nextX, Integer bold, Integer unline, Integer rota);
    
    content：文本内容
    font：字体大小，由两位数字组成的字符串，前一位数字表示宽的倍数，后一位数字表示高的倍数；例如font="12"表示（2倍宽3倍高）；不传默认是00
    align：对齐方式，取值：center-居中，left-左对齐，right-右对齐,默认居中
    feed：回车换行步数，默认是1
    nextX：当feed=0的时候，nextX才传值，才有意义，表示下一个元素的起始位置，单位为dot；
    bold：是否加粗，0：否，1：是，默认0
    unline：是否添加下划线，0：否，1：是，默认0
    rota：是否顺转90度，0：否，1：是，默认0

    //添加条形码
    addBarcode(EscInstructCreator escInstructCreator, String content, Integer height, Integer wide, Integer font, String showT, Integer model, String align, Integer feed);
    content: 条形码内容
    height:条码高度(单位dot），取值范围：1到255，默认125
    wide:条码横行条码宽度(单位dot），取值范围：2到6，默认4
    font:条码字体压缩还是标准，0：标准，1：压缩，默认0
    showT：文字显示，取值down、up、false，非必填属性，默认down
    model：条形码类型，取值0～6，65～73，默认73
    align:对齐方式，取值：center-居中，left-左对齐，right-右对齐,默认左对齐
    feed:回车换行步数，默认是1

    //添加二维码
    addQrcode(EscInstructCreator escInstructCreator, String content, Integer size, String align, Integer feed);
    content:二维码的内容
    size:二维码的大小，取值0~15，默认3
    align:对齐方式，取值：center-居中，left-左对齐，right-右对齐,默认左对齐
    feed:回车换行步数，默认是1

    //添加图片
    addImg(EscInstructCreator escInstructCreator, String content, Integer size, String align, Integer feed);
    content:图片的base64数据
    size：图片的大小，0-正常大小，1-图片宽度扩大，2-图片高度扩大，3-图片宽度和高度同时扩大，默认是0
    align:对齐方式，取值：center-居中，left-左对齐，right-右对齐,默认左对齐

TsplInstructCreator:

    //设置打印区域
    setSize(TsplInstructCreator tsplInstructCreator, Integer width, Integer height);
    
    width:宽度
    
    height:高度
    

    //添加文本
    addText(TsplInstructCreator tsplInstructCreator, String content, Integer x, Integer y, String font, Integer bold, Integer xMultiple, Integer yMultiple, Integer rotate, Integer waterMark, Integer bgbx, Integer bgby, Integer bgbWidth, Integer bgbHeight);
    content:文本内容
    x:坐标x
    y:坐标y
    font:字体类型,默认是1
        0：Monotye CG Triumvirate Bold Condensed 可伸缩字体，中文24*24 英文12*24
        1：8 x 12  固定间距点字体
        2：12 x 20 固定间距点字体
        3：16 x 24 固定间距点字体
        4：24 x 32 固定间距点字体
        5：32 x 48 点固定间距字体
        6：14 x 19 点固定间距字体库- b
        7：21 x 27 点固定间距字体库- b
        8：14 x25  点固定间距字体库
        ROMAN.TTF：Monotye CG Triumvirate Bold Condensed 固定百分比尺寸字体
        1.EFT: EPL2 font 1
        2.EFT: EPL2 font 2
        3.EFT: EPL2 font 3
        4.EFT: EPL2 font 4
        5.EFT: EPL2 font 5
        A.FNT: ZPL2 font A
        B.FNT: ZPL2 font B
        D.FNT: ZPL2 font D
        E8.FNT: ZPL2 font E8
        F.FNT: ZPL2 font F
        G.FNT: ZPL2 font G
        H8.FNT: ZPL2 font H8
        GS.FNT: ZPL2 font GS
        TSS12.BF2: TSS 12*12点阵
        TSS16.BF2: TSS 16*16点阵
        TSS20.BF2: TSS 20*20点阵
        TSS24.BF2: TSS 24*24点阵
        TSS28.BF2: TSS 28*28点阵
        TSS32.BF2: TSS 32*32点

    bold: 是否加粗,0:不加粗；1:加粗,默认是0
    xMultiple:宽的倍数, 默认是1
    yMultiple:高的倍数，默认是1
    rotate:旋转角度，取值：0,90,180,270; 默认是0
    waterMark:水印浓度,取值0～100,0表示取消水印,默认是0
    bgbX,bgbY,bgbWidth,bgbHeight:设置文字背景为黑色,分别为起始位置x,y和宽度,高度;默认是无

    //添加线框
    addBox(TsplInstructCreator tsplInstructCreator, Integer x, Integer y, Integer xEnd, Integer yEnd, Integer thickness, Integer radius);
    x:坐标x
    y:坐标y
    xEnd:x结束点,默认是100
    yEnd:y结束点,默认是100
    thickness:线条宽度,默认是1
    radius:弧度半径,默认是0

    //添加条形码
    addBarcode(TsplInstructCreator tsplInstructCreator, String content, Integer x, Integer y, String codeType, Integer height, Integer narrow, Integer wide, Integer style, Integer rotate);
    content:条形码内容
    x:坐标x
    y:坐标y
    codeType:条形码样式，默认是128
             128: Code 128, switching code subset automatically.
             128M: Code 128, switching code subset manually.
             EAN128: EAN128, switching code subset automatically.
             25: Interleaved 2 of 5.
             25C: Interleaved 2 of 5 with check digit.
             39: Code 39, switching standard and full ASCII mode automatically.
             39C: Code 39 with check digit.
             93: Code 93.
             EAN13: EAN 13.
             EAN13+2: EAN 13 with 2 digits add-on.
             EAN13+5: EAN 13 with 5 digits add-on.
             EAN8: EAN 8.
             EAN8+2: EAN 8 with 2 digits add-on.
             EAN8+5: EAN 8 with 5 digits add-on.
             CODA: Codabar.
             POST: Postnet.
             UPCA: UPC-A.
             UPCA+2: UPC-A with 2 digits add-on.
             UPA+5: UPC-A with 5 digits add-on.
             UPCE: UPC-E.
             UPCE+2: UPC-E with 2 digits add-on.
             UPE+5: UPC-E with 5 digits add-on.
             MSI: MSI.
             MSIC: MSI with check digit.
             PLESSEY: PLESSEY.
             CPOST: China post.
             ITF14: ITF14.
             EAN14: EAN14.
             11: Code 11.
             TELEPEN: Telepen. *Since V6.89EZ.
             TELEPENN: Telepen number. *Since V6.89EZ.
             PLANET: Planet. *Since V6.89EZ.
             CODE49: Code 49. *Since V6.89EZ.
             DPI: Deutsche Post Identcode. *Since V6.91EZ.
             DPL: Deutsche Post Leitcode. *Since V6.91EZ.
             LOGMARS: A special use of Code 39. *Since V6.88EZ.

     height: 高度，单位dot,默认100
     narrow:窄条宽度，单位dot，默认2
     wide:宽条宽度，单位dot，默认2
     style:内容样式,默认是2;0:不可见；1:可见巨左；2:可见居中；3:可见居右
     rotate:ds旋转角度，取值：0,90,180,270; 默认是0

     //添加二维码
     addQrcode(TsplInstructCreator tsplInstructCreator, String content, Integer x, Integer y, Integer cellWidth, Integer rotate, String eccLevel, String mode, String model, String mask);
     content:内容
     x:坐标x
     y:坐标y
     cellWidth:高度宽度,默认是7
     rotate:旋转角度,默认是0
     eccLevel:]辨识等级,默认是L
     mode:0:Auto, 1:manual,默认是0
     model:1-default M1 ,2-M,默认是1
     mask:S[0-8],默认是S3,掩膜版的种类，控制二维码的样式

     //添加圆
     addCircle(TsplInstructCreator tsplInstructCreator, Integer x, Integer y, Integer thickness, Integer diameter)
        x:起始x坐标,默认是1
        y:起始y坐标,默认是1
        thickness:线条宽度,默认是1
        diameter:直径,默认是100

    //添加椭圆
     addEllipse(TsplInstructCreator tsplInstructCreator, Integer x, Integer y, Integer width, Integer height, Integer thickness);
     x:起始x坐标,默认是1
     y:起始y坐标,默认是1
     width:宽度,默认是100
     height:高度,默认是50
     thickness:线条宽度,默认是1

     //添加图片
     addImg(TsplInstructCreator tsplInstructCreator, String base64Content, Integer x, Integer y);
     x:起始x坐标,默认是1
     y:起始y坐标,默认是1
     base64Content:图片的base64数据(不带base64前缀）
