package session1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<>();
        hs.add("hello");
        hs.add("world");
        hs.add("hello");
        hs.add("world");
        for (String s: hs){
            System.out.println(s);
        }
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        System.out.println("Numbers: "+numbers);

        int first = numbers.peek();
        System.out.println("first: "+first);
        System.out.println("Total: "+ numbers.size());

        System.out.println("Poll:"+numbers.poll()+" remain:"+numbers.size());
        System.out.println("Poll:"+numbers.poll()+" remain:"+numbers.size());
        System.out.println("Poll:"+numbers.poll()+" remain:"+numbers.size());

        PriorityQueue<Student> st = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getMark() - o1.getMark();
            }
        });
        st.add(new Student("Nguyễn Tuấn Anh",1));
        st.add(new Student("Cao Hoàng Nam",3));
        st.add(new Student("Trần Văn Thành",2));
        st.add(new Student("Hà Hoàng Hưng",0));
        Student s;
        while(st.size() > 0){
            s = st.poll();
           System.out.println("SV: "+s.getName()+" Điểm thi:"+s.getMark());
        }

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("good_student",10);
        hm.put("bad_student",3);
        System.out.println("Tieu chuẩn làm sinh viên xuất sắc là điểm thi phải đạt:"
                +hm.get("good_student"));
        System.out.println(hm.keySet());
        System.out.println(hm.values());
    }
}
