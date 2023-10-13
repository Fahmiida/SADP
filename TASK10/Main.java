/*Youtube platform follows a pattern that lets you define a subscription mechanism to notify multiple objects about any 
events that happen to the object they’re observing.Design this pattern  */


import java.util.ArrayList;
import java.util.List;


interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String post);
}


class Channel implements Subject {
    private String username;
    private List<Observer> subscribers;
    private String latestPost;

    public Channel(String username) {
        this.username = username;
        this.subscribers = new ArrayList<>();
    }

    public void postUpdate(String post) {
        latestPost = post;
        notifyObservers(post);
    }

    @Override
    public void registerObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String post) {
        for (Observer follower : subscribers) {
            follower.update(username, post);
        }
    }
}


interface Observer {
    void update(String username, String post);
}

class Subscriber implements Observer {
    private String subscribername;

    public Subscriber(String subscribername) {
        this.subscribername = subscribername;
    }

    @Override
    public void update(String username, String post) {
        System.out.println(subscribername + " received an update from " + username + ":");
        System.out.println(post);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
      
        Channel Curlytales = new Channel("Curlytales");
        Channel Filtercpy = new Channel("Filtercpy");

   
        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");

        Curlytales.registerObserver(subscriber1);
        Curlytales.registerObserver(subscriber2);
        Filtercpy.registerObserver(subscriber2);

      
        Curlytales.postUpdate("WELCOME to our channel.");
        Filtercpy.postUpdate("will upload the vlog tomorrow at 9'o clock");

        Curlytales.removeObserver(subscriber1);

        
        Curlytales.postUpdate("Guys we have an exiciting news for you all");

        
    }
}