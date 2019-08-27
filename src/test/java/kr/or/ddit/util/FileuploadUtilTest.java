package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileuploadUtilTest {

	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * 
	 * Method   : getFilenameTest
	 * 작성자 : PC-19
	 * 변경이력 :  
	 * Method 설명 : Content-disposition 헤더 문자열로부터 파일이름 추출 테스트
	 */
	@Test
	public void getFilenameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";
		String contentDisposition2 = "form-data; name=\"file\"; filename=\"brown.png\"";
		

		/***When***/
		String filename = FileuploadUtil.getFilename(contentDisposition);
		String filename2 = FileuploadUtil.getFilename(contentDisposition);

		/***Then***/
		assertEquals("brown.png", filename);
		assertEquals("moon.png", filename2);
	}

	/**
	 * 
	 * Method   : getFileExtentionTest
	 * 작성자 : PC-19
	 * 변경이력 :  
	 * Method 설명 : Content-disposition 헤더 문자열로부터 파일 확장자 추출 테스트
	 */
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";
		String contentDisposition2 = "form-data; name=\"file\"; filename=\"moon.png\"";
		String contentDisposition3 = "form-data; name=\"file\"; filename=\"brown\"";
		

		/***When***/
		String fileExtensionName = FileuploadUtil.getFileExtension(contentDisposition);
		String fileExtensionName2 = FileuploadUtil.getFileExtension(contentDisposition);
		String fileExtensionName3 = FileuploadUtil.getFileExtension(contentDisposition);

		/***Then***/
		assertEquals(".png", fileExtensionName);
		assertEquals(".png", fileExtensionName2);
		assertEquals("", fileExtensionName3);
	}
	
	
	/**
	 * 
	 * Method   : getPathTest
	 * 작성자 : PC-19
	 * 변경이력 :  
	 * Method 설명 : 파일 업로드 경로 조회 테스트
	 */
	@Test
	public void getPathTest() {
		/***Given***/
	
		/***When***/
		String path = FileuploadUtil.getPath();
		
		/***Then***/
		assertEquals("d:\\upload\\2019\\08\\", path);
	}
}
