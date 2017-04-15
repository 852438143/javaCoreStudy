package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**声明类是用来使用的,通过别的类来处理,主要是配置作用,通过反射来获取注解信息
 * Created by 85243 on 2017/4/9.
 */
@Retention(RetentionPolicy.RUNTIME)//注解保留的时期,保留到运行时期
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.METHOD})//可使用注解的地方
public @interface AnnotationDemo1 {
    String name() default "";
}
