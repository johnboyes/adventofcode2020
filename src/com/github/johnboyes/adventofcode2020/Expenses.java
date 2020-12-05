import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Expenses {

    private List<Integer> expenseEntries = new ArrayList<Integer>();

    public Expenses() throws FileNotFoundException {
        initialiseExpenses();
    }

    public int multiplyTheTwoEntriesWhichSumTo2020() {
        return findTheTwoExpensesWhichSumTo2020().stream().reduce(1, (a, b) -> a * b);
    }

    private List<Integer> findTheTwoExpensesWhichSumTo2020() {
        return expenseEntries.stream()
            .flatMap(
                value1 -> expenseEntries.stream()
                    .filter(value2 -> (value1 > value2))
                    .filter(value2 -> (value1 + value2 == 2020))
                    .map(value2 -> List.of(value1, value2))
            ).findAny().orElseThrow(() -> new IllegalStateException());
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
