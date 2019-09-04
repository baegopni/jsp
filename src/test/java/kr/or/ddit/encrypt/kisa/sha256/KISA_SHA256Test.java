package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256Test {
	
	private static final Logger logger = LoggerFactory.getLogger(KISA_SHA256Test.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void encryptTest() {
		/***Given***/
		String  pass = "brown1234";

		/***When***/
		String encryptedPass = KISA_SHA256.encrypt(pass);
		logger.debug("encryptedPass : {}", encryptedPass);
		
		/***Then***/
		//assertEquals("예상값", "실제값");
	}

}
