import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passwords {

    private List<String> passwords = new ArrayList<String>();

    public Passwords() throws FileNotFoundException {
        loadPasswords();
    }

	public int totalValid() {
		return passwords.size();
    }
    
    // https://www.baeldung.com/reading-file-in-java#read-file-with-scanner
    private void loadPasswords() throws FileNotFoundException {
        String passwordsFile = "resources/com/github/johnboyes/adventofcode2020/day2/passwords.txt";
        Scanner scanner = new Scanner(new File(passwordsFile));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            passwords.add(scanner.next());
        }
    }

}
