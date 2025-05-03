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
        return new RootEntity<>(true, null, data);
    }

    public static <T> RootEntity<T> error(String errorMessage) {
        return new RootEntity<>(false, errorMessage, null);
    }

    public static RootEntity<String> success() {
        return new RootEntity<>(true, null, "operation was completed successfully");
    }
}
