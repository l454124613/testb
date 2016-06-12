package sys;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driver.ExtendWebDriver;

public abstract class Page {

	/**
	 * Page: 构建方法
	 */
	public Page() {
		PageFactory.initElements(driver, this);
		load();
	}

	/**
	 * browser: 浏览器对象实�?
	 */
	protected Browser browser = Server.getCommander().getThreadMap().get(Thread.currentThread().getId());

	/**
	 * driver: 浏览器测试驱�?
	 */
	protected WebDriver driver = browser.getDriver();

	/**
	 * driverx: 扩展浏览器测试驱�?
	 */
	protected ExtendWebDriver driverx = new ExtendWebDriver(driver);

	/**
	 * load: 页面载入执行代码
	 * @return void
	 */
	protected void load() {
		// 基类不做任何�?
	};
}
