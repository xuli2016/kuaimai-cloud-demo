# kuaimai-cloud-demo

快麦云打印开放平台 Java SDK 示例工程。演示如何通过 `kuaimai-core` SDK 对接云打印机，实现设备绑定、状态查询、模板打印、图片/PDF 打印、语音播报、任务取消、KM360C 云打印机专用接口等能力。

---

## 一、工程结构

```
kuaimai-cloud-demo
├── lib/
│   ├── kuaimai-core-1.3.2.jar                         # SDK 主包
│   └── kuaimai-core-1.3.2-jar-with-dependencies.jar   # SDK + 依赖 fat-jar（pom 实际引用的是这个）
├── src/main/java/com.cloud.example/
│   ├── CloudExample.java                              # SDK 全量用法示例（main 函数入口）
│   └── sdk说明文档                                     # SDK 请求类简要说明
├── jar                                                 # SDK 内部使用的三方依赖列表（参考）
├── pom.xml
└── README.md
```

## 二、环境要求

| 项 | 要求 |
| --- | --- |
| JDK | 1.8+ |
| 构建工具 | Maven 3.x |
| 框架 | 依赖 Spring Boot 2.4.0 的 parent（仅用于依赖管理） |
| SDK 版本 | kuaimai-core 1.3.2 |

## 三、依赖说明

`pom.xml` 中以 `system` scope 方式引用本地 `lib/` 下的 fat-jar：

```xml
<dependency>
    <groupId>com.kuaimai</groupId>
    <artifactId>kuaimai-core</artifactId>
    <version>1.3.2</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/lib/kuaimai-core-1.3.2-jar-with-dependencies.jar</systemPath>
</dependency>
```

SDK 内部已打包以下运行时依赖（见 `jar` 文件），**无需再次引入**：

- `cn.hutool:hutool-all:5.3.8`
- `net.sf.barcode4j:barcode4j:2.1`
- `uk.org.okapibarcode:okapibarcode:0.3.3`
- `com.google.zxing:core:3.5.0`
- `org.apache.pdfbox:pdfbox:2.0.31`

> 其中 `barcode4j`、`zxing`、`pdfbox` 均会调用 Java AWT 进行图形/字体渲染，**服务器需正确安装字体**（见下文「五、字体安装」）。

## 四、快速开始

### 1. 去开放平台申请凭证

