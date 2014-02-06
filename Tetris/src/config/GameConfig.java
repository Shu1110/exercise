package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	/**
	 * 窗口宽度
	 */
	private int width;
	/**
	 * 窗口高度
	 */
	private int height;
	/**
	 * 窗体大小
	 */
	private int windowSize;
	/**
	 * 默认增加的大小
	 */
	private int padding;
	
	private List<LayerConfig> layersConfig;
	/**
	 * 构造函数
	 * 读取XML文件，获取配置信息
	 * @throws Exception
	 */
	public GameConfig() throws Exception{
		//创建XML读取器
		SAXReader reader=new SAXReader();
		//获得XML文件
		Document doc=reader.read("config/cfg.xml");
		//获得XML文件根节点
		Element game=doc.getRootElement();
		//配置窗口
		this.setUiConfig(game.element("frame"));
		//配置系统参数
		this.setSystemConfig(game.element("system"));
		//配置数据访问参数
		this.setDataConfig(game.element("data"));
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public int getPadding() {
		return padding;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}

	/**
	 * 配置窗口参数
	 * @param frame
	 */
	private void setUiConfig(Element frame){
		this.width=Integer.parseInt(frame.attributeValue("width"));
		this.height=Integer.parseInt(frame.attributeValue("height"));
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		List<Element> layers=frame.elements("layer");
		layersConfig=new ArrayList<LayerConfig>();
		for(Element layer: layers){
			LayerConfig lc=new LayerConfig(
				layer.attributeValue("className"),
				Integer.parseInt(layer.attributeValue("x")),
				Integer.parseInt(layer.attributeValue("y")),
				Integer.parseInt(layer.attributeValue("w")),
				Integer.parseInt(layer.attributeValue("h"))
			);
			layersConfig.add(lc);
		}
		
	}
	
	/**
	 * 配置系统参数
	 * @param system
	 */
	private void setSystemConfig(Element system){
		//TODO
	}
	
	/**
	 * 配置数据访问参数
	 * @param data
	 */
	private void setDataConfig(Element data){
		//TODO
	}

}
