package com.learnJava.streams.syncbankfeeds;

import com.learnJava.streams.syncbankfeeds.accountconnections.AccountConnectionLink;
import com.learnJava.streams.syncbankfeeds.accountconnections.AccountConnectionLinkService;
import com.learnJava.streams.syncbankfeeds.accountconnections.AccountConnectionLinkServiceImpl;
import com.learnJava.streams.syncbankfeeds.accountconnections.ProviderAccount;
import com.learnJava.streams.syncbankfeeds.feedconnections.FeedConnection;
import com.learnJava.streams.syncbankfeeds.feedconnections.FeedConnectionLink;
import com.learnJava.streams.syncbankfeeds.feedconnections.FeedConnectionLinkService;
import com.learnJava.streams.syncbankfeeds.feedconnections.FeedConnectionLinkServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class XeroSyncBankFeedsService {

    private final FeedConnectionLinkService feedConnectionLinkService = new FeedConnectionLinkServiceImpl();
    private final AccountConnectionLinkService accountConnectionLinkService = new AccountConnectionLinkServiceImpl();


    public void syncFeedConnectionLinks(List<FeedConnectionLink> feedConnectionLinks,
                                        List<FeedConnection> providerFeedConnections) {
        feedConnectionLinks.forEach(feedConnectionLink -> syncFeedConnectionLink(feedConnectionIds(providerFeedConnections), feedConnectionLink));
    }

    private void syncFeedConnectionLink(Set<String> providerFeedConnectionIds, FeedConnectionLink feedConnectionLink) {
        Long accountId = feedConnectionLink.getAccountId();
        if (existsFeedOnProvider(providerFeedConnectionIds, feedConnectionLink))
            feedConnectionLinkService.activateFeedConnectionLink(accountId);
        else
            feedConnectionLinkService.removeFeedConnectionLink(accountId);
    }

    private Set<String> feedConnectionIds(List<FeedConnection> feedConnections) {
        return feedConnections.stream()
                .map(FeedConnection::getId)
                .collect(Collectors.toSet());
    }

    private boolean existsFeedOnProvider(Set<String> providerFeedConnectionIds,
                                         FeedConnectionLink feedConnectionLink) {
        return providerFeedConnectionIds.contains(feedConnectionLink.getFeedConnectionId());
    }

    public void syncAccountConnectionLinks(List<AccountConnectionLink> accountConnectionLinks,
            List<ProviderAccount> providerAccounts) {
        accountConnectionLinks.forEach(accountConnectionLink -> {
            Long accountId = accountConnectionLink.getAccountId();
            if (!existsAccountOnProvider(providerAccountIds(providerAccounts), accountConnectionLink)) {
                accountConnectionLinkService.removeAccountConnectionLink(accountId);
            } else {
                providerAccounts.stream().filter(providerAccount -> providerAccount.getId()
                        .equals(accountConnectionLink.getAccountConnectionId())).forEach(providerAccount -> {
                    if (isProviderAccountActive(providerAccount))
                        accountConnectionLinkService.activateAccountConnectionLink(accountId);
                    if (isProviderAccountArchived(providerAccount))
                        accountConnectionLinkService.deactivateAccountConnectionLink(accountId);
                });
            }
        });
    }

    private Set<String> providerAccountIds(List<ProviderAccount> providerAccounts) {
        return providerAccounts.stream()
                               .map(ProviderAccount::getId)
                               .collect(Collectors.toSet());
    }

    private boolean existsAccountOnProvider(Set<String> providerAccountIds,
            AccountConnectionLink accountConnectionLink) {
        return providerAccountIds.contains(accountConnectionLink.getAccountConnectionId());
    }

    private boolean isProviderAccountActive(ProviderAccount providerAccount) {
        return providerAccount.getStatus()
                              .equals(ProviderAccount.StatusEnum.ACTIVE);
    }

    private boolean isProviderAccountArchived(ProviderAccount providerAccount) {
        return providerAccount.getStatus()
                              .equals(ProviderAccount.StatusEnum.ARCHIVED);
    }

    public static void main(String[] args) {
        XeroSyncBankFeedsService xeroSyncBankFeedsService = new XeroSyncBankFeedsService();
        List<FeedConnection> feedConnections = new ArrayList<>();
        List<FeedConnectionLink> feedConnectionLinks = new ArrayList<>();

        xeroSyncBankFeedsService.syncFeedConnectionLinks(feedConnectionLinks, feedConnections);
    }


}
