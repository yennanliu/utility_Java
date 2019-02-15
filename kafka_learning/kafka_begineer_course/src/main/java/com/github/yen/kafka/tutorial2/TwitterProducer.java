package com.github.yen.kafka.tutorial2;

import com.google.common.collect.Lists;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import sun.jvm.hotspot.opto.Block;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TwitterProducer {

    public  TwitterProducer(){}

    public static void main(String[] args) {
        new TwitterProducer().run;

    }


    public void run(){


        // create a twitter client

        // create a kafka producer

        // loop to send tweets to kafka


    }

    String consumerKey = "";
    String consumerSecret = "";
    String token = "";
    String secret = "";

    public void createTwitterProducer(){
    // setup blocking queues
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(100000);

        // https://github.com/twitter/hbc

        /** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
        Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
        List<String> terms = Lists.newArrayList("kafka");
        hosebirdEndpoint.trackTerms(terms);

        // These secrets should be read from a config file
        Authentication hosebirdAuth = new OAuth1("consumerKey", "consumerSecret", "token", "secret");

    }

}