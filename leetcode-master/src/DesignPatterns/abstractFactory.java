package DesignPatterns;


// 创建一个抽象产品类
abstract class Animal02 {
    public abstract void sound();
}

// 创建具体产品类，继承自 Animal 类
class Dog02 extends Animal02 {
    @Override
    public void sound() {
        System.out.println("汪汪汪");
    }
}

abstract class AnimalFactory02 {
    // 定义一个抽象方法，用于创建 Animal 对象
    public abstract Animal02 createAnimal();
}

// 创建具体工厂类，实现创建 Animal 对象的接口
class DogFactory02 extends AnimalFactory02 {
    @Override
    public Animal02 createAnimal() {
        return new Dog02();
    }
}
// 客户端代码
public class abstractFactory {
    public static void main(String[] args) {
        // 创建一个 Dog 对象
        AnimalFactory02 dogFactory = new DogFactory02();
        Animal02 dog = dogFactory.createAnimal();
        dog.sound();
    }
}
