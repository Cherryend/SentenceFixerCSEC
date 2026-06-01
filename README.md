# SentenceFixerCSEC
My Computer Science Final Project:

Extra Information:
Created in JGrasp using Java + Java Swing for the GUI.
SentenceFixer --> First iteration of the sentence fixer, does not include GUI.
SentenceFixer2 --> Second iteration of the sentence fixer, includes GUI and other additional debug features.

This sentence fixer does not take context into account.
This sentence fixer should be able to:
1. Ensure terminal punctuation
2. Capitalize the first word in a sentence
3. Remove unwarranted words
4. Remove unwarranted repeated punctuation
5. Remove extra spaces

Usage Instructions
1. Download and open JGrasp
2. Open and import the code file for the sentence fixer.
3. Import the code file into Jgrasp as a new Java Project. 
4. Click run, or use the run shortcut (Command R).
5. The GUI screen will become visible, then click on the pop-up.
6. In the pop-up, select the first Box.
7. Enter (type, or copy and paste) the sentence into the first box.
8. Click the Fix Button.
9. Copy the fixed sentence, then click clear to reset the input.

Ensure Package Importation:
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

When testing the sentence fixer, use this code: 
public static String duplicates(String str){
Pattern pattern = Pattern.compile("(?i)\\b(\\w+)\\b(\\s+\\1\\b)+");
Matcher matcher = pattern.matcher(str);
return matcher.replaceAll("$1");
}

This piece of code compiles regular expressions using regex:  Pattern.compile(...), it uses different markers as variables with:
(?i) matching case-insensitive words in sentences
\\b represents the word boundary in longer words
(\\w+) matches the word and saves it as Group 1
(\\s+\\1)+ side-by-side comparison to Group 1 and finds repetition

pattern.matcher(str) links the sentence to the regex pattern
matcher.replaceAll("$1"); replaces the entire duplicate sequence with the very first occurrence. 




















PSEUDO PROGRAM SentenceFixer2:
Helper functions: 
FUNCTION capitalize(str)
IF str is null or empty THEN
RETURN str
END IF
RETURN (first character of str to uppercase) + (rest of str)

FUNCTION punctuate(str)
IF str is null or empty THEN
RETURN str
END IF
str = trim(str)                     // remove leading/trailing spaces
IF str ends with '.' OR '!' OR '?' OR '"' THEN
RETURN str
ELSE
RETURN str + '.'

FUNCTION duplicates(str)
IF str is null or empty THEN
RETURN str
END IF
// Remove duplicate consecutive words (case‑insensitive)
pattern = regex for: word boundary, capture word, then one or more repetitions of whitespace + same word
result = replace all matches in str with the first captured word
IF result == str THEN
RETURN str
ELSE
RETURN doubleSpace(result)     // clean extra spaces

FUNCTION doubleSpace(str)
IF str is null THEN
RETURN null
END IF
RETURN replace all sequences of whitespace with a single space, then trim

PROCEDURE createAndShowGUI()
SET close operation to exit

Input area
CREATE JPanel (border layout) with empty border
CREATE JLabel "Enter sentence:."
CREATE JTextField for input
ADD label and field to the panel

Output area
CREATE JPanel with empty border
CREATE JLabel "Fixed sentence:."
CREATE non‑editable JTextField for output, with a white background, and a larger size
ADD label and field to the panel

Buttons
CREATE JPanel with flow layout
CREATE JButton "Fix Sentence"
CREATE JButton "Clear"

Arrange panels in main frame: input (north), output (center), buttons (south)

On the click of "Fix Sentence."
raw = get text from input field
IF raw trimmed is empty THEN
SET output text to "Please enter a sentence."
RETURN
END IF
TRY
step1 = capitalize(raw)
step2 = punctuate(step1)
step3 = duplicates(step2)
step4 = doubleSpace(step3)
SET output text to step4
CATCH any exception
SHOW error dialogue with message
SET output text to error details
END TRY

On the click of "Clear."
SET input text to empty
SET output text to empty
GIVE focus to the input field

Final frame settings: size 550x200, center on screen, make visible

PROCEDURE main()
INVOKE SwingUtilities.invokeLater to run createAndShowGUI on the Event Dispatch Thread
