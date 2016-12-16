package cn.llsmpdroid.belief.manager.event;


import cn.llsmpdroid.belief.manager.imageloader.ILFactory;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */

public class BusFactory {
    private static IBus bus;

    public static IBus getBus() {
        if (bus == null) {
            synchronized (ILFactory.class) {
                if (bus == null) {
                    bus = new EventBusImpl();
                }
            }
        }
        return bus;
    }
}
