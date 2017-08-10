package com.wuyuan.jpush.service;

import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

/**
 * Created by xuwuyuan on 2017/8/10.
 */
public interface PushService {

    PushPayload buildPushObject_all_alias_alert();

    PushResult sendPush(PushPayload pushPayload);
}
