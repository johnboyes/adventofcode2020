
public class Password {

        private String passwordValue;
        private char requiredChar;
        private int minOccurrences;
        private int maxOccurrences;

        public Password(String rawPasswordData) {
                // TODO extract the values from the passwords text file properly
                String[] split = rawPasswordData.split(" ");
                passwordValue = split[2];
                requiredChar = split[1].charAt(0);
                minOccurrences = 1;
                maxOccurrences = 3;
        }

        public boolean isValid() {
                long occurrences = passwordValue.chars().filter(ch -> ch == requiredChar).count();
                return (occurrences >= minOccurrences) && (occurrences <= maxOccurrences);
        }

}
