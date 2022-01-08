package torpedo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This is my first Torpedo game.
 *
 * @author Palla Gergely
 * @version 1.0
 */

public class Main {
    /**
     * This is the main method. Some kind of handy description goes here.
     *
     * @param args The command line arguments.
     */

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("Torpedo");
    }
}