import java.io.*;

public class CopyFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		int b = 0;
		try {
			fr = new FileReader("e:/abc.txt");
			fw = new FileWriter("e:/a.txt");
			while ((b = fr.read()) != -1) {
				fw.write((char) b);
			}
			fr.close();
			fw.close();
		} catch (FileNotFoundException e1) {
			System.out.println("�ļ�û���ҵ���");
		} catch (IOException e2) {
			System.out.println("�ļ����ƴ���");
		}
		System.out.println("�ļ��Ѹ���");
		// TODO Auto-generated method stub

	}

}
