package authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import authority.AuthorityInfo;

/**
 * 项目名称：MyApplication
 * 类描述：
 * 创建人：donghaifeng
 * 创建时间：2018/4/4 11:13
 * 修改人：donghaifeng
 * 修改时间：2018/4/4 11:13
 * 修改备注：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewBindId {

    int id();

    String[] key();

}
