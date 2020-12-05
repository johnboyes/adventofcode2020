import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdventOfCode2020 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> expenseEntries = expenseEntries();
        for (int entry : expenseEntries) {
            List<Integer> candidates = expenseEntries.stream().filter(e -> (e != entry)).collect(Collectors.toList());
            for (int candidate : candidates) {
                if (entry + candidate == 2020) {
                    System.out.println(entry * candidate);
                    return;
                }
            }
        }
    }

    // https://www.baeldung.com/reading-file-in-java#read-file-with-scanner
    private static List<Integer> expenseEntries() throws FileNotFoundException {
        List<Integer> expenseEntries = new ArrayList<Integer>();
        String expenseEntriesFile = "resources/com/github/johnboyes/adventofcode2020/expense-entries.txt";
        Scanner scanner = new Scanner(new File(expenseEntriesFile));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            expenseEntries.add(Integer.valueOf(scanner.next()));
        }
        return expenseEntries;
    }
}
