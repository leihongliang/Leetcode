package DesignPatterns;

abstract class Animal {
    public abstract void sound();
}
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("汪汪汪");
    }
}
// 创建一个工厂类
class AnimalFactory {
    // 定义一个静态方法，根据传入的参数创建具体的产品类对象
    public static Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else {
            throw new IllegalArgumentException("Invalid animal type: " + type);
        }
    }
}
// 客户端代码
public class simpleFactory {
    public static void main(String[] args) {
        // 使用工厂类创建不同的 Animal 对象
        Animal dog = AnimalFactory.createAnimal("dog");
        dog.sound();
    }
}
