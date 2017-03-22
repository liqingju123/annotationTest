package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestThis {
	public void classAnnotationTest() throws Exception {
		Class<?> oneclass = Class.forName(OneClass.class.getName());
		ClassAnnotation classAnnotation = oneclass.getAnnotation(ClassAnnotation.class);
		System.out.println(classAnnotation.name());
	}

	public void methodAnnotationTest() throws Exception {
		Class<?> oneclass = Class.forName(OneClass.class.getName());
		ClassAnnotation classAnnotation = oneclass.getAnnotation(ClassAnnotation.class);
		System.out.println(classAnnotation.name());

		Method twoMethod = oneclass.getMethod("twoMethod", String.class, int.class);
		Method method = oneclass.getMethod("oneMethod");

		Annotation[][] annotations = twoMethod.getParameterAnnotations();
		ParameterAnnotation parameterAnnotation = (ParameterAnnotation) annotations[1][0];
		System.out.println("parameterAnnotation===  " + parameterAnnotation.name());
		System.out.println("parameterAnnotation===  " + parameterAnnotation.age());
		// 从Method方法中通过方法getAnnotation获得我们设置的注解
		oneMethodAnnotation oneAnnotation = method.getAnnotation(oneMethodAnnotation.class);
		// 得到注解的俩参数
		System.out.println(oneAnnotation.parameter1());
		System.out.println(oneAnnotation.parameter2());
	}

	public void fieldAnnotationTest() throws Exception {
		Class<?> oneclass = Class.forName(OneClass.class.getName());
		OneClass oneClassModel = (OneClass) oneclass.newInstance();

		Field field = oneclass.getField("name");
		// bean 属性设置值
		field.set(oneClassModel, "name==name");
		oneFieldAnnotation oneField = field.getAnnotation(oneFieldAnnotation.class);
		String name = (String) field.get(oneClassModel);
		System.out.println("name" + name + "   " + oneField.name());
	}

	public static void main(String[] args) throws Exception {

	}
}
