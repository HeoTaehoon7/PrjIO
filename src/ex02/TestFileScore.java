package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.classfile.BufWriter;

public class TestFileScore {

	public static void main(String[] args) throws IOException {
		
		// 파일 경로
		String           path       =  "D:\\hoon\\java\\PrjIO\\src\\ex02\\";
		
		// 입력파일
		String           infile     =  "score.txt";
		FileReader       fr         =  new FileReader( path + infile );
		BufferedReader   br         =  new BufferedReader( fr );
		
		// 출력파일
		String           outfile    =  "result.txt";
		FileWriter       fw         =  new FileWriter( path + outfile);
		BufferedWriter   bw         =  new BufferedWriter(fw);        

		String           line       =  ""; 
		// 제목줄 첫줄을 skip 
		String           header     =  br.readLine();  // header 줄 읽기
		// System.out.println( header );
		String           title      =  "번호  이름  국어  수학  영어  총점 평균";
		System.out.println(title);
		bw.write(title + "\n");
						
		while( ( line = br.readLine() ) != null ) {
			String  []   li     =  line.trim().split(",");
			int          num    =  Integer.parseInt(li[0].trim()) ;
			String       name   =  li[1].trim();
			int          kor    =  Integer.parseInt(li[2].trim()) ;
			int          eng    =  Integer.parseInt(li[3].trim()) ;
			int          mat    =  Integer.parseInt(li[4].trim()) ;
			
			int          tot    =  kor + eng + mat;
			double       avg    =  (double) tot / 3.0;
		
			String       fmt    =  "%d %s %d %d %d %d %.2f";
			String       msg    =  String.format(fmt, 
					num, name, kor, eng, mat, tot, avg);
			System.out.println( msg );
			
			bw.write(msg + "\n");
		}
		
		br.close();
		bw.close();
		fr.close();
		fw.close();
		
		System.out.println("End ...");
	}

}



















