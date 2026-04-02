package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zipcode05_3 {

	public static void main(String[] args) throws IOException {
		//  한국의 시도명 출력 - 17건 
		//		   서울   8080
		//		   부산   3605 
		//		   ... 
		//		   충북
		
		List<String>   sidoList     =  new ArrayList<>(); 
		List<Integer>  sidoCntList  =  new ArrayList<>(); 
				
	
		String         path      =  Zipcode05_3.class.getResource("").getPath();
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
		int               totcnt     =  0;     // 전체 자료수
		int               pos        =  -1;     // 시도 갯수
		int               sidoCnt    =  0;     // 시도별 주소수
		String            prevSido   =  "";
		
		long              startTime  =  System.nanoTime(); 
		 
		while( ( line = br.readLine() ) != null  ) {
			PostVo   vo     =  new PostVo( line );
			String   sido   =  vo.getSido();
			
			if( !sido.equals( prevSido ) ) {
				sidoList.add( sido );
				sidoCntList.add( 1 );
				prevSido    = sido;				 
				// System.out.println( sido );
				pos++;       // 시도갯수
			} else {
				sidoCnt     =  sidoCntList.get( pos ) + 1 ;   // 시도별 주소수
				sidoCntList.set(pos, sidoCnt); 
			}			
			totcnt++;
		}
		long    endTime   =  System.nanoTime();
		double  execTime  =  (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		// 출력
		for (int i = 0; i < sidoList.size(); i++) {
			System.out.println( 
				sidoList.get(i) + "=" + sidoCntList.get(i)  );
		}
				
		System.out.println("도시수:"      +  (pos + 1) );
		System.out.println("전체 자료수:" +  totcnt);
		System.out.println("실행시간:"    +  execTime + " s");

	}

}







