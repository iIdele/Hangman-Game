import java.util.Scanner;
public class Hangman
{
	public static int containsLetter(String word, char letter)
        {
            int count = 0;
            char s = word.charAt(0);
            for(int i = 0; i < word.length(); i++)
            {
                s = word.charAt(i);
                if(s == letter)
                {
                    count += 1;
                }
            }
            return count;
        }

        public static Boolean allDone(String word, String guess)
        {
                int count = 0;
                for(int i = 0; i < guess.length(); i++)
                {
                        if (containsLetter(word, guess.charAt(i)) > 0)
                                count = count + containsLetter(word, guess.charAt(i));
                                
                }
                System.out.println(count);
                return count == word.length();
        
        }

        public static String showLetters(String word, String guess)
        {
            String hangman = "";
            if (guess.equals(""))
            {
                for(int i = 0; i < word.length(); i++)
                    {
                        hangman = hangman + "_";
                    }
            }
            else
            {
                for(int j = 0; j < guess.length(); j++)
                {
                    for(int i = 0; i < word.length(); i++)
                    {
                        char s = word.charAt(i);
                        if(s == guess.charAt(j))
                        {
                            if (j <= 0)
                                hangman = hangman + word.substring(i,i+1);
                            else
                            {
                                hangman = hangman.substring(0,i) + word.substring(i,i+1) + hangman.substring(i+1);
                            }
                        }
                        else
                        {
                            if (j <= 0)
                                hangman = hangman + "_"; 
                            else if(j > 0 && hangman.length() == word.length())
                            {
                                hangman = hangman;
                            }   
                        }
                    }
               }
                   
            }
            return hangman;
        }

	public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        
        // First get the word
        int wordSeed = in.nextInt();

        String word = Word.getWord(wordSeed);
        System.out.println("The word is" );
        String s = showLetters(word, "");
        System.out.println(s);
        String temp = s;

        while (! word.equals(temp))
        {
        System.out.println("Guess a letter:");
        String guess = in.next();

        if(containsLetter(word,guess.charAt(0)) > 0)
        {
            s = showLetters(word,guess);
            for(int i = 0; i < word.length(); i++)
            {
                if(temp.substring(i,i+1).equals(s.substring(i,i+1)))
                    temp = temp;
                else if(! temp.substring(i,i+1).equals(s.substring(i,i+1)) && ! temp.substring(i,i+1).equals("_"))
                {
                    temp = temp;
                }
                else
                {
                    temp = temp.substring(0,i) + s.substring(i,i+1) + temp.substring(i+1);
                };
            }
        }
        System.out.println(temp);
        }

        System.out.print("Well Done, the word was " + word + ".");

        }
}