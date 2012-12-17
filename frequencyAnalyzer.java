/* 
 * Frequency analyzer for cryptanalysis.
 * jmh
 */

import java.util.Scanner;

public class frequencyAnalyzer {

	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
		if (args.length == 1)
			output(countsingle(args[0]));
        /* If no args, uses standard input to get text. */
		else if (args.length == 0)
            output(countsingle(input.next()));
        else
            System.out.println("Too many arguments");
	}

	public static int[] countsingle(String text) {

        /* Array index out of bounds at 26. No idea why. */
        int[] freq = new int[27];
        
        text = text.toLowerCase();
        for (int i = 0; i <= text.length() - 1; i++) {
            if (Character.isLetter(text.charAt(i))) {
                freq[((int)text.charAt(i))-0x61]++;
                freq[26]++;
            }
        }
        return freq;
	}

	public static void output(int[] freq) {
        
        char curLetter;
        
        System.out.println("Total number of letters : " + freq[26] + "\n");
        for (int i = 0; i <= 25; i++) {
            curLetter = (char)(i + 0x61);
            System.out.println(curLetter + " - " +
              freq[i]);
        }
	}
}
