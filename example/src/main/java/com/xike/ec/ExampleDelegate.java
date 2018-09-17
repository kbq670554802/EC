package com.xike.ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xike.kbq.core.delegates.KbqDelegate;
import com.xike.kbq.core.net.RestClient;
import com.xike.kbq.core.net.callback.IError;
import com.xike.kbq.core.net.callback.IFailure;
import com.xike.kbq.core.net.callback.ISuccess;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.OnClick;

public class ExampleDelegate extends KbqDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        TextView tvGet = rootView.findViewById(R.id.tv_get);
        TextView tvUpload = rootView.findViewById(R.id.tv_upload);
        tvGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGet();
            }
        });
        tvUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUpload();
            }
        });
    }

    public void onGet() {
        RestClient.builder()
                .url("http://news.baidu.com")
                .loader(getContext())
//                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();

                    }
                })
                .build()
                .get();
    }

    public void onUpload() {
        File file = new File("/storage/emulated/0/test.jpg");
        try {
            writeBytesToFile(getActivity().getAssets().open("test.jpg"), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestClient.builder()
                .url("http://fitness.zhk-inc.cn/api/uploadFile")
                .loader(getContext())
//                .file("/storage/emulated/0/test.jpg")
                .file(file)
//                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();

                    }
                })
                .build()
                .upload();
    }

    public static void writeBytesToFile(InputStream is, File file) throws IOException {
        FileOutputStream fos = null;
        try {
            byte[] data = new byte[2048];
            int nbread = 0;
            fos = new FileOutputStream(file);
            while ((nbread = is.read(data)) > -1) {
                fos.write(data, 0, nbread);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

}
