package map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;



import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sys.Config;

public class CaseMap {

	/**
	 * map: 用例配置�?
	 */
	private static ConcurrentHashMap<String, HashMap<String, String>> map = initMap();

	public static ConcurrentHashMap<String, HashMap<String, String>> getMap() {
		return map;
	}

	/**
	 * initMap: 初始化用例配置表
	 * @return map 用例配置�?
	 */
	private static ConcurrentHashMap<String, HashMap<String, String>> initMap() {
		ConcurrentHashMap<String, HashMap<String, String>> caseMap = new ConcurrentHashMap<String, HashMap<String, String>>();
		NodeList suitList = new Config("config/case.xml").readTags("suit");
		for (int i = 0; i < suitList.getLength(); i++) { // 获取�?有用例集
			NamedNodeMap suitAttrs = suitList.item(i).getAttributes();
			if (Config.getNodeString(suitAttrs.getNamedItem("enable")).equals("off")) { // 用例集停�?
				continue;
			}
			NodeList caseList = suitList.item(i).getChildNodes();
			for (int j = 0; j < caseList.getLength(); j++) { // 获取�?有用例的全部配置信息
				if (caseList.item(j).getNodeType() != Node.ELEMENT_NODE) {
					continue;
				}
				NamedNodeMap caseAttrs = caseList.item(j).getAttributes();
				if (Config.getNodeString(caseAttrs.getNamedItem("enable")).equals("off")) { // 用例停用
					continue;
				}
				HashMap<String, String> attrMap = new HashMap<String, String>();
				attrMap.put("name", Config.getNodeString(caseAttrs.getNamedItem("name")));
				attrMap.put("description", Config.getNodeString(caseAttrs.getNamedItem("description")));
				attrMap.put("script", Config.getNodeString(caseAttrs.getNamedItem("script")));
				attrMap.put("pageLoadTimeout", Config.getNodeString(caseAttrs.getNamedItem("pageLoadTimeout")));
				attrMap.put("scriptTimeout", Config.getNodeString(caseAttrs.getNamedItem("scriptTimeout")));
				attrMap.put("implicitlyWait", Config.getNodeString(caseAttrs.getNamedItem("implicitlyWait")));
				caseMap.put("Case-" + i + "-" + j, attrMap);
			}
		}
		return caseMap;
	}
}
