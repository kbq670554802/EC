package com.xike.kbq.core.ui.camera;

import android.net.Uri;

import com.xike.kbq.core.delegates.PermissionCheckerDelegate;
import com.xike.kbq.core.util.file.FileUtil;

/**
 * Created by 傅令杰
 * 照相机调用类
 */

public class KbqCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }
}
