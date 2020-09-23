import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

//gif�����ε� Ȯ���ڰ� �ٸ� �ɷ� ����� ������ ���������� gif�� �ٽ� �������ִ� ���α׷�
public class ExtensionChanger {
	
	//���� ����� gif���� Ÿ������ Ȯ���Ѵ�
	public static boolean checkGIF(File f) {
		int[] header = new int[3];
		boolean check = false;
		try {
			FileInputStream fBytes = new FileInputStream(f);
			for(int i = 0; i < 3; i++) {
				header[i] = fBytes.read();
				
			}
			if(header[0] == 71 && header[1] == 73 && header[2] == 70) {
				check = true;
			}
			fBytes.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return check;
		
	}
	
	//'aaa.gif' ���Ͽ��� �̸� 'aaa'�� ������
	public static String getName(String s) {
		int dot = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == '.') {
				dot = i;
				break;
			}
		}
		
		String name = s.substring(0, dot);
		
		return name;
	}
	
	public static void main(String[] args) {

	
		Scanner sc = new Scanner(System.in);
		String dir;
		
		dir = sc.nextLine();

		
		try {
			for(File file : new File(dir).listFiles()) {
				
				if(file.isFile()) {
					//System.out.println(file.getName());
					String name = getName(file.getName());

					if(checkGIF(file)) {	//���� ����� gif�̸� .gif�ٿ��� ����
						System.out.println(name + " is GIF");
						file.renameTo(new File(dir, name + ".gif"));
						
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
