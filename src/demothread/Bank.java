package demothread;

public class Bank {
    int account=0;

    public synchronized void deposit(int amount){
        if(amount >0){
            account+= amount;
            System.out.println("Nap thanh cong "+amount);
            notify();
//            notifyAll();
        }

    }

    public synchronized void withdraw(int amount){
        while (amount <0 || amount > account){
            System.out.println("Khong du tien de rut");
            try {
                wait();
            }catch (Exception e){}
        }
        account -= amount;
        System.out.println("Rut thanh cong "+amount);
    }

}
