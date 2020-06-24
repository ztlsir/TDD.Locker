package com.ztlsir.fixture;

import com.ztlsir.Locker;

public class LockerCreatorFixture {
    public static Locker createAvailableLocker() {
        return new Locker(10);
    }

    public static Locker createFullLocker() {
        return new Locker(0);
    }
}
