package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String inputStr;	//입력받은 문자열
		int inputNum;		
		int[][] ladder=new int[11][7];	//사다리 정보 Array. 0번 row, column은 더미.
		//사다리 정보 입력
		System.out.println("사다리 정보를 입력하세요(x는 입력 완료).");
		for(int i=0;i<60;i++) {
			inputStr=reader.readLine();
			if(inputStr.equals("x")) {
				break;
			}else {
				String[] line=inputStr.split(" ");
				int ladderRow=Integer.parseInt(line[0]);
				int ladderCol=Integer.parseInt(line[1]);
				ladder[ladderRow][ladderCol]=1;
			}
		}
		//사다리 게임
		System.out.println("사다리 게임을 시작할 출발 지점을 입력하세요(x는 입력 완료).");
		while((inputStr=reader.readLine())!=null) {
			if(inputStr.equals("x")) break;
			inputNum=Integer.parseInt(inputStr);
			int col=inputNum;
			for(int row=0;row<11;row++) {
				if(ladder[row][col]==0) {
					if(ladder[row][col-1]==1) {
						col=col-1;
					}
				}else {
					col=col+1;
				}
			}			
			System.out.println(col);
		}
		reader.close();
	}
}
