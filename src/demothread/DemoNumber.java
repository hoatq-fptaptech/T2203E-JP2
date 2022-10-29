package demothread;

public class DemoNumber {
    int x=0;
    int y=0;
    int z = 0;

    public synchronized void upValue(){
        x++;
        y++;
    }

    public synchronized void print(){
        System.out.println("x="+x);
        System.out.println("y="+y);
    }

    public void upZ(){
        z++;
        System.out.println("z="+z);
    }
}
