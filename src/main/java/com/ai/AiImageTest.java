//package com.ai;
//
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import java.io.File;
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
///**
// * @describtion:
// * @author: CaiJm
// * @Date: 2023-08-17 16:52
// */
//public class AiImageTest {
//    public static void main(String[] args) throws Exception {
//
////驱动地址
//        long begin = System.currentTimeMillis();
//        System.setProperty("webdriver.chrome.driver", "D:\\cjm\\chDriver\\chromedriver.exe");
//
//        WebDriver webDriver = null;
//
//
//        ChromeOptions options = new ChromeOptions();
//
////设置 chrome 的无头模式
//
//        options.addArguments("--headless");
//
//        options.addArguments("--disable-gpu");
//
//        options.addArguments("--no-sandbox");
//
//        options.addArguments("--disable-dev-shm-usage");
//
//        options.addArguments("--start-maximized");
//
////设置截图窗口大小
//
//        options.addArguments("--window-size=1280,4300");
//
////启动一个 chrome 实例
//
//        webDriver = new ChromeDriver(options);
//
////页面最大化
//
//// webDriver.manage().window().maximize();
//
////访问网址
////获取需要截图的页面
//        webDriver.get(url);
//        System.out.println("访问网址" + (System.currentTimeMillis() - begin));
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////等待加载渲染页面，避免页面未加载完就截图，页面复杂可以加大
////        Thread.sleep(5000);
//
//// WebDriverWait webDriverWait=new WebDriverWait(webDriver,5);
//
////执行javascript 可以直接设置localstroage,cookie等方式。不过拼字符串实在太麻烦
//
//// String token = "localStorage.setItem('cloud.token','{\"val\":\"5d31f455-8ed5-4ebe-80d1-760665df452c\",\"expires\":1584531900299}')";
//
//// ((JavascriptExecutor)webDriver).executeScript(token);
//
////如果需要模拟点击操作，例如账号密码，按钮 ，直接模拟登录操作就简单了,
////
////        webDriver.findElement(By.id("account")).sendKeys("admin");
////
////        webDriver.findElement(By.id("pwd")).sendKeys("admin");
////
////        webDriver.findElement(By.id("login")).click();
////
////        Thread.sleep(2000);
//
//
////定位section标签元素的位置
//
////        WebElement element = webDriver.findElement(By.tagName("section"));
////
////        Point p = element.getLocation();
////
////        int width = element.getSize().getWidth();
////
////        int height = element.getSize().getHeight();
////
////        Rectangle rec = new Rectangle(p.getX(), p.getY(), height, width);
//
////截取全屏
//
//        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
//
//////在全屏图片下裁剪处理
////
////        BufferedImage img = ImageIO.read(scrFile);
////
////        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rec.getWidth(), rec.getHeight());
////
////        ImageIO.write(dest, "png", scrFile);
//
////拷贝文件
//
//        FileUtils.copyFile(scrFile, new File("a.png"));
//
//
////退出
//
//        webDriver.quit();
//        System.out.println(System.currentTimeMillis() - begin);
//
//    }
//}
