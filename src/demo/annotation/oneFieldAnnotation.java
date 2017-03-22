package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface oneFieldAnnotation {

	public boolean nameString() default false;

	public int ageInt() default -1;

	// 使用枚举类型 设置注解值
	public Color blu() default Color.BOOL;

}
