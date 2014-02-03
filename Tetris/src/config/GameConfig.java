package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	private int width;
	private int height;
	private int windowSize;
	private int padding;
	
	private List<LayerConfig> layersConfig;
	
	public GameConfig() throws Exception{
		SAXReader reader=new SAXReader();
		Document doc=reader.read("config/cfg.xml");
		Element game=doc.getRootElement();
		Element frame=game.element("frame");
		this.width=Integer.parseInt(frame.attributeValue("width"));
		this.height=Integer.parseInt(frame.attributeValue("height"));
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		List<Element> layers=frame.elements("layer");
		layersConfig=new ArrayList<LayerConfig>();
		for(Element layer: layers){
			LayerConfig lc=new LayerConfig();
			lc.setClassName(layer.attributeValue("className"));
			lc.setX(Integer.parseInt(layer.attributeValue("x")));
			lc.setY(Integer.parseInt(layer.attributeValue("y")));
			lc.setW(Integer.parseInt(layer.attributeValue("w")));
			lc.setH(Integer.parseInt(layer.attributeValue("h")));

			layersConfig.add(lc);
		}
	}

}
