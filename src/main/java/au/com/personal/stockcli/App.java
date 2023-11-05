package au.com.personal.stockcli;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.IOException;
import java.net.URI;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        // an Input
        // split input into sections
        // do commands from sections
        // print stuff
        Scanner s = new Scanner(System.in);
        HashMap<String, String> comm = new HashMap<String, String>();
        ArrayList<String> watchlist = new ArrayList<String>();

        while (true) {
            // Input
            String result = s.nextLine();

            // to quit
            if (Objects.equals(result, "q")) {
                System.out.println("Quitting Now");
                break;
            }

            // Add to Hashmap and split into array and read the first element
            comm.put("command", result);
            String test = comm.get("command");
            String[] test1 = test.split(" ");

            // based on the first element, open website or add to list
            switch (test1[0]) {
                case "show":
                    switch (test1[1]) {
                        case "-t":
                            switch (test1[3]) {
                                case "-c":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/chart/EvIAtAua/?symbol=" + test1[2]));
                                    break;
                                case "-o":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/symbols/" + test1[2]));
                                    break;
                                case "-fo":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/symbols/" + test1[2] + "/financials-overview/"));
                                    break;
                                case "-d":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/symbols/" + test1[2] + "/financials-dividends/"));
                                    break;
                                case "-e":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/symbols/" + test1[2] + "/financials-earnings/"));
                                    break;
                                case "-r":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/symbols/" + test1[2] + "/financials-revenue/"));
                                    break;
                            }
                        case "-f": //https://www.tradingview.com/symbols/COMEX-GC1!/
                            switch (test1[3]) {
                                case "-c":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/chart/EvIAtAua/?symbol=" + test1[2]));
                                    break;
                                case "-o":
                                    java.awt.Desktop.getDesktop().browse(URI.create("https://www.tradingview.com/symbols/" + test1[2]));
                                    break;
                            }
                    }

                case "watchlist":
                    watchlist.add(test1[1]);
                    System.out.println(watchlist);
                    break;
            }
        }
    }
}
