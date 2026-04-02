package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

interface  Ipo {
	void  input( String fname ) throws FileNotFoundException, IOException;
	void  process();
	void  output();
}

class  ZipcodeMap implements Ipo {
	
	FileReader        fr;
	BufferedReader    br;
	
	Map<String, Integer>  sidoMap  =  new TreeMap<>(); 
	int                   totCnt   =  0;
	
	List<String>          sidos    =  new  ArrayList<>();  // 순서유지용 배열
	
	@Override
	public void input(String fname) throws IOException {
		
		fr  =  new FileReader( fname );
		br  =  new BufferedReader( fr );
		
		String   prevSido = "";
		
		br.readLine();
		String line = "";
		while( (line = br.readLine()) != null ) {			
			PostVo   vo       =  new PostVo( line );
			String   sido     =  vo.getSido();
			
			if( !sido.equals( prevSido ) ) {
				sidos.add( sido );
				prevSido = sido;
			}
			
			sidoMap.put( sido, sidoMap.getOrDefault( sido, 0 ) + 1 );
			totCnt++;
		} 
		
		br.close();
		fr.close();
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void output() {
		
		/*
		for (Map.Entry<String, Integer> sidoList : sidoMap.entrySet()) {
			String   key  = sidoList.getKey();
			Integer  val  = sidoList.getValue();
			
			System.out.println( key + "=" + val  );
			
		}
		*/
		
		for (String sido : sidos) {
			int     val   =  sidoMap.get( sido  );
			System.out.println( sido + "=" + val  );
		}
		
		
		System.out.println( "총 " + totCnt + " 건"  );
		
	}

}

public class Zipcode05_4  {

	// Map 사용
	public static void main(String[] args) throws IOException {
		ZipcodeMap  zMap  = new ZipcodeMap();
		
		String      path   = ZipcodeMap.class.getResource("").getPath();
		String      fname  = "zipcode_utf8.csv";
		
		zMap.input( path + fname  );
		zMap.process();
		zMap.output();
	}


}







