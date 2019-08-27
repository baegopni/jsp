package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileuploadUtil {

	public static String getFilename(String contentDisposition) {
		// 메소드인자 : "form-data; name=\"file\"; filename=\"brown.png\"";
		String[] attrs = contentDisposition.split("; ");
		
		//attrs[0] = form-data
		//attrs[1] = name="file"
			// '='를 기준으로 나눔
			// keyValue[0] = filename
			// keyValue[1] = "brown.png"
		//attrs[2] = filename="brown.png"

		String filename = "";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyValue = attr.split("=");
				filename = keyValue[1].substring(keyValue[1].indexOf("\"")+1,
												keyValue[1].lastIndexOf("\""));
				break;
			}
		}
		return filename;
	}
	

	public static String getFileExtension(String contentDisposition) {
		String filename = getFilename(contentDisposition);
		
		if(filename.lastIndexOf(".") > 0) return filename.substring(filename.lastIndexOf("."),
												 filename.length());
		else return "";
	}

	
	/**
	 * 
	 * Method   : getPath
	 * 작성자 : PC-19
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 파일을 업로드할 경로를 조회한다.
	 */
	public static String getPath() {
		String basicPath = "d:\\upload";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date()); //201908
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		File yyyyDirectory = new File(basicPath + "\\" + yyyy + "\\" + mm);
		if(!yyyyDirectory.exists()) yyyyDirectory.mkdirs();
		
		// d:\\upload\\2019\\08\\
		return basicPath + "\\" + yyyy + "\\" + mm + "\\";
	}



}
