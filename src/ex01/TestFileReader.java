package ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
	
	// java 는 예외처리 필수 - 반드시 throws, try ~ catch
	// 1. IO
	// 2. Conversion 
	public static void main(String[] args) throws IOException {

		String         path      =  "D:\\hoon\\java\\PrjIO\\src\\ex01\\";
		String           filename  =  "bts.txt";
		
		
		FileReader       fr        =  new FileReader(path + filename);
		BufferedReader   br        =  new BufferedReader( fr );
		
		// 반복 갯수를 모드는 반복 : while() EOF : End Of File
		String         line      = "";
		
		while ( (line = br.readLine() ) != null ) {
			System.out.println( line );			
		}
		
		br.close();
		fr.close();
		
		System.out.println("End....");
	

	}

}







