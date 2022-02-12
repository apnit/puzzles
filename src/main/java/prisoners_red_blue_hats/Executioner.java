package prisoners_red_blue_hats;

import java.util.ArrayList;

/**
 * The executioner that will iterate over the prisoners and asks each of them.
 *
 * @author Alireza Jafartash
 */
public class Executioner {

    /**
     * <p>Executioner asks the specified prisoner and returns the answer.</p>
     *
     * <p>The observation and history is passed to the prisoner as its
     * perception from the environment.</p>
     *
     * <p>If the answer was wrong. The prisoner will be executed.</p>
     *
     * @param prisoner    the current prisoner that must guess the
     * @param observation the hat color of the front prisoners
     * @param history     the answers of the prisoners
     * @return the answer of the prisoner that was asked
     */
    public HatColor ask(Prisoner prisoner, ArrayList<HatColor> observation,
                        ArrayList<HatColor> history) {
        HatColor answer = prisoner.guess(observation, history);

        if (!answer.equals(prisoner.getHatColor())) {
            // If the answer is wrong it must be executed.
            prisoner.die();
        }

        return answer;
    }

}
