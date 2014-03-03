package main;

import service.GameTetris;
import ui.JFrameGame;
import ui.JPanelGame;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;

public class Main {
	public static void main(String args[]){
		//������Ϸ����Դ
		GameDto dto=new GameDto();
		//������Ϸ���
		JPanelGame panel=new JPanelGame(dto);
		//������Ϸ�߼��飨������Ϸ����Դ��
		GameTetris service=new GameTetris(dto);
		//������Ϸ��������������Ϸ�������Ϸ�߼��飩
		GameControl gameControl=new GameControl(panel,service);
		//����Ϸ���������󽻸�Panel
		panel.setGameControl(gameControl);
		//������Ϸ��ҿ�������������Ϸ��������
		PlayerControl control=new PlayerControl(gameControl);
		//��װ��ҿ�����
		panel.setGameControl(control);
		//������Ϸ���ڣ���װ��Ϸ���
		JFrameGame frame=new JFrameGame(panel);
	}

}
