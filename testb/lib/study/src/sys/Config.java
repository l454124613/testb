package sys;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Config {

	/**
	 * doc: 文档对象
	 */
	private Document doc = null;

	/**
	 * Config: 构建方法
	 * @param fileName 文件�?
	 */
	public Config(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileName)); // 读取XML格式配置文件
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = docBuilder.parse(inputStream);
		} catch (Exception e) { // 配置文件读取错误
			e.printStackTrace();
		}
	}

	/**
	 * readTag: 读取节点文本�?
	 * @param tagName 节点名称
	 * @return text 节点文本�?
	 */
	public String readTag(String tagName) {
		NodeList list = doc.getElementsByTagName(tagName);
		if (list.getLength() > 0) { // 如果有多个节点名称相同，只读取第�?个节�?
			return list.item(0).getFirstChild().getNodeValue().toString();
		}
		return "";
	}

	/**
	 * readTags: 读取节点列表
	 * @param tagName 节点名称
	 * @return list 节点列表
	 */
	public NodeList readTags(String tagName) {
		return doc.getElementsByTagName(tagName);
	}

	/**
	 * getNodeString: 获取节点文本�?
	 * @param node 节点
	 * @return text 节点文本�?
	 */
	public static String getNodeString(Node node) {
		return (node != null) ? node.getNodeValue().toString() : "";
	}
}
