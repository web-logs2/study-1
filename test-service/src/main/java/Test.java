import lombok.Data;
import lombok.ToString;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author chenyile
 * @date 2022/8/27  9:57
 * @description:
 */
public class Test {
    public static <T> void numSum(Supplier<T> supplier, Consumer<T> action) {
        T t = supplier.get();
        List<Thread> list = new ArrayList<>();
        //创建10个线程，每个线程对t执行1千万次action操作
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 10_000_000; j++) {
                    action.accept(t);
                }
            }));
        }
        long start = System.currentTimeMillis();
        list.forEach(Thread::start);
        list.forEach((i) -> {
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("result:" + t + " cost time:" + (end - start) + "ms");
    }

    public static void main(String[] args) {
        numSum(Add::new, Add::increment1);
        numSum(Add::new, Add::increment2);
        numSum(Add::new, Add::increment3);
        numSum(AtomicLong::new, AtomicLong::getAndIncrement);
        numSum(LongAdder::new, LongAdder::increment);
    }
}

@Data
class Add {
    private long i = 0L;
    private ReentrantLock lock = new ReentrantLock();

    public void increment1() {
        i++;
    }

    public synchronized void increment2() {
        i++;
    }

    public void increment3() {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return Long.toString(i);
    }
}
