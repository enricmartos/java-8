package com.learnJava.streams.syncbankfeeds.feedconnections;


import java.util.Objects;

public class FeedConnection {
    private String id = null;
    private String accountToken = null;
    private String accountNumber = null;
    private String accountName = null;
    private String accountId = null;
    private FeedConnection.AccountTypeEnum accountType = null;
    private String currency = null;
    private String country = null;
    private FeedConnection.StatusEnum status = null;
    private Error error = null;

    public FeedConnection() {}

    public FeedConnection id(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FeedConnection accountToken(String accountToken) {
        this.accountToken = accountToken;
        return this;
    }

    public String getAccountToken() {
        return this.accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public FeedConnection accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public FeedConnection accountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public FeedConnection accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public FeedConnection accountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
        return this;
    }

    public FeedConnection.AccountTypeEnum getAccountType() {
        return this.accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public FeedConnection currency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public FeedConnection country(String country) {
        this.country = country;
        return this;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public FeedConnection status(StatusEnum status) {
        this.status = status;
        return this;
    }

    public FeedConnection.StatusEnum getStatus() {
        return this.status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public FeedConnection error(Error error) {
        this.error = error;
        return this;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            FeedConnection feedConnection = (FeedConnection) o;
            return Objects.equals(this.id, feedConnection.id)
                    && Objects.equals(this.accountToken, feedConnection.accountToken)
                    && Objects.equals(this.accountNumber, feedConnection.accountNumber)
                    && Objects.equals(this.accountName, feedConnection.accountName)
                    && Objects.equals(this.accountId, feedConnection.accountId)
                    && Objects.equals(this.accountType, feedConnection.accountType)
                    && Objects.equals(this.currency, feedConnection.currency)
                    && Objects.equals(this.country, feedConnection.country)
                    && Objects.equals(this.status, feedConnection.status)
                    && Objects.equals(this.error, feedConnection.error);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[] {this.id, this.accountToken, this.accountNumber,
                this.accountName, this.accountId, this.accountType, this.currency, this.country,
                this.status, this.error});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FeedConnection {\n");
        sb.append("    id: ")
          .append(this.toIndentedString(this.id))
          .append("\n");
        sb.append("    accountToken: ")
          .append(this.toIndentedString(this.accountToken))
          .append("\n");
        sb.append("    accountNumber: ")
          .append(this.toIndentedString(this.accountNumber))
          .append("\n");
        sb.append("    accountName: ")
          .append(this.toIndentedString(this.accountName))
          .append("\n");
        sb.append("    accountId: ")
          .append(this.toIndentedString(this.accountId))
          .append("\n");
        sb.append("    accountType: ")
          .append(this.toIndentedString(this.accountType))
          .append("\n");
        sb.append("    currency: ")
          .append(this.toIndentedString(this.currency))
          .append("\n");
        sb.append("    country: ")
          .append(this.toIndentedString(this.country))
          .append("\n");
        sb.append("    status: ")
          .append(this.toIndentedString(this.status))
          .append("\n");
        sb.append("    error: ")
          .append(this.toIndentedString(this.error))
          .append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null"
                         : o.toString()
                            .replace("\n", "\n    ");
    }

    public static enum StatusEnum {
        PENDING("PENDING"), REJECTED("REJECTED");

        private String value;

        private StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }

        public static FeedConnection.StatusEnum fromValue(String text) {
            StatusEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                StatusEnum b = var1[var3];
                if (String.valueOf(b.value)
                          .equals(text)) {
                    return b;
                }
            }

            return null;
        }
    }

    public static enum AccountTypeEnum {
        BANK("BANK"), CREDITCARD("CREDITCARD");

        private String value;

        private AccountTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }

        public static FeedConnection.AccountTypeEnum fromValue(String text) {
            AccountTypeEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                AccountTypeEnum b = var1[var3];
                if (String.valueOf(b.value)
                          .equals(text)) {
                    return b;
                }
            }

            return null;
        }
    }
}

