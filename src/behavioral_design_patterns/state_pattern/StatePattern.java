package behavioral_design_patterns.state_pattern;

/**
 * Created by ashwin on 28/1/17.
 */

public class StatePattern
{
    public static void main(String[] args)
    {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}

interface State {
    public void doAction(Context context);
}

class StartState implements State
{
    public void doAction(Context context) {
        System.out.println("\nStarting...");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}

class StopState implements State
{
    public void doAction(Context context) {
        System.out.println("\nStopping...");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}

class Context
{
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
