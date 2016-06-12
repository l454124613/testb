package sys;

import java.util.Iterator;


import org.openqa.selenium.WebDriver;

import driver.PageDriver;
import map.BrowserMap;
import map.CaseMap;

public class Browser extends Thread {

	/**
	 * name: 浏览器名
	 */
	private String name = "";

	public String getNamex() {
		return name;
	}

	/**
	 * version: 浏览器版本号
	 */
	private String version = "";

	public String getVersion() {
		return version;
	}

	/**
	 * platform: 浏览器平�?
	 */
	private String platform = "";

	public String getPlatform() {
		return platform;
	}

	/**
	 * driver: 测试驱动
	 */
	private WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * judge: 测试审判
	 */
	private Judge judge = new Judge();

	public Judge getJudge() {
		return judge;
	}

	/**
	 * pageLoadTimeout: 页面超时时间（秒�?
	 */
	private Integer pageLoadTimeout = 30;

	public Integer getPageLoadTimeout() {
		return pageLoadTimeout;
	}

	/**
	 * initPageLoadTimeout: 初始化页面超时时�?
	 * @param key 浏览器配置索�?
	 * @return pageLoadTimeout 页面超时时间
	 */
	private Integer initPageLoadTimeout(String key) {
		Integer pageLoadTimeout = Server.getPageLoadTimeout();
		try { // 读取配置错误或无配置时，使用全局配置
			String pageLoadValue = BrowserMap.getMap().get(key).get("pageLoadTimeout"); // 覆盖全局配置
			pageLoadTimeout = (!pageLoadValue.equals("")) ? Integer.parseInt(pageLoadValue) : Server.getPageLoadTimeout();
		} catch (Exception e) { // 配置设置错误
			e.printStackTrace();
		}
		return pageLoadTimeout;
	}

	/**
	 * scriptTimeout: 脚本超时时间（秒�?
	 */
	private Integer scriptTimeout = 30;

	public Integer getScriptTimeout() {
		return scriptTimeout;
	}

	/**
	 * initScriptTimeout: 初始化脚本超时时�?
	 * @param key 浏览器配置索�?
	 * @return scriptTimeout 脚本超时时间
	 */
	private Integer initScriptTimeout(String key) {
		Integer scriptTimeout = Server.getScriptTimeout();
		try { // 读取配置错误或无配置时，使用全局配置
			String scriptValue = BrowserMap.getMap().get(key).get("scriptTimeout"); // 覆盖全局配置
			scriptTimeout = (!scriptValue.equals("")) ? Integer.parseInt(scriptValue) : Server.getScriptTimeout();
		} catch (Exception e) { // 配置设置错误
			e.printStackTrace();
		}
		return scriptTimeout;
	}

	/**
	 * implicitlyWait: 等待超时时间（秒�?
	 */
	private Integer implicitlyWait = 10;

	public Integer getImplicitlyWait() {
		return implicitlyWait;
	}

	/**
	 * initImplicitlyWait: 初始化等待超时时�?
	 * @param key 浏览器配置索�?
	 * @return implicitlyWait 等待超时时间
	 */
	private Integer initImplicitlyWait(String key) {
		Integer implicitlyWait = Server.getImplicitlyWait();
		try { // 读取配置错误或无配置时，使用全局配置
			String implicitnessValue = BrowserMap.getMap().get(key).get("implicitlyWait"); // 覆盖全局配置
			implicitlyWait = (!implicitnessValue.equals("")) ? Integer.parseInt(implicitnessValue) : Server.getImplicitlyWait();
		} catch (Exception e) { // 配置设置错误
			e.printStackTrace();
		}
		return implicitlyWait;
	}

	/**
	 * initial: 初始化浏览器信息
	 * @param key 浏览器配置索�?
	 * @return browser 对象实例
	 */
	public Browser initial(String key) {
		name = BrowserMap.getMap().get(key).get("name"); // 根据索引获取浏览器名、版本号、系统平台配�?
		version = BrowserMap.getMap().get(key).get("version");
		platform = BrowserMap.getMap().get(key).get("platform");
		pageLoadTimeout = initPageLoadTimeout(key);
		scriptTimeout = initScriptTimeout(key);
		implicitlyWait = initImplicitlyWait(key);
		return this;
	}

	/**
	 * run: 远程浏览器并发测�?
	 * @return void
	 */
	public void run() {
		judge.info("浏览�?: " + name + "-" + version + " >> 启动");
		Server.getCommander().getThreadMap().put(Thread.currentThread().getId(), this);
		Server.getCommander().getJudgeMap().put(name + " [ Version:" + version + " Platform:" + platform + " ]", judge);
		driver = new PageDriver(name, version, platform, Server.getRemoteHost()).getDriver();
		if (driver == null) { // 驱动初始化失�?
			judge.error("浏览�?" + name + "-" + version + "启动失败");
			return;
		}
		driver.manage().window().maximize();
		if (Server.getRunMode().equals("remote")) { // 独立执行全部测试用例
			Iterator<String> caseIterator = Server.getCommander().getCaseQueue().iterator();
			while (caseIterator.hasNext()) {
				runCase(caseIterator.next().toString());
			}
		} else if (Server.getRunMode().equals("multiple")) { // 共同分配执行全部用例
			while (!Server.getCommander().getCaseQueue().isEmpty()) {
				try {
					runCase(Server.getCommander().getCaseQueue().poll());
				} catch (Exception e) { // 并发错误
					e.printStackTrace();
				}
			}
		}
		driver.close();
		driver.quit();
		judge.info("浏览�?: " + name + "-" + version + " >> 关闭");
	}

	/**
	 * launch: 本地浏览器顺序测�?
	 * @return void
	 */
	public void launch() {
		judge.info("浏览�?: " + name + "-" + version + " >> 启动");
		Server.getCommander().getThreadMap().put(Thread.currentThread().getId(), this);
		Server.getCommander().getJudgeMap().put(name + " [ Version:" + version + " Platform:" + platform + " ]", judge);
		driver = new PageDriver(name).getDriver();
		if (driver == null) { // 驱动初始化失�?
			judge.error("浏览�?" + name + "-" + version + "启动失败");
			return;
		}
		driver.manage().window().maximize();
		Iterator<String> caseIterator = CaseMap.getMap().keySet().iterator();
		while (caseIterator.hasNext()) { // 顺序执行测试用例
			runCase(caseIterator.next().toString());
		}
		driver.close();
		driver.quit();
		judge.info("浏览�?: " + name + "-" + version + " >> 关闭");
	}

	/**
	 * runCase: 运行用例
	 * @param caseName 用例�?
	 * @return void
	 */
	private void runCase(String caseKey) {
		String caseScript = CaseMap.getMap().get(caseKey).get("script"); // 根据索引获取用例文件位置并实例化
		try {
			Case testCase = (Case) Class.forName("lazyat.tc." + caseScript).newInstance();
			testCase.initial(caseKey).launch();
		} catch (Exception e) { // Case文件初始化错�?
			judge.error("用例" + caseScript + "加载失败");
			e.printStackTrace();
		}
	}
}
