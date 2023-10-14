package DesignPatterns;

interface Strategy { void sort(int[] arr);}
class BubbleSort implements Strategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("1.BubbleSort");
    }
}
class QuickSort implements Strategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("2.QuickSort");
    }
}

class Context {
    private Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        // 使用冒泡排序策略
        Strategy bubbleSortStrategy = new BubbleSort();
        Context context = new Context();
        context.setStrategy(bubbleSortStrategy);
        context.executeStrategy(arr);
        // 使用快速排序策略
        Strategy quickSortStrategy = new QuickSort();
        context.setStrategy(quickSortStrategy);
        context.executeStrategy(arr);

    }
}
