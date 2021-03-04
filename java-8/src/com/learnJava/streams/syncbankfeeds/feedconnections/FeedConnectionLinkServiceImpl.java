package com.learnJava.streams.syncbankfeeds.feedconnections;

public class FeedConnectionLinkServiceImpl implements FeedConnectionLinkService {

    @Override
    public void activateFeedConnectionLink(long accId) {
        System.out.println("Activate Feed connection link " + accId);
    }

    @Override
    public void removeFeedConnectionLink(long accId) {
        System.out.println("Remove Feed connection link " + accId);
    }
}