登录 [快麦开放平台](https://open.iot.kuaimai.com/#/home) 申请 `appid` 与 `secret`，并在控制台完成打印机（SN）的绑定/登记。

### 2. 修改示例中的常量

打开 `src/main/java/com.cloud.example/CloudExample.java`，替换：

```java
public final static String accessKey = "快麦开放平台申请的appid";
public final static String secret    = "快麦开放平台申请的secret";
private static String testSn         = "打印机的序列号";
```

### 3. 编译与运行

```bash
mvn clean package
mvn exec:java -Dexec.mainClass="com.cloud.example.CloudExample"
# 或直接在 IDE 里运行 CloudExample#main
```

### 4. 最小调用示例

```java
KuaimaiClient client = KuaimaiClient.createClient(accessKey, secret);

QueryDeviceExistRequest req = new QueryDeviceExistRequest();
req.setSn(testSn);

ResponseEnvelope resp = client.getAcsResponse(req);
System.out.println(JSONUtil.toJsonStr(resp));
```

## 五、字体安装（重要）

SDK 在执行以下操作时会调用 Java AWT / barcode4j / pdfbox 进行**图像渲染或 PDF 栅格化**，强依赖操作系统字体库：

- 图片直接打印（`TsplImageRequest` / `EscImageRequest`）
- PDF 打印（`TsplPdfPrintRequest` / `EscPdfPrintRequest`，含多页）
- 条码 / 二维码生成
- 包含中文的标签 / 小票模板渲染

**如果服务器没有安装字体（尤其是中文字体），会出现：** 打印内容空白、中文变方块或乱码、抛出 `java.awt.FontFormatException` / `Could not initialize class sun.awt.X11FontManager` 等异常。

### 5.1 Linux（CentOS / RHEL）

```bash
# 基础字体支持
yum install -y fontconfig dejavu-sans-fonts

# 中文字体（文泉驿 + 思源黑体，按需选一）
yum install -y wqy-microhei-fonts wqy-zenhei-fonts
#（可选）从 Noto 拉取思源黑体
#   将 NotoSansCJK-Regular.ttc 放入 /usr/share/fonts/chinese/

# 刷新缓存
fc-cache -fv

# 校验
fc-list :lang=zh
```

### 5.2 Linux（Ubuntu / Debian）

```bash
apt-get update
apt-get install -y fontconfig fonts-dejavu

# 中文字体
apt-get install -y fonts-wqy-microhei fonts-wqy-zenhei fonts-noto-cjk

fc-cache -fv
fc-list :lang=zh
```

### 5.3 Docker 镜像

在 `Dockerfile` 中追加：

```dockerfile
# 基于 openjdk:8 / eclipse-temurin:8
RUN apt-get update \
 && apt-get install -y --no-install-recommends \
      fontconfig fonts-dejavu fonts-wqy-microhei fonts-wqy-zenhei fonts-noto-cjk \
 && fc-cache -fv \
 && rm -rf /var/lib/apt/lists/*
```

> 使用 `*-jre-alpine` 镜像时，因缺失 fontconfig 与 freetype，AWT 通常无法工作，建议改用 `*-jre-slim` 或手动安装 `ttf-dejavu fontconfig freetype`。

### 5.4 macOS

系统自带「苹方」「PingFang SC」等中文字体，一般开箱即用。如仍报字体错误，可用 Homebrew 补齐：

```bash
brew install --cask font-noto-sans-cjk-sc
```

### 5.5 Windows

系统自带「微软雅黑」「宋体」等，无需额外处理。

### 5.6 无头模式（Headless）

Linux 服务器上建议启动时加上：

```bash
java -Djava.awt.headless=true -jar your-app.jar
```

Spring Boot 默认即会启用 headless，一般无需显式配置。

## 六、支持的请求类一览

以下请求类均位于 `com.kuaimai.core.request.*`，使用方式统一为 `client.getAcsResponse(request)`，`CloudExample.java` 中有完整示例（取消对应注释即可运行）。

### 6.1 设备管理

| 请求类 | 说明 |
| --- | --- |
| `BindDeviceRequest` | 绑定设备（`sn` + `deviceKey`） |
| `UnbindDeviceRequest` | 解绑设备 |
| `QueryDeviceExistRequest` | 查询设备是否存在 |
| `QueryDeviceStatusRequest` | 批量查询设备状态（`sns` 为 JSON 数组字符串） |
| `AdjustDeviceDensityRequest` | 调节打印浓度（1–15，默认 8；支持 KM118/KME31/KME41 系列，仅 tspl 标签模式） |

### 6.2 模板打印

| 请求类 | 说明 |
| --- | --- |
| `EscTemplatePrintRequest` | 小票模板 — 连续纸打印 |
| `TsplTemplatePrintRequest` | 标签模板 — 间隙纸打印（支持图像化） |
| `TsplTemplateWriteRequest` | 小票模板 — 间隙纸打印 |

### 6.3 自定义 XML 指令

| 请求类 | 说明 |
| --- | --- |
| `EscXmlWriteRequest` | 自定义 XML — 连续纸 |
| `TsplXmlWriteRequest` | 自定义 XML — 间隙纸 |

### 6.4 图片 / PDF 直接打印

| 请求类 | 说明 |
| --- | --- |
| `TsplImageRequest` | 图片直接打印（间隙纸），入参为 base64 |
| `EscImageRequest` | 图片直接打印（连续纸），入参为 base64 |
| `TsplPdfPrintRequest` | PDF 打印（间隙纸），支持 `kuaimaiClient.tsplPdfsPrint(...)` 多页打印 |
| `EscPdfPrintRequest` | PDF 打印（连续纸），支持 `kuaimaiClient.escPdfsPrint(...)` 多页打印 |

### 6.5 其它功能

| 请求类 | 说明 |
| --- | --- |
| `BroadcastRequest` | 语音播报（`volume` 1–100，`volumeContent` 播报文本） |
| `CancelJobRequest` | 取消打印任务 |
| `ResultRequest` | 打印结果查询（也可在后台配置回调地址主动推送） |

### 6.6 KM360C 云打印机专用

| 请求类 | 说明 |
| --- | --- |
| `GetCainiaoCodeRequest` | 获取云打印机 code（5 分钟有效） |
| `CainiaoBindRequest` | 绑定云打印机（`imei` + `code`） |
| `CainiaoPrintRequest` | 图片打印（base64） |
| `TsplTemplatePrintRequest`（设置 `imei`） | KM360C 标签模板 — 间隙纸打印 |

## 七、参考文档

- 开放平台控制台：<https://open.iot.kuaimai.com/#/home>
- 云打印 API 文档：<https://cloudprint.kuaimai.com/#/openDev>

## 八、常见问题

1. **`ClassNotFoundException: com.kuaimai.core.client.KuaimaiClient`**
   未使用 `lib/` 下的 fat-jar，或 `systemPath` 不正确。确认 `pom.xml` 引用的是 `kuaimai-core-1.3.2-jar-with-dependencies.jar`。

2. **打印中文空白 / 方块 / 乱码**
   服务器缺少中文字体。按「五、字体安装」安装字体并执行 `fc-cache -fv`，然后重启应用。

3. **Alpine 容器内抛 `NoClassDefFoundError: Could not initialize class sun.awt.X11FontManager`**
   Alpine 默认不含 freetype/fontconfig。改用 `slim` 基础镜像，或在 Alpine 中手动安装 `fontconfig ttf-dejavu freetype`。

4. **PDF 打印内容缺失或字体回退**
   PDFBox 找不到内嵌字体对应的系统字体。确保安装了 `fonts-noto-cjk` 或思源黑体等覆盖范围较广的 CJK 字体。
