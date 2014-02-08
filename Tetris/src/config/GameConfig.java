package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	/**
	 * ���ڿ��
	 */
	private int width;
	/**
	 * ���ڸ߶�
	 */
	private int height;
	/**
	 * �������
	 */
	private String title;
	/**
	 * ���ڰθ�
	 */
	private int windowUp;
	

	/**
	 * �����С
	 */
	private int windowSize;
	/**
	 * Ĭ�����ӵĴ�С
	 */
	private int padding;
	
	private List<LayerConfig> layersConfig;
	/**
	 * ���캯��
	 * ��ȡXML�ļ�����ȡ������Ϣ
	 * @throws Exception
	 */
	public GameConfig() throws Exception{
		//����XML��ȡ��
		SAXReader reader=new SAXReader();
		//���XML�ļ�
		Document doc=reader.read("config/cfg.xml");
		//���XML�ļ����ڵ�
		Element game=doc.getRootElement();
		//���ô���
		this.setUiConfig(game.element("frame"));
		//����ϵͳ����
		this.setSystemConfig(game.element("system"));
		//�������ݷ��ʲ���
		this.setDataConfig(game.element("data"));
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTitle() {
		return title;
	}

	public int getWindowUp() {
		return windowUp;
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
	 * ���ô��ڲ���
	 * @param frame
	 */
	private void setUiConfig(Element frame){
		//��ȡ���ڸ߶�
		this.width=Integer.parseInt(frame.attributeValue("width"));
		//��ȡ���ڸ߶�		
		this.height=Integer.parseInt(frame.attributeValue("height"));
		//��ȡ�߿��ϸ
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		//��ȡ�߿��ڱ߾�
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		//��ȡ����
		this.title=frame.attributeValue("title");
		//��ȡ���ڰθ�
		this.windowUp=Integer.parseInt(frame.attributeValue("windowUp"));
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
	 * ����ϵͳ����
	 * @param system
	 */
	private void setSystemConfig(Element system){
		//TODO
	}
	
	/**
	 * �������ݷ��ʲ���
	 * @param data
	 */
	private void setDataConfig(Element data){
		//TODO
	}

}
