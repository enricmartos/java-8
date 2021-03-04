package com.learnJava.streams.syncbankfeeds.accountconnections;

public interface AccountConnectionLinkService {

    void activateAccountConnectionLink(final long accId);

    void removeAccountConnectionLink(final long accId);

    void deactivateAccountConnectionLink(final long accId);

}
