package com.furkanerguldurenler.controller.impl;

import com.furkanerguldurenler.entities.RootEntity;

public class RestBaseController {

    public <T> RootEntity<T> ok(T data) {
        return RootEntity.ok(data);
    }

    public <T> RootEntity<T> error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }

    public RootEntity<String> success() {
        return RootEntity.success();
    }

}
