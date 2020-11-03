package by.tsvirko.pool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * описание канала и его использования
 */
public class AudioChannel {
    private int channelId;

    public AudioChannel(int channelId) {
        super();
        this.channelId = channelId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void using() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
