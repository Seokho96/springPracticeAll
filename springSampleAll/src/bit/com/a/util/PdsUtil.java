package bit.com.a.util;

import java.util.Date;

public class PdsUtil {
	
	/* myfile.txt => f.indexOf('.') ->  6
	 * 파일명, 확장자명
	 * f.substring( 6 ) => .txt
	 * f.substring (0, 6) => myfile
	 * 
	 * my file.txt -> 3232332112.txt
	 */
	
	public static String getNewFileName( String f ) {
		String filename = "";
		String fpost = "";  // 파일 확장자명
		
		if(f.indexOf('.') >= 0) {   //확장자명이 있음
			fpost = f.substring(f.indexOf('.'));  // .txt (filename.txt 경우)
			filename = new Date().getTime() + fpost;     // 3434343434.txt
		}
		else {
			filename = new Date().getTime() + "back";
		}
		return filename;
	}

}
