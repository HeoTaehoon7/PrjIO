package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zipcode05_2 {

	public static void main(String[] args) throws IOException {
		//  한국의 시도명 출력 - 17건 
		//		   서울   8080
		//		   부산   3605 
		//		   ... 
		//		   충북
	
		String         path      =  Zipcode05_2.class.getResource("").getPath();
		String         fname     =  "zipcode_utf8.csv";
		File           inFile    =  new File(path + fname);  
		if( !inFile.exists()  ) {
			System.out.println( fname + "이 없습니다");
			System.exit( -1 );
		}
		
		FileReader      fr   =   new FileReader( inFile );
		BufferedReader  br   =   new BufferedReader( fr );
		
		br.readLine();                         // 제목줄 skip
		String            line       =  "";
		int               totcnt     =  0;
		String            prevSido   =  "";
		
		long              startTime  =  System.nanoTime(); 
		 
		int               cnt        =  0;
		while( ( line = br.readLine() ) != null  ) {
			PostVo   vo     =  new PostVo( line );
			String   sido   =  vo.getSido();
			if( !sido.equals( prevSido ) ) {
				prevSido    = sido;				 
				System.out.println( sido );
				cnt++;
			}
			totcnt++;
		}
		long    endTime   =  System.nanoTime();
		double  execTime  =  (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
				
		System.out.println("도시수:"      +  cnt);
		System.out.println("전체 자료수:" +  totcnt);
		System.out.println("실행시간:"    +  execTime + " s");

	}

}







