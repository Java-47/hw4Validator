package telran.validator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.validator.utils.Validator.*;

class ValidatorTest {

	@Test
	void testCheckCreditCardNumber() {
		assertTrue(checkCreditCardNumber("12345678"));
		assertTrue(checkCreditCardNumber("123456789"));
		assertTrue(checkCreditCardNumber("1234567890123456"));
		assertFalse(checkCreditCardNumber("1234567"));
		assertFalse(checkCreditCardNumber("12345678901234567"));
		assertFalse(checkCreditCardNumber("1234567A"));
	}

	@Test
	void testCheckDateFormatEU() {
		assertTrue(checkDateFormatEU("31.12.1970"));
		assertFalse(checkDateFormatEU("32.12.1970"));
		assertFalse(checkDateFormatEU("31.13.1970"));
		assertFalse(checkDateFormatEU("31.22.1970"));
		assertFalse(checkDateFormatEU("32.22.1970"));

		}

	@Test
	void testCheckDateFormatUS() {
		assertTrue(checkDateFormatUS("1970.12.31"));
		assertFalse(checkDateFormatUS("1970.12.32"));
		assertFalse(checkDateFormatUS("1970.13.31"));
		assertFalse(checkDateFormatUS("1970.22.31"));
		assertFalse(checkDateFormatUS("1970.22.32"));

	}

	@Test
	void testCheckPhoneNumber() {
		assertTrue(checkPhoneNumber("+99(99)9999-9999"));
		assertFalse(checkPhoneNumber("+09(99)9999-9999"));
		assertFalse(checkPhoneNumber("+99(99)9999-99992"));
		assertFalse(checkPhoneNumber("+9999)9999-9999"));
		assertFalse(checkPhoneNumber("+992(99)9999-99992"));
		assertFalse(checkPhoneNumber("+99(996)9999-9999"));
		assertFalse(checkPhoneNumber("+99(996)99995-9999"));

	}

	@Test
	void testCheckLessEquals255() {
		assertTrue(checkLessEquals255("1"));
		assertTrue(checkLessEquals255("0"));
		assertTrue(checkLessEquals255("99"));
		assertTrue(checkLessEquals255("255"));
		assertFalse(checkLessEquals255("-1"));
		assertFalse(checkLessEquals255("256"));
	}

}
