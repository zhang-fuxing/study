package com.zfx.util.encrypt;

import java.security.MessageDigest;

/**
 * @brief 字符串加密、解密
 * @details
 * @date 2012-11-30
 */
public class Encrypt {
    private static final String ALGORITHM_MD5 = "MD5";
    private static final String ALGORITHM_SHA1 = "SHA1";
    private static final String ALGORITHM_SHA256 = "SHA-256";

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    private Encrypt() {
    }

    /**
     * @param pwd 要加密的字符串
     * @return
     * @brief 将指定字符串加密
     * @details
     */
    public static String encoding(String pwd, boolean isCoding) {
        if (pwd == null) {
            return null;
        }
        // 将输入的字符串转换为字符数组
        char[] chr = pwd.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            // 获得字符的Unicode 值
            int ascii = chr[i];
            ascii ^= 91;
            // 对其Unicode值进行移位加密
            char newchr = (char) (ascii);// +128
            chr[i] = newchr;
        }
        String result = new String(chr);
        result = result.replace("\"", "\\\"");
        return isCoding ? result : pwd;
    }

    /**
     * @param pwd 要解密的字符串
     * @brief 将指定字符串解密
     * @details
     */
    public static String decoding(String pwd, boolean isCoding) {
        pwd = pwd.replace("\\\"", "\"");
        char[] chr = pwd.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            int ascii = chr[i];
            char newchr = (char) (ascii);// -128
            newchr ^= 91;
            chr[i] = newchr;
        }
        String result = new String(chr);
        return isCoding ? result : pwd;
    }


    /**
     * encode string
     *
     * @param algorithm
     * @param str
     * @return String
     */
    public static String encode(String algorithm, String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * encode By MD5
     *
     * @param str
     * @return String
     */
    public static String encodeByMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_MD5);
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * encode By SHA1
     *
     * @param str 目标字符串
     * @return String
     */
    public static String encodeBySHA1(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_SHA1);

            byte[] input = str.getBytes("gb2312"); //"utf8"
            messageDigest.update(input);
            byte[] output = messageDigest.digest();
			return getFormattedText(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * encode By SHA256
     *
     * @param str
     * @return String
     */
    public static String encodeBySHA256(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_SHA256);
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将计算结果(byte数组)转换为字符串
     */
    static String convertToHexString(byte[] data) {
        StringBuilder strBuffer = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            strBuffer.append(Integer.toHexString(0xff & data[i]));
        }
        return strBuffer.toString();
    }

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

}
