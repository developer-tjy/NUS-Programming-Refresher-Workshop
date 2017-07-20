// This program performs a set operation (union, intersection or difference)
// on two sets of integer values given as input.
import java.util.*;

public class Exe9 {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Integer> in1, in2;
        String operator;

        // read two sets of integer values into s1, s2
        in1 = readSet();
        in2 = readSet();

        // read the set operation
        String op = sc.next();

        // perform the set operation on the two sets of values
        Set<Integer> out = operate(in1, in2, op);

        // output resulting set
        print(out);
    }

    public static Set<Integer> readSet() {
        Set<Integer> s = new TreeSet<Integer>();
        while (sc.hasNext()) {
            int current = sc.nextInt();
            if (current == -1)
                break;
            s.add(current);
        }
        return s;
    }

    public static Set<Integer> operate(Set<Integer> in1, Set<Integer> in2, String op) {
        Set<Integer> s = new TreeSet<Integer>();
        if(op.equals("*")){
            in1.retainAll(in2);
        }else if(op.equals("-")){
            in1.removeAll(in2);
        }else if(op.equals("+")){
            in1.addAll(in2);
        }
        return in1;
    }

    public static void print(Set<Integer> s) {
        List<Integer> s_arrlist = new ArrayList<>(s);
        for(int i = 0; i < s_arrlist.size(); i++){
            if(i != s_arrlist.size() - 1){
                System.out.print(s_arrlist.get(i) + " ");
            }else{
                System.out.println(s_arrlist.get(i));
            }
        }
    }
}
