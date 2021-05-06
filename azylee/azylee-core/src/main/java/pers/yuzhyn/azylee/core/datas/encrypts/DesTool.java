package pers.yuzhyn.azylee.core.datas.encrypts;

import pers.yuzhyn.azylee.core.datas.collections.ListTool;
import pers.yuzhyn.azylee.core.datas.exceptions.ExceptionTool;
import pers.yuzhyn.azylee.core.datas.strings.StringFillTool;
import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.sound.midi.Soundbank;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class DesTool {
    /**
     * 偏移变量，固定占8位字节
     */
    private final static String IV_PARAMETER = "12345678";
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "DES";
    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
    /**
     * 默认编码
     */
    private static final String CHARSET = "utf-8";

    /**
     * 密码长度不够时自动填充
     */
    private static final String FILL_CHAR = "Y";

    /**
     * 创建Key
     *
     * @param key
     * @return
     * @throws Exception
     */
    private static Key generateKey(String key) throws Exception {
        key = StringFillTool.suffixFill(key, 8, FILL_CHAR);
        DESKeySpec dks = new DESKeySpec(key.getBytes(CHARSET));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }


    /**
     * 加密
     *
     * @param data
     * @param key
     * @return
     */
    public static byte[] encrypt(byte[] data, String key) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(data);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
//        if (ListTool.ok(data) && StringTool.ok(key)) {
//            try {
//                Key secretKey = generateKey(key);
//                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//                IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
//                cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
//                byte[] bytes = cipher.doFinal(data);
//                return bytes;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return data;
    }

    /**
     * 加密
     *
     * @param text
     * @param key
     * @return
     */
    public static String encrypt(String text, String key) {
        if (StringTool.ok(text, key)) {
            try {
                byte[] bytes = encrypt(text.getBytes(CHARSET), key);
                // JDK1.8及以上可直接使用Base64
                // JDK1.7及以下可以使用BASE64Encoder
                // Android平台可以使用android.util.Base64
                return new String(Base64.getEncoder().encode(bytes));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return text;
    }

    /**
     * 解密
     *
     * @param data
     * @param key
     * @return
     */
    public static byte[] decrypt(byte[] data, String key) throws  Exception{
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(data);
//        if (ListTool.ok(data) && StringTool.ok(key)) {
//            try {
//                Key secretKey = generateKey(key);
//                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//                IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
//                cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
//                return cipher.doFinal(Base64.getDecoder().decode(data));
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return data;
    }

    public static String decrypt(String text, String key) {
        if (StringTool.ok(text, key)) {
            try {
                byte[] bytes = decrypt(text.getBytes(CHARSET), key);
                return new String(bytes, CHARSET);
            } catch (Exception ex) {
                Alog.i("*********************************");
                Alog.e(ExceptionTool.getStackTrace(ex));
                Alog.i("*********************************");
                ex.printStackTrace();
            }
        }
        return text;
    }

    public static void main(String[] args) {
        String name = "飞雪连天射白鹿";
        String key = "yuzhengyang11111111111111111111111111112222222222222222222222222";
        String xtext = encrypt(name, key);
        String dxtext = decrypt(xtext, key);
        System.out.println("xtext " + xtext);
        System.out.println("dxtext " + dxtext);

        Alog.i("-------------------------");
        Alog.i(": " + Md5Tool.encrypt(DesTool.encrypt("yuzhengyang","yuzhengyang")));

        Alog.i(decrypt("0AEKBflb5ZkNwVy6qCXTIQ==","12345678"));
    }
}
