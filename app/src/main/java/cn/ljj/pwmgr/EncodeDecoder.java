package cn.ljj.pwmgr;

import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class EncodeDecoder {
    public static String TAG = EncodeDecoder.class.getSimpleName();

    private byte[] readFile(String path) {
        FileInputStream fips = null;
        ByteArrayOutputStream bao = null;
        try {
            fips = new FileInputStream(path);
            bao = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            while (true) {
                int len = fips.read(buffer);
                if (len < 0) {
                    break;
                }
                bao.write(buffer, 0, len);
            }
            byte[] data = bao.toByteArray();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fips != null) {
                    fips.close();
                }
                if (bao != null) {
                    bao.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private byte[] encodeDecode(byte[] data, String passwordStr) {
        byte[] output = new byte[data.length];
        byte[] password = passwordStr.getBytes();
        for (int i = 0; i < data.length; i++) {
            byte pw = (byte) (password[i % password.length] ^ (byte) (i % 0x100));
            output[i] = (byte) (data[i] ^ pw);
        }
        return output;
    }

    public void testData() {
        String path = Environment.getExternalStorageDirectory().getPath() + "/.PWMGR/data";
        byte[] data = readFile(path);
        String opt = new String(encodeDecode(data, "11456162"));
        Log.e(TAG, "opt=" + opt);
    }

}
