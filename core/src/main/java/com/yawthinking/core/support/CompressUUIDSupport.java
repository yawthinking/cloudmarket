package com.yawthinking.core.support;

import org.apache.commons.codec.binary.Base64;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * 利用 base64 編碼，將 128bit 的 UUID，轉為Base64字串
 * 長度可以縮到22個字元
 */
public final class CompressUUIDSupport {

    public static String compress(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return Base64.encodeBase64URLSafeString(bb.array());
    }

    public static UUID decompress(String compressedId) {
        byte[] bytes = Base64.decodeBase64(compressedId);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return new UUID(bb.getLong(), bb.getLong());
    }

    private CompressUUIDSupport() {
        super();
    }

}
