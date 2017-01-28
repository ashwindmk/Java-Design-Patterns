package behavioral_design_patterns.template_method_pattern;

/**
 * Created by ashwin on 28/1/17.
 */
public class TemplateMethodPattern
{
    public static void main(String[] args)
    {
        Game game1 = new Cricket();
        game1.play();

        System.out.println();

        Game game2 = new Football();
        game2.play();
    }
}

abstract class Game
{
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //template method
    public final void play()
    {
        //initialize the game
        initialize();

        //start game
        startPlay();

        //end game
        endPlay();
    }
}

class Cricket extends Game
{
    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

class Football extends Game
{
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
