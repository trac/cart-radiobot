/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/11/12
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
import org.jibble.pircbot.*;

import java.util.Timer;

public class RadioBot extends PircBot {
    public String currentTopic = "OFF-AIR || http://radio.7chan.org:8000/radio.m3u";

    public RadioBot() {
        this.setName("radiobot");

        new Timer().schedule(new IceCastPoll(this),0, 30 * 1000);

    }

    @Override
    protected void onChannelInfo (String channel, int userCount, String topic) {
        super.onChannelInfo(channel, userCount, topic);

        if (channel == "#cart") {
            currentTopic = topic;
        }
    }
}