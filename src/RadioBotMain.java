/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/14/12
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */

import org.jibble.pircbot.*;

import java.net.URI;
import java.util.*;

import net.moraleboost.streamscraper.Stream;
import net.moraleboost.streamscraper.Scraper;
import net.moraleboost.streamscraper.scraper.IceCastScraper;


public class RadioBotMain {

    public static void main(String[] args) throws Exception {


        // Now start our bot up.
        RadioBot bot = new RadioBot();

        // Enable debugging output.
        bot.setVerbose(true);

        // Connect to the IRC server.
        bot.connect("irc.7chan.su");

        // Join the #pircbot channel.
        bot.joinChannel("#cart");

        //bot.sendMessage("#programming", getSong());

    }
/*
    static String getSong() throws Exception {

        String song = "";

        Scraper scraper = new IceCastScraper();
        List<Stream> streams = scraper.scrape(new URI("http://radio.7chan.org:8000/radio"));

        for (Stream stream : streams) {
            song = stream.getCurrentSong();

        }

        return song;
    }
*/
}