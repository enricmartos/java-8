package com.learnJava.streams.syncbankfeeds.accountconnections;

import java.util.Optional;

public class AccountConnectionLink {
    private Long accountId;
    private String accountConnectionId;
    private boolean isActive;


    public AccountConnectionLink(Long accountId, String accConnectionId, boolean isActive) {
        this.accountId = accountId;
        this.accountConnectionId = Optional.ofNullable(accConnectionId)
                                           .orElse("NULL");
        if (isActive) {
            this.activate();
        }
    }

    public void activate() {
        if (hasAccConnectionLink()) {
            this.isActive = true;
        }
    }

    public void deactivate() {
        this.isActive = false;
    }

    public boolean hasAccConnectionLink() {
        return !"NULL".equals(accountConnectionId);
    }

    public String getAccountConnectionId() {
        return accountConnectionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public boolean getIsActive() {
        return isActive;
    }
}

