package airhawk.com.myapplication;

import android.content.Context;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static airhawk.com.myapplication.Activity_Main.aequity_name_arraylist;
import static airhawk.com.myapplication.Activity_Main.aequity_symbol_arraylist;
import static airhawk.com.myapplication.Constructor_App_Variables.*;
import static airhawk.com.myapplication.Service_Main_Equities.stock_kings_changelist;
import static airhawk.com.myapplication.Service_Main_Equities.stock_kings_namelist;
import static airhawk.com.myapplication.Service_Main_Equities.stock_kings_symbollist;

public class Test_Methods {
    static ArrayList exchange_url = new ArrayList<>();
    static ArrayList exchange_name = new ArrayList<>();
    private static Context mContext;
    static String cryptopia_list;

    public static void main(String[] args) {
getStocks_Market_Caps();

        //get_crypto_points();
//get_stock_points();
    }


    public static void getStocks_Market_Caps() {
        Document z =null;
        try {
            z = Jsoup.connect("https://finance.yahoo.com").timeout(10 * 10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element table = z.getElementById("Lead-2-FinanceHeader-Proxy");
        Elements as = table.select("a[title]");
        sp_name = as.get(0).text().replace("&", "");
        dow_name = as.get(2).text();
        nas_name = as.get(4).text();
        Elements as1 = z.select("h3>span");
        sp_amount =as1.get(0).text();
        dow_amount=as1.get(1).text();
        nas_amount=as1.get(2).text();
        Elements as2 =z.select("span>span");
        sp_change =as2.get(2).text();
        dow_change=as2.get(3).text();
        nas_change=as2.get(4).text();
        if (sp_change.contains("-")){
            sp_flow=true;
        }
        if (dow_change.contains("-")){
            dow_flow=true;
        }
        if (nas_change.contains("-")){
            nd_flow=true;
        }
        System.out.println(sp_name+" "+sp_amount+" "+sp_change);
        System.out.println(dow_name+" "+dow_amount+" "+dow_change);
        System.out.println(nas_name+" "+nas_amount+" "+nas_change);
    }

    public static void get_stock_points() {
        Document cap = null;


            try {
                cap = Jsoup.connect("https://finance.yahoo.com/quote/gsat").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
              Element test = cap.select("div[data-reactid='34']").first().select("span").get(1);
              String foofoo =test.text().toString().replace("(","").replace(")","");
              String[] foo = foofoo.split(" ");
              String f =foo[1];
            System.out.println("It's a stock " + f);



    }


    public static void get_stock_points2() {
        System.out.println("Get stock points called");
        String marname = "aapl";
        Document d = null;
        try {
            d = Jsoup.connect("https://finance.yahoo.com/quote/"+marname+"/history?period1=863668800&period2=1538452800&interval=1d&filter=history&frequency=1d").timeout(10 * 10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

            Elements x = d.getElementsByAttributeValue("class","BdT Bdc($c-fuji-grey-c) Ta(end) Fz(s) Whs(nw)");


            for(int z =0; z < x.size();z++){
                String text =x.get(z).text();
                if(text.contains("Dividend")){continue;}else{
                String date =x.get(z).select("td").get(0).text();
                graph_date.add(date);
                String close =x.get(z).select("td").get(5).text();
                graph_high.add(close);
                String volume =x.get(z).select("td").get(6).text();
                graph_volume.add(volume);
                List<String> numbers = graph_high;
                //Collections.reverse(numbers);
                _AllDays = numbers;}}
        System.out.println(graph_high.size());
        }
        //System.out.println(u);


    public static void getStock_Kings() {
        int x;
        Document sv = null;
        String t;
        try {
            sv = Jsoup.connect("http://fortune.com/global500/list/filtered?sortBy=profits&first500").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements e = sv.select("li");
        for (int i = 0; i < e.size(); i++) {
            Elements z = e.select("span");
            for (x = 1; x < e.size(); x = x + 3) {
                stock_kings_namelist.add(z.get(x).text());
                System.out.println(z.get(x).text());
                t = z.get(x).text();
                for (int s = 0; s < aequity_name_arraylist.size(); s++) {
                    if (aequity_name_arraylist.contains(t)) {
                        stock_kings_symbollist.add(aequity_symbol_arraylist.get(s));
                        System.out.println("Yo " + aequity_symbol_arraylist.get(s));
                    }
                }
                //    aequity_name_arraylist;
                //ap_info.setMarketSymbol();
                //stock_kings_changelist.add();
            }


            for (int n = 2; n < e.size(); n = n + 3) {
                //System.out.println(z.get(n).text().substring(1, 5).replace(",", ".") + " B");
                stock_kings_changelist.add(z.get(n).text().substring(1, 5).replace(",", ".") + " B");
            }
        }

    }

    public static void get_crypto_listings() {

        exchange_url.add("https://www.Binance.com");
        exchange_url.add("https://www.OKEx.com");
        exchange_url.add("https://www.Huobi.com");
        exchange_url.add("https://www.Bithumb.com");
        exchange_url.add("https://www.ZB.com");
        exchange_url.add("https://www.Bitfinex.com");
        exchange_url.add("https://www.HitBTC.com");
        exchange_url.add("https://www.Bit-Z.com");
        exchange_url.add("https://www.Bibox.com");
        exchange_url.add("https://www.Coinsuper.com");
        exchange_url.add("https://www.BCEX.com");
        exchange_url.add("https://www.LBank.com");
        exchange_url.add("https://www.DigiFinex.com");
        exchange_url.add("https://www.Upbit.com");
        exchange_url.add("https://pro.Coinbase.com");
        exchange_url.add("https://www.Simex.com");
        exchange_url.add("https://www.OEX.com");
        exchange_url.add("https://www.Kraken.com");
        exchange_url.add("https://www.Cryptonex.com");
        exchange_url.add("https://www.BitMart.com");
        exchange_url.add("https://www.Allcoin.com");
        exchange_url.add("https://www.IDAX.com");
        exchange_url.add("https://www.RightBTC.com");
        exchange_url.add("https://www.IDCM.com");
        exchange_url.add("https://www.YoBit.com");
        exchange_url.add("https://www.DragonEX.io");
        exchange_url.add("https://www.Gate.io");
        exchange_url.add("https://www.Fatbtc.com");
        exchange_url.add("https://www.Exrates.com");
        exchange_url.add("https://www.CoinsBank.com");
        exchange_url.add("https://www.BTCBOX.com");
        exchange_url.add("https://www.Kryptono.exchange");
        exchange_url.add("https://www.UEX.com");
        exchange_url.add("https://www.Bitlish.com");
        exchange_url.add("https://www.Sistemkoin.com");
        exchange_url.add("https://www.Bitstamp.com");
        exchange_url.add("https://www.Bitbank.com");
        exchange_url.add("https://www.CoinTiger.com");
        exchange_url.add("https://www.CoinBene.com");
        exchange_url.add("https://www.LATOKEN.com");
        exchange_url.add("https://www.Bitstamp.com");
        exchange_url.add("https://www.Bittrex.com");
        exchange_url.add("https://www.Poloniex.com");
        exchange_url.add("https://www.CoinEgg.com");
        exchange_url.add("https://www.Exmo.com");
        exchange_url.add("https://www.Hotbit.com");
        exchange_url.add("https://www.bitFlyer.com");
        exchange_url.add("https://www.B2BX.com");
        exchange_url.add("https://www.Rfinex.com");
        exchange_url.add("https://www.CPDAX.com");
        exchange_url.add("https://www.C2CX.com");
        exchange_url.add("https://www.Livecoin.com");
        exchange_url.add("https://www.BtcTrade.im");
        exchange_url.add("https://www.xBTCe.com");
        exchange_url.add("https://www.Coinone.com");
        exchange_url.add("https://www.Kucoin.com");
        exchange_url.add("https://www.BitBay.com");
        exchange_url.add("https://www.Gemini.com");
        exchange_url.add("https://www.Coinbe.net");
        exchange_url.add("https://www.InfinityCoin.exchange");
        exchange_url.add("https://www.Tradebytrade.com");
        exchange_url.add("https://www.BiteBTC.com");
        exchange_url.add("https://www.Coinsquare.com");
        exchange_url.add("https://www.HADAX.com");
        exchange_url.add("https://www.Coinroom.com");
        exchange_url.add("https://www.Mercatox.com");
        exchange_url.add("https://www.Coinhub.com");
        exchange_url.add("https://www.BigONE.com");
        exchange_url.add("https://www.BitShares.org");
        exchange_url.add("https://www.CEX.IO");
        exchange_url.add("https://www.ChaoEX.com");
        exchange_url.add("https://www.Bitsane.com");
        exchange_url.add("https://www.BitForex.com");
        exchange_url.add("https://www.LocalTrade.com");
        exchange_url.add("https://www.Bitinka.com");
        exchange_url.add("https://www.Liqui.io");
        exchange_url.add("https://www.Liquid.com");
        exchange_url.add("https://www.BTC-Alpha.com");
        exchange_url.add("https://www.Instantbitex.com");
        exchange_url.add("https://www.Cryptopia.com");
        exchange_url.add("https://www.GOPAX.com");
        exchange_url.add("https://www.Korbit.com");
        exchange_url.add("https://www.itBit.com");
        exchange_url.add("https://www.Indodax.com");
        exchange_url.add("https://www.Vebitcoin.com");
        exchange_url.add("https://www.Allbit.com");
        exchange_url.add("https://www.Indodax.com");
        exchange_url.add("https://www.BtcTurk.com");
        exchange_url.add("https://www.Ovis.com");
        exchange_url.add("https://www.BTCC.com");
        exchange_url.add("https://www.IDEX.market");
        exchange_url.add("https://www.Ethfinex.com");
        exchange_url.add("https://www.QuadrigaCX.com");
        exchange_url.add("https://www.CoinExchange.io");
        exchange_url.add("https://www.Tidex.com");
        exchange_url.add("https://www.https://www.negociecoins.com/br");
        exchange_url.add("https://www.CryptoBridge.com");
        exchange_url.add("https://www.LakeBTC.com");
        exchange_url.add("https://www.Bancor.network");
        exchange_url.add("https://www.QBTC.com");
        exchange_url.add("https://www.WEX.com");
        exchange_name.add("Binance");
        exchange_name.add("OKEx");
        exchange_name.add("Huobi");
        exchange_name.add("Bithumb");
        exchange_name.add("ZB.COM");
        exchange_name.add("Bitfinex");
        exchange_name.add("HitBTC");
        exchange_name.add("Bit-Z");
        exchange_name.add("Bibox");
        exchange_name.add("Coinsuper");
        exchange_name.add("BCEX");
        exchange_name.add("LBank");
        exchange_name.add("DigiFinex");
        exchange_name.add("Upbit");
        exchange_name.add("Coinbase Pro");
        exchange_name.add("Simex");
        exchange_name.add("OEX");
        exchange_name.add("Kraken");
        exchange_name.add("Cryptonex");
        exchange_name.add("BitMart");
        exchange_name.add("Allcoin");
        exchange_name.add("IDAX");
        exchange_name.add("RightBTC");
        exchange_name.add("IDCM");
        exchange_name.add("YoBit");
        exchange_name.add("DragonEX");
        exchange_name.add("Gate.io");
        exchange_name.add("Fatbtc");
        exchange_name.add("Exrates");
        exchange_name.add("CoinsBank");
        exchange_name.add("BTCBOX");
        exchange_name.add("Kryptono");
        exchange_name.add("UEX");
        exchange_name.add("Bitlish");
        exchange_name.add("Sistemkoin");
        exchange_name.add("Bitstamp");
        exchange_name.add("Bitbank");
        exchange_name.add("CoinTiger");
        exchange_name.add("CoinBene");
        exchange_name.add("LATOKEN");
        exchange_name.add("Bitstamp");
        exchange_name.add("Bittrex");
        exchange_name.add("Poloniex");
        exchange_name.add("CoinEgg");
        exchange_name.add("Exmo");
        exchange_name.add("Hotbit");
        exchange_name.add("B2BX");
        exchange_name.add("bitFlyer");
        exchange_name.add("Rfinex");
        exchange_name.add("CPDAX");
        exchange_name.add("C2CX");
        exchange_name.add("Livecoin");
        exchange_name.add("BtcTrade.im");
        exchange_name.add("xBTCe");
        exchange_name.add("Coinone");
        exchange_name.add("Kucoin");
        exchange_name.add("BitBay");
        exchange_name.add("Gemini");
        exchange_name.add("Coinbe");
        exchange_name.add("InfinityCoin Exchange");
        exchange_name.add("Trade By Trade");
        exchange_name.add("BiteBTC");
        exchange_name.add("Coinsquare");
        exchange_name.add("HADAX");
        exchange_name.add("Coinroom");
        exchange_name.add("Mercatox");
        exchange_name.add("Coinhub");
        exchange_name.add("BigONE");
        exchange_name.add("BitShares Exchange");
        exchange_name.add("CEX.IO");
        exchange_name.add("ChaoEX");
        exchange_name.add("Bitsane");
        exchange_name.add("BitForex");
        exchange_name.add("LocalTrade");
        exchange_name.add("Bitinka");
        exchange_name.add("Liqui");
        exchange_name.add("Liquid");
        exchange_name.add("BTC-Alpha");
        exchange_name.add("Instant Bitex");
        exchange_name.add("Cryptopia");
        exchange_name.add("GOPAX");
        exchange_name.add("Korbit");
        exchange_name.add("itBit");
        exchange_name.add("Indodax");
        exchange_name.add("Vebitcoin");
        exchange_name.add("Allbit");
        exchange_name.add("Coindeal");
        exchange_name.add("BtcTurk");
        exchange_name.add("Ovis");
        exchange_name.add("BTCC");
        exchange_name.add("IDEX");
        exchange_name.add("Ethfinex");
        exchange_name.add("QuadrigaCX");
        exchange_name.add("CoinExchange");
        exchange_name.add("Tidex");
        exchange_name.add("Negocie Coins");
        exchange_name.add("CryptoBridge");
        exchange_name.add("LakeBTC");
        exchange_name.add("Bancor Network");
        exchange_name.add("QBTC");
        exchange_name.add("WEX");


    }

    public static void get_crypto_points() {
        long startTime = System.nanoTime();
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date begindate = new Date();
        String f = "bitcoin";
        System.out.println("NAMD!!! "+f);
        if (f.contains(" ")){
            f= f.replaceAll(" ","-");}
        Document d= null;
        String url = "https://coinmarketcap.com/currencies/" + f + "/historical-data/?start=20000101&end=" + sdf.format(begindate);
        try {
            d = Jsoup.connect(url).timeout(10 * 10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element price = d.getElementById("quote_price");
        String v = price.text();
        Elements divs = d.select("table");
        for (Element tz : divs) {
            Elements tds = tz.select("td");
            Elements s = tz.getElementsByClass("text-right");
            for (Element ss : s) {
                Elements p = ss.select("td[data-format-fiat]");
                String g = p.text();
                String[] splited = g.split("\\s+");
                if (v != null && !g.isEmpty()) {
                    graph_high.add(splited[3]);
                    System.out.println("PRICE "+graph_high);
                    graph_low.add(splited[2]);
                }
                Elements pn = ss.select("td[data-format-market-cap]");
                String vp = pn.text();
                String[] split = vp.split("\\s+");
                if (vp != null && !vp.isEmpty()) {
                    graph_volume.add(split[0]);
                    graph_market_cap.add(split[1]);
                }
            }
            for (Element bb : tds) {
                Elements gdate = bb.getElementsByClass("text-left");
                String result0 = gdate.text();
                if (result0 != null && !result0.isEmpty()) {
                    graph_date.add(String.valueOf(result0));
                }
            }
        }
        //System.out.println("THIs Is graph high "+ Arrays.asList(graph_high));
        _AllDays = graph_high;




        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("CRYPTO POINTS TIME IS " + duration / 1000000000 + " seconds");



    }

    public static void get_stock_change() {
        stock_kings_symbollist.add("gsat");
        stock_kings_symbollist.add("aapl");
        stock_kings_symbollist.add("dpw");
        stock_kings_symbollist.add("fb");
        stock_kings_symbollist.add("goog");
        String symbol= null;
        for(int z = 0; z < stock_kings_symbollist.size();++z) {
            symbol = String.valueOf(stock_kings_symbollist.get(z));
            Document d = null;
            try {
                d = Jsoup.connect("https://www.nasdaq.com/symbol/" + symbol).userAgent("Mozilla").timeout(10 * 100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Element change = d.getElementById("qwidget_percent");
            System.out.println("PERCENT CHANGE" + change);
        }

    }




}