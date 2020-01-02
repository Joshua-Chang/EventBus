package com.example.eventbus;


import java.lang.Class;
import java.lang.Override;
import java.util.HashMap;
import java.util.Map;

public final class EventBusIndex implements SubscriberInfoIndex {
  private static final Map<Class, SubscriberInfo> SUBSCRIBER_INDEX;

  static {
    SUBSCRIBER_INDEX = new HashMap<Class, SubscriberInfo>();
    putIndex(new EventBeans(SecondActivity.class, new SubscriberMethod[] {
      new SubscriberMethod(SecondActivity.class, "sticky", UserInfo.class, ThreadMode.MAIN, 0, true)} ));
    putIndex(new EventBeans(MainActivity.class, new SubscriberMethod[] {
      new SubscriberMethod(MainActivity.class, "abc", UserInfo.class, ThreadMode.ASYNC, 0, false),
      new SubscriberMethod(MainActivity.class, "abc2", UserInfo.class, ThreadMode.ASYNC, 5, false)} ));
  }

  private static void putIndex(SubscriberInfo info) {
    SUBSCRIBER_INDEX.put(info.getSubscriberClass(), info);
  }

  @Override
  public SubscriberInfo getSubscriberInfo(Class subscriberClass) {
    return SUBSCRIBER_INDEX.get(subscriberClass);
  }
}
