package bmo5.bmo5tests.tools;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
public class StringUtils {
		
	public static List<Integer> getAllIntegerNumbersFromString(String text) {
		List<Integer> listOfIntegers = new ArrayList<Integer>();
		String intNumber = "";
		char[] characters = text.toCharArray();
		boolean foundAtLeastOneInteger = false;
		for (char ch : characters) {
			if (Character.isDigit(ch)) {
				intNumber += ch;
			} else {
				if (intNumber != "") {
					foundAtLeastOneInteger = true;
					listOfIntegers.add(Integer.parseInt(intNumber));
					intNumber = "";
				}
			}
		}
		Assert.assertTrue(
				"No matching integer was found in the provided string!",
				foundAtLeastOneInteger);
		return listOfIntegers;
	}
	
	public static int randomNumber(int number) {

		double d = 0;
		int Random;
		int num = 1;
		{
			while (true) {

				int final_limit = number;
				d = Math.random() * final_limit;
				num = (int) d;
				Random = num;
				break;

			}

			return Random;
		}

	}
	
	static CharsetEncoder asciiEncoder =  Charset.forName("US-ASCII").newEncoder(); // or "ISO-8859-1" for ISO Latin 1

		  public static boolean isPureAscii(String v) {
		    return asciiEncoder.canEncode(v);
		  }
	
}
