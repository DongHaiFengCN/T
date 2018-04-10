package doaing.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 项目名称：T
 * 类描述：
 * 创建人：donghaifeng
 * 创建时间：2018/4/8 9:57
 * 修改人：donghaifeng
 * 修改时间：2018/4/8 9:57
 * 修改备注：
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.init(this); // 尽可能早，推荐在Application中初始化


    }
}
