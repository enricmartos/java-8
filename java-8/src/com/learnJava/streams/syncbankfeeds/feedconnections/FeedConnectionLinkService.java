package com.learnJava.streams.syncbankfeeds.feedconnections;

public interface FeedConnectionLinkService {

    void activateFeedConnectionLink(final long accId);

    void removeFeedConnectionLink(final long accId);

}
