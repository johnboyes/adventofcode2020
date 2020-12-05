import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passwords {

    private List<Password> passwords = new ArrayList<Password>();

    public Passwords() throws FileNotFoundException {
        loadPasswords();
    }

	public long totalValid() {
		return passwords.stream().filter(password -> password.isValid()).count();
    }
    
    // https://www.baeldung.com/reading-file-in-java#read-file-with-scanner
    private void loadPasswords() throws FileNotFoundException {
        String passwordsFile = "resources/com/github/johnboyes/adventofcode2020/day2/passwords.txt";
        Scanner scanner = new Scanner(new File(passwordsFile));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            passwords.add(new Password(scanner.next()));
        }
    }

}
