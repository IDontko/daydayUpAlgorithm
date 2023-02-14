package designPattern.producerAndConsumer;


import javax.swing.plaf.TableHeaderUI;
import java.util.LinkedList;

public class Storage {

    private LinkedList<Object> list = new LinkedList<Object>();

    private Object lock = new Object();

    private int maxSize;

    public Storage(int maxSize){
        this.maxSize = maxSize;
    }

    public void reduce(){
        synchronized (lock){
            while (list.size()  + 1> maxSize ){
                System.out.println("仓库已经满了");
                try{
                    lock.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("生产者 " + Thread.currentThread().getName() + "生产了一个产品，当前库存" + list.size());
            list.notifyAll();
        }
    }

    public void consume(){
        synchronized (lock){
            while (list.size() == 0){}{
                System.out.println("仓库为空");
                try{
                    lock.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("消费者" + Thread.currentThread().getName() + "消费了一个产品，库存" + list.size());
            list.notifyAll();
        }
    }
}
