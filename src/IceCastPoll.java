/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/14/12
 * Time: 10:07 PM
 * To change this template use File | Settings | File Templates.
 */

import java.net.URISyntaxException;
import java.util.*;
import java.lang.*;

import net.moraleboost.streamscraper.ScrapeException;

import java.net.URI;

import net.moraleboost.streamscraper.Stream;
import net.moraleboost.streamscraper.Scraper;
import net.moraleboost.streamscraper.scraper.IceCastScraper;


public class IceCastPoll extends TimerTask {

    private RadioBot bot;
    private String channel = "#radio";
    public String previousSong = "";
    public String previousDJ = "";
    public boolean radioToggle = false;

    private Stream radioStream;

    public IceCastPoll(RadioBot radioBot) {
        this.bot = radioBot;
    }

    public void run() {
        Scraper scraper = new IceCastScraper();
        radioStream = null;

        try {
            List<Stream> streams = scraper.scrape(new URI("http://radio.7chan.org:8000/"));

            for (Stream stream : streams) {

                if (stream.getTitle().equalsIgnoreCase("radio7")) {
                    radioStream = stream;
                    break;
                }
            }

        } catch (URISyntaxException e) {

            System.out.println(e.getMessage());
        } catch (ScrapeException e) {

            System.out.println(e.getMessage());
        }

        if (radioStream != null) {
            radioToggle = true;
            if (!previousDJ.equalsIgnoreCase(radioStream.getDescription())) {
                previousDJ = radioStream.getDescription();
                bot.setTopic(channel, radioStream.getDescription() + " || http://radio.7chan.org:8000/radio.m3u");
            }
            if (!previousSong.equalsIgnoreCase(radioStream.getCurrentSong())) {
                previousSong = radioStream.getCurrentSong();
                bot.sendMessage(channel, radioStream.getCurrentSong() + ", " + radioStream.getCurrentListenerCount() + "/" + radioStream.getPeakListenerCount());
            }
        } else {
            if (radioToggle == true && !previousDJ.equalsIgnoreCase("")) {
                previousDJ = "";
                radioToggle = false;
                bot.setTopic(channel, "OFF-AIR || http://radio.7chan.org:8000/radio.m3u");
            }
        }

    }


}


