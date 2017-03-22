package demo.annotation;

@ClassAnnotation(name = "liqingjudeclass")
public class OneClass {
	@oneFieldAnnotation(name = "liqingju")
	public String name;

	@oneMethodAnnotation(parameter1 = "YES", parameter2 = 10000)
	public void oneMethod() {
	}

	public void twoMethod(@ParameterAnnotation(name = "liqingju") String name, @ParameterAnnotation(age = 1) int age) {

	}
}
