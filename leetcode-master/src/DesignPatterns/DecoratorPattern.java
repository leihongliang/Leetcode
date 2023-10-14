package DesignPatterns;
//抽象构件角色
interface Component {
    public void sampleOpreation();
}
//具体构件角色：
class ConcreteComponent implements Component {
    @Override
    public void sampleOpreation() {
        System.out.println("ConcreteComponent");
    }
}
//装饰角色
class Decorator1 implements Component {
    private Component component;

    public Decorator1(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOpreation() {
        //委派给构件
        component.sampleOpreation();
        System.out.println("Decorator1");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator = new Decorator1(component);
        decorator.sampleOpreation();
    }
}
