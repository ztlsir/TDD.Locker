package com.ztlsir;

public class Locker {
    private static final String savePackageFailedErrorMessage = "存包失败";

    private boolean isFull;

    public Locker(boolean isFull) {
        this.isFull = isFull;
    }

    public String savePackage() {
        if (this.isFull) {
            throw new RuntimeException(savePackageFailedErrorMessage);
        }

        return "1";
    }

    public boolean takePackage(String ticket) {
        return true;
    }
}
