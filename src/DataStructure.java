import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataStructure <T>{

    int i = 0;
    private Object [] data = new Object[0];
    private Map<T, Integer> ValueIndex = new HashMap<>();

    public DataStructure(){}

    public DataStructure(T [] data) {
        this.data = (Object []) data;
        for(T val : data)
            ValueIndex.put(val, i++);
        i--;
    }

    public void remove(T value){
        if (ValueIndex.containsKey(value)) {
            this.data[ValueIndex.get(value)] = this.data[i];
            ValueIndex.replace((T) this.data[i], ValueIndex.get(value));
            ValueIndex.remove(value);
            --i;
        }
    }
    public void add(T value){
        if (!ValueIndex.containsKey(value)) {
            if ( i + 1 < this.data.length) {
                this.data[i + 1] = (Object) value;
                ValueIndex.put(value,i++);
            }else{
                this.data = Arrays.copyOf(this.data, this.data.length + 1);
                this.data[i + 1] = (Object) value;
                ValueIndex.put(value,i++);
            }
        }
    }

    public String toString(){
//        for(Object a: data)
//            System.out.println(a);
        return ValueIndex.keySet().toString();
    }



    public static void main(String[] args) {
//        DataStructure<String> a = new DataStructure<>(new String[]{"a", "b", "c"});
//        a.remove("a");
//        a.add("hello");
//        a.add("wassup");
//        a.add("how");
//        a.add("are");
//        a.add("you");
//        a.remove("wassup");
//        a.add("земля пухом");
//        System.out.println(a);
//        DataStructure<Integer> a  = new DataStructure<>();
//        System.out.println(a);

    }
}

