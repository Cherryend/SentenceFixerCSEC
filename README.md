# SentenceFixerCSEC
Problem Description:

Effective written communication depends heavily on correct grammar. Poor grammar leads to ambiguous sentences, reduced readability, and unintended miscommunication. In professional, academic writing, and everyday contexts, grammar errors can make a writer seem less educated or credible.

I have bad grammar. I admit that openly because it’s something I want to improve. Grammar is a big part of my everyday life; good grammar is important for making my work in or outside of school more effective. I write for many classes, such as computer science, robotics, multimedia, English, chemistry, physics, history, and so much more. Each class requires me to explain complex ideas clearly, and when my grammar is weak, my ideas don’t come across as strongly. That frustrates me, because I know what I want to say, but the structure of my sentences sometimes fails me.

To make sure this is an achievable topic for my project, I’m not going to make the algorithm consider context in the sentences. Understanding context would require natural language processing far beyond the scope of this lab. Instead, I will focus on terminal grammar rules—things like capitalization, end punctuation, and duplicate word removal. These are concrete, pattern‑based problems that I can solve with regular expressions and simple string processing.

My goal here is to learn something new and make the most of it, in addition to reviewing my language skills. I want to leave this project with a better understanding of both Java programming (especially GUI development with Swing) and the grammar rules I struggle with. To solve this problem, I will use pattern recognition algorithms to find, correct, and replace words or punctuation based on terminal grammar rules. This approach keeps my project realistic while still giving me a useful tool to fix my most common mistakes.

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
3. Import the code file in Jgrasp as new Java Project. 
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

More on testing code: 
This piece of code compiles regular expressions using regex:  Pattern.compile(...), it uses different markers as variables with:
(?i) matching case-insensitive words in sentences
\\b represents the word boundary in longer words
(\\w+) matches the word and saves it as Group 1
(\\s+\\1)+ side-by-side comparison to Group 1 and finds repetition

pattern.matcher(str) links the sentence to the regex pattern
matcher.replaceAll("$1"); replaces the entire duplicate sequence with the very first occurrence. 

What I Learned in this lab:
1. Getting components to align and size correctly took trial and error. I now understand layout managers (BorderLayout, FlowLayout) better, and why SwingUtilities.invokeLater is necessary.
2. The duplicate word remover works for simple cases, but I discovered that punctuation or mixed case breaks it. Next time I would use a loop + split or a more robust pattern.
3. Fixing a sentence in the wrong order (e.g., punctuating before capitalizing) can produce odd results. I chose capitalize --> punctuate --> duplicates --> doubleSpace. That works for most examples.
4. Wrapping the processing logic in try-catch and showing a pop-up prevents the whole application from crashing. I also printed the stack trace for debugging – very helpful.
5. This project taught me that even a “simple” sentence fixer has many hidden edge cases. Completing the GUI felt like a big win because Swing was not something I was taught. I’m happy that the code is modular, handles basic errors, and that the user can see the fixed sentence instantly. With more time, I would love to add the dictionary and learning features I mentioned earlier, that would turn a lab assignment into a genuinely useful tool.

Potential Improvements: 
Spelling awareness: understand how words are formed so I can fix 'hte' into 'the' using a dictionary or edit distance.
Custom dictionary: let the user add accepted words or corrections, stored permanently.
Better duplicate detection: handle punctuation and preserve correct capitalization.
Multi‑sentence support: splits on ., !, ? and fixes each part of a sentence separately.


















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
