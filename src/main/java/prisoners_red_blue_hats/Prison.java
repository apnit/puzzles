package prisoners_red_blue_hats;

import com.github.javafaker.Faker;
import utils.ProgressCounter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Prison is container and simulator of this puzzle. The main method is
 * called as the entry point.
 *
 * <p>The size of the prison is stored in {@code size}. The {@code prisoners}
 * contains the prisoners objects.</p>
 *
 * <p>The run method makes the execution process started.</p>
 *
 * @author Alireza Jafartash
 */
public class Prison {
    /**
     * The number of prisoners
     */
    private final int size;

    /**
     * The prisoners list
     */
    private final ArrayList<Prisoner> prisoners;

    /**
     * Makes a prison with specified number of prisoners
     *
     * @param size the number of prisoners that must be generated
     */
    public Prison(int size) {
        this.size = size;

        this.prisoners = generatePrisoners(size);
    }

    /**
     * The test driven constructor
     *
     * @param prisoners the test prisoners
     */
    public Prison(ArrayList<Prisoner> prisoners) {
        this.size = prisoners.size();
        this.prisoners = prisoners;
    }

    /**
     * Main entry
     */
    public static void main(String[] args) {
        long best = 0;
        long worst = 100;
        double average = 0;
        int times = 1000;

        for (int i = 0; i < times; i++) {
            ProgressCounter.count(i + 1, times);

            Prison prison = new Prison(100);

            long result = prison.run();

            best = Math.max(best, result);
            worst = Math.min(worst, result);
            average += (double) result / times;
        }

        // Statistical Info
        System.out.printf("Your best answer: %d\n", best);
        System.out.printf("Your worst answer: %d\n", worst);
        System.out.printf("Your average answer: %.2f\n", average);
    }

    /**
     * Generates a list of random prisoners with specified size
     *
     * @param size the size of the list to generate
     * @return the list of random prisoners with specified size
     */
    private ArrayList<Prisoner> generatePrisoners(int size) {
        Faker faker = new Faker();
        ArrayList<Prisoner> prisoners = new ArrayList<>();

        Set<String> names = new HashSet<>();
        String name;

        for (int i = 0; i < size; i++) {
            name = faker.name().firstName();

            while (names.contains(name)) {
                name = faker.name().firstName();
            }

            names.add(name);

            prisoners.add(new Prisoner(
                    HatColor.randomColor(),
                    name
            ));
        }

        return prisoners;
    }

    /**
     * Start the simulation batch
     *
     * @return the number of alive prisoners after the executioner finished
     * his job.
     */
    public long run() {
        ArrayList<HatColor> observation = new ArrayList<>(prisoners.stream()
                .map(Prisoner::getHatColor)
                .toList());

        ArrayList<HatColor> history = new ArrayList<>();

        Executioner executioner = new Executioner();

        for (int i = 0; i < size; i++) {
            HatColor answer = executioner.ask(prisoners.get(i), observation,
                    history);

            observation.remove(0);
            history.add(answer);
        }

        return prisoners.stream()
                .filter(Prisoner::isAlive)
                .count();
    }
}
