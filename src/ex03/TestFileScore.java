package ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.classfile.BufWriter;

class  Student {
	// Field
	private   int      num;
	private   String   name;
	private   int      kor;
	private   int      eng;
	private   int      mat;
	private   int      tot;
	private   double   avg;

	// 생성자
	public Student(String line) {
		String [] li  =  line.trim().split(",");
		this.num      =  Integer.parseInt( li[0].trim() );
		this.name     =  li[1].trim();
		this.kor      =  Integer.parseInt( li[2].trim() );
		this.eng      =  Integer.parseInt( li[3].trim() );
		this.mat      =  Integer.parseInt( li[4].trim() );
	}

	// toString
	@Override
	public String toString() {
		this.tot     = kor + eng + mat;
		this.avg     = this.tot / 3.0;
		String  fmt  = "%d %s %d %d %d %d %.2f";
		String  msg  = String.format(fmt, 
				num, name, kor, eng, mat ,tot, avg);  
		return  msg;
	}	
	
}

public class TestFileScore {

	public static void main(String[] args) throws IOException {
		
		// 파일 경로
		String           path       =  "D:\\hoon\\java\\PrjIO\\src\\ex03\\";
		
		String           infile     =  "score.txt";
		FileReader       fr         =  new FileReader(path + infile);
		BufferedReader   br         =  new BufferedReader(fr);  
		
		String           outfile    =  "result.txt";
		FileWriter       fw         =  new FileWriter(path + outfile);
		BufferedWriter   bw         =  new BufferedWriter( fw );
		
		br.readLine();  // 입력파일의 제목줄 skip
		String           line       =  "";
		
		String    title = "번호 이름 국어 영어 수학 총점 평균";   
		System.out.println( title );
		bw.write( title + "\n");
		
		while( (line = br.readLine() ) != null ) {
			Student   stud  = new Student( line );
			System.out.print( stud + "\n" );
			fw.write( stud.toString() + "\n" );
		}
		
		br.close();
		fr.close();
		bw.close();
		fw.close();
		

	}

}





