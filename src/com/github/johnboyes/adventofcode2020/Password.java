
public class Password {

        private String passwordValue;
        private char requiredChar;
        private int minOccurrences;
        private int maxOccurrences;

        public Password(String rawPasswordData) {
                String[] separated = rawPasswordData.split(" ");
                passwordValue = separated[2];
                requiredChar = separated[1].charAt(0);
                String[] occurrencesRange = separated[0].split("-");
                minOccurrences = Integer.valueOf(occurrencesRange[0]);
                maxOccurrences = Integer.valueOf(occurrencesRange[1]);
        }

        public boolean isValid() {
                long occurrences = passwordValue.chars().filter(ch -> ch == requiredChar).count();
                return (occurrences >= minOccurrences) && (occurrences <= maxOccurrences);
        }

}
