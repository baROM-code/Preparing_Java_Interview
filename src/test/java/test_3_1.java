import ru.baROM.pr3.SafeCounter;
import ru.baROM.pr3.SyncQueue;

public class test_3_1 {

    public static void main(String[] args) {

        SyncQueue q = new SyncQueue();

        Thread player1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                q.ping();
            }
        });

        Thread player2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                q.pong();
            }
        });


        player1.start();
        player2.start();

    }
}
