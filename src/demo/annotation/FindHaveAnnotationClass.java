package demo.annotation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class FindHaveAnnotationClass extends ClassLoader {

	/**
	 * 指定包下 指定
	 * 
	 * @param classPath
	 *            包路径
	 * @param clazzAnnotation
	 *            类注解类型
	 */
	public static void findClass(String classPath, Class clazzAnnotation) {
		try {
			Enumeration<URL> relu = getSystemClassLoader().getResources(classPath);
			while (relu.hasMoreElements()) {
				URL url = (URL) relu.nextElement();
				File files = new File(url.getPath());
				File[] allClass = files.listFiles();
				for (int i = 0; i < allClass.length; i++) {
					String className = allClass[i].getName();

					// allClass[i].getAbsolutePath();
					if (!allClass[i].isDirectory()) {

						// System.out.println(className);
						try {
							// System.out.println(classPath);
							Class<?> clazz = Class.forName(String.format("%s.%s", classPath.replaceAll("/", "."),
									className.substring(0, className.indexOf("."))));
							ClassAnnotation classAnnotation = (ClassAnnotation) clazz.getAnnotation(clazzAnnotation);
							if (classAnnotation != null) {
								System.out.println("含有ClassAnnotation注解的class== " + clazz.getName());
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					} else {
						String filePath = allClass[i].getPath();
						// 获取到相对地址 递归扫描
						filePath = filePath.substring(filePath.lastIndexOf(classPath), filePath.length());
						findClass(filePath, clazzAnnotation);
					}

				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		findClass("demo/annotation", ClassAnnotation.class);
	}

}
