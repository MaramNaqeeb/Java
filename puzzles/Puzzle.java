import java.util.ArrayList;
import java.util.Random;

public class Puzzle {

  public ArrayList<Integer> getTenRolls() {
    Random rand = new Random();
    ArrayList<Integer> random = new ArrayList<Integer>();

    for (int i = 1; i <= 10; i++) {
      random.add(rand.nextInt(21));
    }

    return random;
  }

  public String getRandomLetterWithArray() {
    Random rand = new Random();

    String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    String[] alphabet = new String[26];
    for (int i = 0; i < 26; i++) {
      alphabet[i] = String.valueOf(alphabetString.charAt(i));
    }
    return alphabet[rand.nextInt(26)];
  }

  public String getRandomLetter() {
    Random rand = new Random();
    String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    char randomChar = alphabetString.charAt(rand.nextInt(26));

    return String.valueOf(randomChar);
  }

  public String generatePassword() {
    String p = "";

    for (int i = 0; i < 8; i++) {
      p = p + getRandomLetter();
    }
    return p;
  }

  public ArrayList<String> getNewPasswordSet(int length) {
    ArrayList<String> changePassword = new ArrayList<String>();
    for (int i = 0; i < length; i++) {
      changePassword.add(generatePassword());
    }
    return changePassword;
  }
}
