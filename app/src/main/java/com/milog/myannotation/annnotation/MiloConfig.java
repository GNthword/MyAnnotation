package com.milog.myannotation.annnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by miloway on 2018/6/21.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface MiloConfig {


    int value() default 0;
    int intType() default 0;
    String stringType() default "";
}
