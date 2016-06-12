package sys;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import map.CaseMap;



public abstract class Case {

	/**
	 * name: 用例�?
	 */
	protected String name = "";

	/**
	 * description: 用例描述
	 */
	protected String description = "";

	/**
	 * browser: 浏览器对象实�?
	 */
	protected Browser browser = Server.getCommander().getThreadMap().get(Thread.currentThread().getId());

	/**
	 * judge: 浏览器测试审�?
	 */
	protected Judge judge = browser.getJudge();

	/**
	 * pageLoadTimeout: 页面超时时间（秒�?
	 */
	protected Integer pageLoadTimeout = 30;

	/**
	 * initPageLoadTimeout: 初始化页面超时时�?
	 * @param key 用例配置索引
	 * @return pageLoadTimeout 页面超时时间
	 */
	protected Integer initPageLoadTimeout(String key) {
		Integer pageLoadTimeout = browser.getPageLoadTimeout();
		try { // 读取配置错误或无配置时，使用浏览器级别配�?
			String pageLoadValue = CaseMap.getMap().get(key).get("pageLoadTimeout"); // 覆盖浏览器级别配�?
			pageLoadTimeout = (!pageLoadValue.equals("")) ? Integer.parseInt(pageLoadValue) : browser.getPageLoadTimeout();
		} catch (Exception e) { // 配置设置错误
			e.printStackTrace();
		}
		return pageLoadTimeout;
	}

	/**
	 * scriptTimeout: 脚本超时时间（秒�?
	 */
	protected Integer scriptTimeout = 30;

	/**
	 * initScriptTimeout: 初始化脚本超时时�?
	 * @param key 用例配置索引
	 * @return scriptTimeout 脚本超时时间
	 */
	protected Integer initScriptTimeout(String key) {
		Integer scriptTimeout = browser.getScriptTimeout();
		try { // 读取配置错误或无配置时，使用浏览器级别配�?
			String scriptValue = CaseMap.getMap().get(key).get("scriptTimeout"); // 覆盖浏览器级别配�?
			scriptTimeout = (!scriptValue.equals("")) ? Integer.parseInt(scriptValue) : browser.getScriptTimeout();
		} catch (Exception e) { // 配置设置错误
			e.printStackTrace();
		}
		return scriptTimeout;
	}

	/**
	 * implicitlyWait: 等待超时时间（秒�?
	 */
	protected Integer implicitlyWait = 10;

	/**
	 * initImplicitlyWait: 初始化等待超时时�?
	 * @param key 用例配置索引
	 * @return implicitlyWait 等待超时时间
	 */
	protected Integer initImplicitlyWait(String key) {
		Integer implicitlyWait = browser.getImplicitlyWait();
		try { // 读取配置错误或无配置时，使用浏览器级别配�?
			String implicitnessValue = CaseMap.getMap().get(key).get("implicitlyWait"); // 覆盖浏览器级别配�?
			implicitlyWait = (!implicitnessValue.equals("")) ? Integer.parseInt(implicitnessValue) : browser.getImplicitlyWait();
		} catch (Exception e) { // 配置设置错误
			e.printStackTrace();
		}
		return implicitlyWait;
	}

	/**
	 * initial: 初始化用例信�?
	 * @param key 用例配置索引
	 * @param description 用例描述
	 * @return case 对象实例
	 */
	public Case initial(String key) {
		name = CaseMap.getMap().get(key).get("name").toString(); // 根据索引获取用例名，用例描述
		description = CaseMap.getMap().get(key).get("description").toString();
		pageLoadTimeout = initPageLoadTimeout(key);
		scriptTimeout = initScriptTimeout(key);
		implicitlyWait = initImplicitlyWait(key);
		return this;
	}

	/**
	 * launch: 用例测试执行
	 * @return void
	 */
	public void launch() {
		judge.info("测试用例: " + name + " >> �?始执�?");
		browser.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		browser.getDriver().manage().timeouts().setScriptTimeout(scriptTimeout, TimeUnit.SECONDS);
		browser.getDriver().manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
		browser.getDriver().manage().window().maximize();
		before();
		execute(); // 用例�?要继承Case类并实现execute方法
		after();
		judge.info("测试用例: " + name + " >> 结束");
	}

	/**
	 * execute: 用例主体执行代码
	 * @return void
	 */
	protected abstract void execute();

	/**
	 * before: 用例前置代码
	 * @return void
	 */
	protected void before() {
		// 基类不做任何�?
	}

	/**
	 * after: 用例后置代码
	 * @return void
	 */
	protected void after() {
		// 基类不做任何�?
	}

	/**
	 * screenshot: 屏幕快照
	 * @return path 快照文件路径
	 */
	public String screenshot() {
		String path = Server.getCommander().getNamex() + "/" + Server.generateId() + ".png";
		try {
			File source = ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.FILE);
			File target = new File("report/" + path); // 快照图片存放于report/{测试标识号}/目录�?
			FileUtils.copyFile(source, target);
		} catch (Exception e) { // 生成错误
			e.printStackTrace();
		}
		return path;
	}
}
