package map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;



import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import sys.Config;

public class BrowserMap {

	/**
	 * map: 浏览器配置表
	 */
	private static ConcurrentHashMap<String, HashMap<String, String>> map = initMap();

	public static ConcurrentHashMap<String, HashMap<String, String>> getMap() {
		return map;
	}

	/**
	 * initMap: 初始化浏览器配置�?
	 * @return map 浏览器配置表
	 */
	private static ConcurrentHashMap<String, HashMap<String, String>> initMap() {
		NodeList browserList = new Config("config/browser.xml").readTags("browser");
		ConcurrentHashMap<String, HashMap<String, String>> browserMap = new ConcurrentHashMap<String, HashMap<String, String>>();
		for (int i = 0; i < browserList.getLength(); i++) { // 获取�?有浏览器的全部配置信�?
			NamedNodeMap browserAttrs = browserList.item(i).getAttributes();
			if (Config.getNodeString(browserAttrs.getNamedItem("enable")).equals("off")) { // 浏览器停�?
				continue;
			}
			HashMap<String, String> attrMap = new HashMap<String, String>();
			attrMap.put("name", Config.getNodeString(browserAttrs.getNamedItem("name")));
			attrMap.put("version", Config.getNodeString(browserAttrs.getNamedItem("version")));
			attrMap.put("platform", Config.getNodeString(browserAttrs.getNamedItem("platform")));
			attrMap.put("pageLoadTimeout", Config.getNodeString(browserAttrs.getNamedItem("pageLoadTimeout")));
			attrMap.put("scriptTimeout", Config.getNodeString(browserAttrs.getNamedItem("scriptTimeout")));
			attrMap.put("implicitlyWait", Config.getNodeString(browserAttrs.getNamedItem("implicitlyWait")));
			browserMap.put("Browser-" + i, attrMap);
		}
		return browserMap;
	}
}
