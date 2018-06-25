package com.milog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by miloway on 2018/6/21.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface MiloConfig2 {


    int value() default -1;
    int intType() default -1;
    String stringType() default "";
}
