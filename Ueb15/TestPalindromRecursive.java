package testPalindrom;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import aufgabe15.Palindrom;
import aufgabe15.PalindromRekursiv;

public class TestPalindromRecursive {
	@Test
	void testOneWordPalindrom() {
		Palindrom obj = new PalindromRekursiv();
		boolean result = obj.istPalindrom("a");
		assertEquals(result, true);
	}
	@Test
	void testEvenPalindrom() {
		Palindrom obj = new PalindromRekursiv();
		boolean result = obj.istPalindrom("abba");
		assertEquals(result, true);
	}
	@Test
	void testOddPalindrom() {
		Palindrom obj = new PalindromRekursiv();
		boolean result = obj.istPalindrom("aba");
		assertEquals(result, true);
	}
	@Test
	void testOddNotPalindrom() {
		Palindrom obj = new PalindromRekursiv();
		boolean result = obj.istPalindrom("abb");
		assertEquals(result, false);
	}
	@Test
	void testEvenNotPalindrom() {
		Palindrom obj = new PalindromRekursiv();
		boolean result = obj.istPalindrom("abbbas");
		assertEquals(result, false);
	}
	@Test
	void testEqualIgonereCase() {
		Palindrom obj = new PalindromRekursiv();
		boolean result = obj.istPalindrom("abBA");
		assertEquals(result, true);
	}
}
