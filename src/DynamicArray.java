import java.io.*;
import java.util.*;

public class DynamicArray<T> {
    private int size = 0;
    T[] array = (T[]) new Object[1];

    public DynamicArray() {
    }
    public void  someMethod(Object obj) {

    }

    private int size() {
        return array.length;
    }

    public void add(T element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + 2);
        }
        array[size] = element;
        size++;
    }


    public void remove(int index) {
        size--;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size] = null;

    }

    public T get(int index) {
        if (index>size) throw new NullPointerException("e");
        return (T) array[index];
    }

    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
       Map <String, Long> set = new HashMap<>();
       Scanner sc = new Scanner(reader);
      while (sc.hasNext()){
          set.merge(sc.next(),sc.nextLong(), (oldValue, newValue) -> oldValue + newValue);
      }
      return set;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> spider = new ArrayDeque<>();
        int i =1;
        int result ;
        while(sc.hasNext()){

            if(i%2==0 ){
                spider.addFirst(sc.nextInt());
            }else {
                sc.next();
            }
            i++;
        }
        for(Integer s : spider){
            System.out.print(s+" ");
        }

        ByteArrayInputStream bais = new ByteArrayInputStream("1 2 3 4 5 6 7 8 9 10".getBytes());
        System.setIn(bais);
    }


}