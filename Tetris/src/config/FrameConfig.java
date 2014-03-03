package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {
	
	private final String title;
	
	private final int windowUp;
	
	private final int width;
	
	private final int height;
	
	private final int padding;
	
	private final int border;
	
	private final int sizeRol;
	
	private final int loseIdx;
	
	/**
	 * ͼ������
	 */
	private final List<LayerConfig> layersConfig;
	/**
	 * ��ť����
	 */
	private final ButtonConfig buttonConfig;
	
	public FrameConfig(Element frame){
		// ��ȡ���ڸ߶�
		this.width = Integer.parseInt(frame.attributeValue("width"));
		// ��ȡ���ڸ߶�
		this.height = Integer.parseInt(frame.attributeValue("height"));
		// ��ȡ�߿��ϸ
		this.border = Integer.parseInt(frame.attributeValue("border"));
		// ��ȡ�߿��ڱ߾�
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		// ��ȡ����
		this.title = frame.attributeValue("title");
		// ��ȡ���ڰθ�
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
		//ͼ��ߴ���λ��ƫ����
		this.sizeRol=Integer.parseInt(frame.attributeValue("sizeRol"));
		//��Ϸʧ��ͼƬ
		this.loseIdx=Integer.parseInt(frame.attributeValue("loseIdx"));
		//��ȡ��������
		@SuppressWarnings("unchecked")
		List<Element> layers = frame.elements("layer");
		layersConfig = new ArrayList<LayerConfig>();
		for (Element layer : layers) {
			LayerConfig lc = new LayerConfig(layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h")));
			layersConfig.add(lc);
		}
		//��ʼ����ť����
		buttonConfig=new ButtonConfig(frame.element("button"));
	}

	public int getLoseIdx() {
		return loseIdx;
	}

	public String getTitle() {
		return title;
	}

	public int getWindowUp() {
		return windowUp;
	}

	public int getSizeRol() {
		return sizeRol;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPadding() {
		return padding;
	}

	public int getBorder() {
		return border;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}

	public ButtonConfig getButtonConfig() {
		return buttonConfig;
	}
}
