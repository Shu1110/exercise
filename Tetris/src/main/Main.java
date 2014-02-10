package main;

import service.GameService;
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
		GameService service=new GameService(dto);
		//������Ϸ��������������Ϸ�������Ϸ�߼��飩
		GameControl gameControl=new GameControl(panel,service);
		//������Ϸ��ҿ�������������Ϸ��������
		PlayerControl control=new PlayerControl(gameControl);
		//��װ��ҿ�����
		panel.setGameControl(control);
		//������Ϸ���ڣ���װ��Ϸ���
		JFrameGame frame=new JFrameGame(panel);
	}

}
