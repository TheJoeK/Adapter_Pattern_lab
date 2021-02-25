import java.util.Arrays;
import java.util.Random;

public class Signals {
    public static void main(String []args){
        DigitalSource d = new DigitalSource();
        Client c = new Client(d);
        c.processSignal(20);
    }
}

class Client {
    private DigitalSource d;
    public Client(DigitalSource d) {
        this.d = d;
    }
    public void processSignal(int n) {
        int[] signal = d.getSignal(n);
        System.out.println(Arrays.toString(signal));
    }
}

class DigitalSource {
    public int[] getSignal(int n) {
        int[] signal = new int[n];
        Random random = new Random(n);
        for (int i = 0; i < n; ++i) {
            signal[i] = random.nextBoolean() ? 1 : 0;
        }
        return signal;
    }
}

class AnalogSource {
    public float[] getSignal(int n) {
        float[] signal = new float[n];
        Random random = new Random(n);
        for (int i = 0; i < n; ++i) {
            signal[i] = random.nextFloat();
        }
        return signal;
    }
}

enum MCode {
    DASH, DOT, SPACE
}

class MorseSource {
    public MCode[] getSignal(int n) {
        MCode[] signal = new MCode[n];
        Random random = new Random(n);
        for (int i = 0; i < n; ++i) {
            int s = random.nextInt(4);
            switch (s) {
                case 0:
                signal[i] = MCode.DASH;
                break;
                case 1:
                signal[i] = MCode.DOT;
                break;
                case 2:
                signal[i] = MCode.SPACE;
                break;
            }
        }
        return signal;
    }
}
