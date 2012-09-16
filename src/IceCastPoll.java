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
    private String channel = "#programming";

    private Stream radioStream;

    public IceCastPoll(RadioBot radioBot) {
        this.bot = radioBot;
    }

    public void run() {
        Scraper scraper = new IceCastScraper();
        String song = "";
        radioStream = null;
        try {
            List<Stream> streams = scraper.scrape(new URI("http://radio.7chan.org:8000/"));

            for (Stream stream : streams) {

                if (stream.getTitle() == "radio7") {
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
           bot.sendMessage(channel, "Now Playing: " + radioStream.getCurrentSong());
        } else {
           bot.sendMessage(channel, "The Radio is off-air");
        }

    }


}


