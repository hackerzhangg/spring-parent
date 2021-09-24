package com.emily.infrastructure.rpc.client.pool;

import com.emily.infrastructure.rpc.client.handler.BaseClientHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: spring-parent
 * @description:
 * @author: Emily
 * @create: 2021/09/23
 */
public class ClientResource {

    public static Map<String, BaseClientHandler> handlerMap = new ConcurrentHashMap();

}