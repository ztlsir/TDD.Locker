package com.ztlsir.locker.fixture;

import com.ztlsir.locker.Locker;

public class LockerCreatorFixture {
    public static Locker createAvailableLocker() {
        return new Locker(10);
    }

    public static Locker createLocker(int capacity) {
        return new Locker(capacity);
    }

    public static Locker createFullLocker() {
        return new Locker(0);
    }
}
