package demogeneric;

public class Generic <X,Y>{
    X dataX;
    Y dataY;

    public X getDataX() {
        return dataX;
    }

    public void setDataX(X dataX) {
        this.dataX = dataX;
    }

    public Y getDataY() {
        return dataY;
    }

    public void setDataY(Y dataY) {
        this.dataY = dataY;
    }

    public <A> void run(A msg){ // generic in method
        System.out.println(msg);
    }
}
