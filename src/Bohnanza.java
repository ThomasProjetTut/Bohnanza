import Multijoueurs.EvaluationMessages;
import controller.Controlleur;
import org.jsfml.graphics.TextureCreationException;

import java.io.IOException;

public class Bohnanza {

    public static EvaluationMessages Eval;

    public static void main(String[] args) throws InterruptedException, IOException, TextureCreationException {

        Controlleur controlleur = new Controlleur();
        Eval = new EvaluationMessages(controlleur);
    }
}

