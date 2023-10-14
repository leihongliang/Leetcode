package DesignPatterns;
import java.util.ArrayList;
import java.util.List;

// 主题接口
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 观察者接口
interface Observer {
    void update(String message);
}

class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // 当主题状态发生改变时，通知所有观察者
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        // 创建主题
        ConcreteSubject subject = new ConcreteSubject();

        // 创建观察者
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        // 注册观察者
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // 主题状态发生改变，通知观察者
        subject.setMessage("New message!");

        // 移除观察者
        subject.removeObserver(observer1);

        // 主题状态再次改变，通知观察者
        subject.setMessage("Another message!");
    }
}
