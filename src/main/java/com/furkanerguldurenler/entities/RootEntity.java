package com.furkanerguldurenler.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootEntity<T> {

    private boolean success;
    private String errorMessage;
    private T data;

    public static <T> RootEntity<T> ok(T data) {
        RootEntity<T> rootEntity = new RootEntity<>(true, null, data);
        return rootEntity;
    }

    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> rootEntity = new RootEntity<>(false, errorMessage, null);
        return rootEntity;
    }

    public static RootEntity<String> success() {
        RootEntity<String> rootEntity = new RootEntity<>(true, null, "operation was completed successfully");
        return rootEntity;
    }
}
