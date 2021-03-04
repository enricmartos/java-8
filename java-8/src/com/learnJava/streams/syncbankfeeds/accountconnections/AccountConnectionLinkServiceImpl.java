package com.learnJava.streams.syncbankfeeds.accountconnections;

public class AccountConnectionLinkServiceImpl implements AccountConnectionLinkService {

    @Override
    public void activateAccountConnectionLink(long accId) {
        System.out.println("Activate Account connection link " + accId);
    }

    @Override
    public void removeAccountConnectionLink(long accId) {
        System.out.println("Remove Account connection link " + accId);
    }

    @Override
    public void deactivateAccountConnectionLink(long accId) {
        System.out.println("Deactivate Account connection link " + accId);
    }
}
