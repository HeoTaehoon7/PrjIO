package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.classfile.BufWriter;
import java.nio.charset.Charset;

public class TextFileScore {

	public static void main(String[] args) throws IOException {

		// 입력 파일
		String          path       = "D:/dev/java/PrjIO/src/ex02/";
		String          filename   = "data.txt";
		FileReader      fr         = new FileReader(path + filename);
		BufferedReader  br         = new BufferedReader(fr);
		
		//출력파일
		String          filename2  = "result.txt";	
		FileWriter      fw         = new FileWriter( path + filename2, true);
		// append : false 나 생략 -> 생성되는 파일이  OverWrite 된다 -> 덮어쓴다
		//       기존 파일이 존재하면 덮어쓰고 없으면 새로만듦
		// append : true          -> 생성되는 파일이  Append 된다 -> 내용이 추가
		//       기존 파일이 존재하면 추가하고 없으면 새로만듦
		
		BufferedWriter  bw         = new BufferedWriter( fw );		
		
		String          line       = "";
		br.readLine();                   // 제목줄 skip
		
		String  title   =  "번호 이름 국어 영어 수학 총점 평균\n";
		System.out.print( title );
		bw.write( title );
		
		while( (line = br.readLine()  )!= null  ) {
		     // System.out.println( line );  // 1,민지,100,90,80
			String  []  li  =  line.trim().split(",");
			int     num     =  Integer.parseInt( li[0].trim() );
			String  name    =  li[1].trim();
			int     kor     =  Integer.parseInt( li[2].trim() ); 
			int     eng     =  Integer.parseInt( li[3].trim() ); 
			int     mat     =  Integer.parseInt( li[4].trim() );
			int     tot     =  kor + eng + mat;
			double  avg     =  tot / 3.0 ;  // 소수이하 두자리로 반올림 : %.2f
			
			String  fmt     =  "%d     %s  %d %d %d  %d  %.2f\n"; 
			String  msg     =  String.format( fmt, 
					num, name, kor, eng, mat, tot, avg  );
			System.out.print( msg );
			bw.write( msg );
		}
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();

	}

}








