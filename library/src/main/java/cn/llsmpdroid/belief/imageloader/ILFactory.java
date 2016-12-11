package cn.llsmpdroid.belief.imageloader;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */
public class ILFactory {

    private static ILoader loader;


    public static ILoader getLoader() {
        if (loader == null) {
            synchronized (ILFactory.class) {
                if (loader == null) {
                    loader = new GlideLoader();
                }
            }
        }
        return loader;
    }


}
