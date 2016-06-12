package driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PageDriver {

	/**
	 * driver: 浏览器测试驱�?
	 */
	private WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * PageDriver: 构建方法
	 */
	public PageDriver() {
		driver = getLocalDriver("IE");
	}

	/**
	 * PageDriver: 构建方法
	 */
	public PageDriver(String browserName) {
		driver = getLocalDriver(browserName);
	}

	/**
	 * PageDriver: 构建方法
	 * @param browserName 浏览器名
	 * @param browserVersion 浏览器版本号
	 * @param browserPlatform 系统平台
	 * @param serverUrl 服务端地�?
	 */
	public PageDriver(String browserName, String browserVersion, String browserPlatform, String serverUrl) {
		driver = getRemoteDriver(serverUrl, getCapability(browserName, browserVersion, browserPlatform));
	}

	/**
	 * getLocalDriver: 获取本地测试驱动
	 * @param browserName 浏览器名
	 * @return driver 本地测试驱动
	 */
	private WebDriver getLocalDriver(String browserName) {
		try {
			switch (browserName.toLowerCase()) {
			case "firefox":
				return new FirefoxDriver();
			case "chrome":
				return new ChromeDriver();
			
			case "safari":
				return new SafariDriver();
			case "ie":
				return new InternetExplorerDriver();
			
			default:
				return new InternetExplorerDriver();
			}
		} catch (Exception e) { // 驱动加载错误
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * getRemoteDriver: 获取远程测试驱动
	 * @param serverUrl 服务端地�?
	 * @param capability 浏览器设�?
	 * @return driver 远程测试驱动
	 */
	private WebDriver getRemoteDriver(String serverUrl, DesiredCapabilities capability) {
		try {
			URL url = new URL("http://" + serverUrl + "/wd/hub");
			return new RemoteWebDriver(url, capability);
		} catch (Exception e) { // 驱动加载错误
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * getCapability: 获取浏览器设�?
	 * @param browserName 浏览器名
	 * @param browserVersion 浏览器版本号
	 * @param browserPlatform 系统平台
	 * @return capability 浏览器设�?
	 */
	private DesiredCapabilities getCapability(String browserName, String browserVersion, String browserPlatform) {
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		Platform platform = Platform.WINDOWS;
		switch (browserName.toLowerCase()) {
		case "firefox":
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			break;
		case "chrome":
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			break;
	
		
		case "safari":
			capability = DesiredCapabilities.safari();
			capability.setBrowserName("safari");
			break;
		case "ie":
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internet explorer");
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			break;
		
		}
		switch (browserPlatform.toLowerCase()) {
		case "windows":
			platform = Platform.WINDOWS;
			break;
		case "linux":
			platform = Platform.LINUX;
			break;
		case "mac":
			platform = Platform.MAC;
			break;
		}
		capability.setVersion(browserVersion);
		capability.setPlatform(platform);
		return capability;
	}
}
