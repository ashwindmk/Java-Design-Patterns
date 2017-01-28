package behavioral_design_patterns.mediator_pattern;

import java.util.Date;

/**
 * Created by ashwin on 28/1/17.
 */

public class MediatorPattern
{
    public static void main(String[] args)
    {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}

class User
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}

// Mediator class : Manages all messages from all users
class ChatRoom
{
    public static void showMessage(User user, String message)
    {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
