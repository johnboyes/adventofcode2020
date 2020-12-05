import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Expenses {

    private List<Integer> expenseEntries = new ArrayList<Integer>();

    public Expenses() throws FileNotFoundException {
        initialiseExpenses();
    }

    public int multiplyTheTwoEntriesWhichSumTo2020() {
        return findTheTwoExpensesWhichSumTo2020().stream().reduce(1, (a, b) -> a * b);
    }

    private List<Integer> findTheTwoExpensesWhichSumTo2020() {
        for (int entry : expenseEntries) {
            List<Integer> candidates = expenseEntries.stream().filter(e -> (e != entry)).collect(Collectors.toList());
            for (int candidate : candidates) {
                if (entry + candidate == 2020) return List.of(entry, candidate);
            }
        }
        throw new IllegalStateException();
    }

    // https://www.baeldung.com/reading-file-in-java#read-file-with-scanner
    private void initialiseExpenses() throws FileNotFoundException {
        String expenseEntriesFile = "resources/com/github/johnboyes/adventofcode2020/expense-entries.txt";
        Scanner scanner = new Scanner(new File(expenseEntriesFile));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            expenseEntries.add(Integer.valueOf(scanner.next()));
        }
    }
    
}
