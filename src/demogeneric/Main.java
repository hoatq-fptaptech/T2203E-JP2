package demogeneric;

public class Main {
    public static void main(String[] args){
        Generic<String,Integer> g = new Generic<>();
        g.setDataX("Hello");

        Generic<Integer,String> g2= new Generic<>();
        g2.setDataX(10);

        g.run("xin chao");
        g.run(102);
    }
}
