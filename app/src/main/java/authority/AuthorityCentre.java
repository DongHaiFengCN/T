package authority;

import java.util.HashMap;

/**
 * 项目名称：MyApplication
 * 类描述：
 * 创建人：donghaifeng
 * 创建时间：2018/4/8 15:10
 * 修改人：donghaifeng
 * 修改时间：2018/4/8 15:10
 * 修改备注：
 */

public class AuthorityCentre {

    private static HashMap<String, Boolean> map = new HashMap<>();

    private AuthorityCentre() {
    }

    public static AuthorityCentre getInstance() {

        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {

        private static final AuthorityCentre sInstance = new AuthorityCentre();
    }

    public void putAuthorityItem(String key, Boolean value) {


            map.put(key, value);

    }

    public Boolean getAuthorityItem(String key){

        return map.get(key);
    }

    public void clear() {

        if (!map.keySet().isEmpty()) {

            map.clear();
        }

    }

}
