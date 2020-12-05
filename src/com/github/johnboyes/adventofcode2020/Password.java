

public class Password {

	private String passwordValue;
    private char requiredChar;
    private int minOccurrences;
    private int maxOccurrences;

    public Password(String rawPasswordData) {
        // TODO extract the values from the passwords text file properly
        passwordValue = "";
        requiredChar = 'c';
        minOccurrences = 1;
        maxOccurrences = 3;
	}

	public boolean isValid() {
        long occurrences = passwordValue.chars().filter(ch -> ch == requiredChar).count();
        return (occurrences >= minOccurrences) && (occurrences <= maxOccurrences);
	}

}