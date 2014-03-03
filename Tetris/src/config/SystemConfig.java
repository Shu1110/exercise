package config;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

public class SystemConfig {

	private final int minX;
	
	private final int maxX;
	
	private final int minY;
	
	private final int maxY;
	
	private final int levleUp;
	
	private final List<Point[]> typeConfig;
	
	private final List<Boolean> typeRound;
	
	private final Map<Integer,Integer> plusPoint;
	
	public SystemConfig(Element system){
		this.minX=Integer.parseInt(system.attributeValue("minX"));
		this.maxX=Integer.parseInt(system.attributeValue("maxX"));
		this.minY=Integer.parseInt(system.attributeValue("minY"));
		this.maxY=Integer.parseInt(system.attributeValue("maxY"));
		this.levleUp=Integer.parseInt(system.attributeValue("levelUp"));
		@SuppressWarnings("unchecked")
		List<Element> rects=system.elements("rect");
		typeConfig=new ArrayList<Point[]>(rects.size());
		typeRound=new ArrayList<Boolean>(rects.size());
		for(Element rect : rects){
			//�Ƿ���ת
			this.typeRound.add(Boolean.parseBoolean(rect.attributeValue("round")));
			//����������
			@SuppressWarnings({ "unchecked" })
			List<Element> pointConfig = rect.elements("point");
			//����Point��������
			Point[] points=new Point[pointConfig.size()];
			//��ʼ��Point��������
			for(int i=0;i<points.length;i++){
				int x=Integer.parseInt(pointConfig.get(i).attributeValue("x"));
				int y=Integer.parseInt(pointConfig.get(i).attributeValue("y"));
				points[i]=new Point(x,y);
			}
			//��Point��������ŵ�typeConfig��
			typeConfig.add(points);
		}
		//��������ӷ�����
		this.plusPoint=new HashMap<Integer,Integer>();
		List<Element> plusPointCfg=system.elements("plusPoint");
		for(Element cfg:plusPointCfg){
			int rm=Integer.parseInt(cfg.attributeValue("rm"));
			int point=Integer.parseInt(cfg.attributeValue("point"));
			this.plusPoint.put(rm, point);
		}
	}

	public int getMinX() {
		return minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxY() {
		return maxY;
	}

	public List<Point[]> getTypeConfig() {
		return typeConfig;
	}
	
	public int getLevleUp() {
		return levleUp;
	}

	public List<Boolean> getTypeRound() {
		return typeRound;
	}

	public Map<Integer, Integer> getPlusPoint() {
		return plusPoint;
	}
	
	
}
