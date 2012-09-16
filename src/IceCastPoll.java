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
    private String channel = "#7chan";



    public IceCastPoll(RadioBot radioBot) {
        this.bot = radioBot;
    }

    public void run() {
        Scraper scraper = new IceCastScraper();
        String song = "";
        try {
            List<Stream> streams = scraper.scrape(new URI("http://radio.7chan.org:8000/"));

            for (Stream stream : streams) {

                if (stream.getTitle() == "radio7") {

                }
            }

        } catch (URISyntaxException e) {

            System.out.println(e.getMessage());
        } catch (ScrapeException e) {

            System.out.println(e.getMessage());
        }
/*
        if (radioStream != null) {
            if (topicChanged = false) {
                bot.setTopic(channel, stream + " is playing " + genre + ". Listen via http://radio.7chan.org:8000/radio.m3u");
                topicChanged = true;
            }
            if (pastSong != song) {
                bot.sendMessage(channel, song + ", " + currentListeners + "/" + peakListeners);
            }
        } else {
            bot.listChannels(channel);
            if (bot.currentTopic != "OFF-AIR || http://radio.7chan.org:8000/radio.m3u") {
                bot.setTopic(channel, "OFF-AIR || http://radio.7chan.org:8000/radio.m3u");
            }

        }
        */
    }


}


