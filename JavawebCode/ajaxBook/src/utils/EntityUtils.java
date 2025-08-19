package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class EntityUtils {

    /**
     * 把map中的属性值注入到Java Bean属性中
     * @param value
     * @param bean
     * @return
     * @param <T>
     */
    public static <T> T copyParamToBean(Map value, T bean){
        System.out.println("注入之前"+bean);
        try {
            /**
             * 把所有属性都注入到user对象中
             */
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println("注入之后"+bean);
        return bean;
    }

    /**
     * 将字符串转换成int类型的数据
     * @param str
     * @param defaultValue
     * @return
     */
    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
