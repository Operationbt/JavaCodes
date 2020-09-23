import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

//gif파일인데 확장자가 다른 걸로 저장된 파일을 정상적으로 gif로 다시 저장해주는 프로그램
public class ExtensionChanger {
	
	//파일 헤더로 gif파일 타입인지 확인한다
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
	
	//'aaa.gif' 파일에서 이름 'aaa'만 떼오기
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

					if(checkGIF(file)) {	//파일 헤더가 gif이면 .gif붙여서 저장
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
