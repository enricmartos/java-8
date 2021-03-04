package com.learnJava.streams.syncbankfeeds.feedconnections;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FeedConnectionLink {

    private Long accountId;
    private String feedConnectionId;
    private boolean isActive;


    public FeedConnectionLink(Long accountId, String feedConnectionId, boolean isActive) {
        this.accountId = accountId;
        this.feedConnectionId = Optional.ofNullable(feedConnectionId)
                                        .orElse("NULL");
        if (isActive) {
            this.activate();
        }
    }

    public void activate() {
        if (hasFeedConnectionLink()) {
            this.isActive = true;
        }
    }

    public void deactivate() {
        this.isActive = false;
    }

    public boolean hasFeedConnectionLink() {
        return !"NULL".equals(feedConnectionId);
    }

    public String getFeedConnectionId() {
        return feedConnectionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public boolean getIsActive() {
        return isActive;
    }
}
