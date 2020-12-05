import java.io.FileNotFoundException;

public class AdventOfCode2020 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new Expenses().multiplyTheTwoEntriesWhichSumTo2020());
        System.out.println(new Expenses().multiplyTheThreeEntriesWhichSumTo2020());
        System.out.println(new Passwords().totalValid());
    }
}
