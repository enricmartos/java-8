package com.learnJava.streams.syncbankfeeds.accountconnections;

import java.io.Serializable;


public class ProviderAccount implements Serializable {
    private String id;
    private ProviderAccount.StatusEnum status = null;

    public ProviderAccount() {}

    public ProviderAccount id(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProviderAccount status(StatusEnum status) {
        this.status = status;
        return this;
    }

    public ProviderAccount.StatusEnum getStatus() {
        return this.status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public enum StatusEnum {
        ACTIVE("ACTIVE"), ARCHIVED("ARCHIVED");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }

        public static ProviderAccount.StatusEnum fromValue(String text) {
            StatusEnum[] var1 = values();
            int var2 = var1.length;

            for (StatusEnum b : var1) {
                if (String.valueOf(b.value)
                          .equals(text)) {
                    return b;
                }
            }

            return null;
        }
    }
}
