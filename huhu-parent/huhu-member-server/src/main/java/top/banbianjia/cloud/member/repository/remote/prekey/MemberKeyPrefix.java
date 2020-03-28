package top.banbianjia.cloud.member.repository.remote.prekey;

import top.banbianjia.cloud.common.prekey.KeyPrefix;

public class MemberKeyPrefix implements KeyPrefix {
    private int expireSeconds;
    private String prefix;

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public int getExpireSeconds() {
        return this.expireSeconds;
    }

    public MemberKeyPrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    //登录前缀和时间轴
    public static final MemberKeyPrefix MEMBER_LOGIN_PREFIX = new MemberKeyPrefix(30 * 60, "userLoginUUID:");
}
