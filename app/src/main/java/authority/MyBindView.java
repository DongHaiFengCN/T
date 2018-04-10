package authority;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 项目名称：MyApplication
 * 类描述：
 * 创建人：donghaifeng
 * 创建时间：2018/4/4 11:08
 * 修改人：donghaifeng
 * 修改时间：2018/4/4 11:08
 * 修改备注：
 */

public class MyBindView {

    public static void bindView(Activity activity) {

        Class a = activity.getClass();

        //-----------------------------------------------------------------
        //首先判断有没有加载ACTIVITY的权限，没有直接返回
        //-----------------------------------------------------------------
        if (a.isAnnotationPresent(Interceptor.class)) {

            AuthorityShow authorityShow = (AuthorityShow) activity;
            Interceptor interceptor = (Interceptor) a.getAnnotation(Interceptor.class);
            // 得到注解的值
            String key = interceptor.key();

            //没有注册拦截
            if (!assess(key)) {

                //不满足条件输出一下信息
                authorityShow.show();

                try {
                    Method method = a.getMethod("finish");
                    method.setAccessible(true);
                    method.invoke(activity);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }


        }

        //-----------------------------------------------------------------
        //绑定Activity视图
        //-----------------------------------------------------------------
/*        if (a.isAnnotationPresent(ContentView.class)) {

            ContentView contentView = (ContentView) a.getAnnotation(ContentView.class);
            // 得到注解的值
            int layoutId = contentView.value();
            // 使用反射调用setContentView
            try {
                Method method = a.getMethod("setContentView", int.class);
                method.setAccessible(true);
                method.invoke(activity, layoutId);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }*/


        //-----------------------------------------------------------------
        //控件id绑定,以及注册权限
        //-----------------------------------------------------------------


        // 得到activity所有字段
        Field[] fields = a.getDeclaredFields();

        // 得到被ViewBindId注解的字段
        for (Field field : fields) {


            if (field.isAnnotationPresent(ViewBindId.class)) {

                // 得到字段的ViewBindId注解
                ViewBindId viewBindId = field.getAnnotation(ViewBindId.class);

                // 得到注解的值
                int viewId = viewBindId.id();

                //应该是权限组？？？？？
                String[] key = viewBindId.key();

                try {
                    // 使用反射调用findViewById，并为字段设置值
                    Method method = a.getMethod("findViewById", int.class);
                    method.setAccessible(true);

                    //获取运行时的对象
                    View resView = (View) method.invoke(activity, viewId);

                    AuthorityCentre singleton = AuthorityCentre.getInstance();
                    for (int i = 0; i < key.length; i++) {

                        //查找控件注册的权限
                        if (key[i].equals(AuthorityInfo.VIEW_VISIABLE)) { //不能显示

                            if (singleton.getAuthorityItem(key[i]) != null){

                                if(!singleton.getAuthorityItem(key[i])){

                                    Method setMethod = resView.getClass()
                                            .getMethod("setVisibility", int.class);

                                    setMethod.invoke(resView, View.INVISIBLE);

                                }else {

                                    Method setMethod = resView.getClass()
                                            .getMethod("setVisibility", int.class);
                                    setMethod.invoke(resView, View.VISIBLE);

                                }

                            }else if(key[i].equals(AuthorityInfo.EDIT_ENABLE)){


                                if (singleton.getAuthorityItem(key[i]) != null){

                                    if(!singleton.getAuthorityItem(key[i])){


                                        Method setMethod = resView.getClass()
                                                .getMethod("setEnabled", boolean.class);

                                        setMethod.invoke(resView, false);

                                    }else {

                                        Method setMethod = resView.getClass()
                                                .getMethod("setEnabled", boolean.class);
                                        setMethod.invoke(resView,true);

                                    }

                                }

                            }

                        }else if(key[i].equals(AuthorityInfo.EDIT_ENABLE)){

                            if (singleton.getAuthorityItem(key[i]) != null){


                                if(!singleton.getAuthorityItem(key[i])){


                                    Method setMethod = resView.getClass()
                                            .getMethod("setEnabled", boolean.class);

                                    setMethod.invoke(resView, false);

                                }else {

                                    Method setMethod = resView.getClass()
                                            .getMethod("setEnabled", boolean.class);
                                    setMethod.invoke(resView,true);

                                }

                            }

                        }
                    }

                    field.setAccessible(true);
                    field.set(activity, resView);

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private static boolean assess(String key) {


        AuthorityCentre singleton = AuthorityCentre.getInstance();

        if (singleton.getAuthorityItem(key) == null) {

            return false;
        }


        return singleton.getAuthorityItem(key);
    }


}
