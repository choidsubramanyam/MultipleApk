package com.example.subramanyam.multipleapk;

import android.content.Context;
import android.net.Uri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUpload {




    private void copyFileStream(File saveLocation, Uri uri, Context context){

        InputStream is = null;
        OutputStream os = null;
        try {
            is = context.getContentResolver().openInputStream(uri);
            os = new FileOutputStream(saveLocation);

            //  GZIPOutputStream gzipOutputStream = new GZIPOutputStream(os);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {

                // gzipOutputStream.write(buffer, 0, length);
                os.write(buffer, 0, length);

            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
