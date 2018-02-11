package com.animal.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestMain {
	public static void main(String[] args) {
		//反射获得AnimalSon
		Class<AnimalSon> clazz = AnimalSon.class;
		System.out.println("- - - - - - Annotation - - - - - -");
		for (Annotation annotation : clazz.getAnnotations()) {
			System.out.println(annotation);
		}
		System.out.println("- - - - - - Annotation Method - - - - - -");
		//如果有Test_Cat注解
		if (clazz.isAnnotationPresent(Test_Cat.class)) {
			Test_Cat cat = clazz.getAnnotation(Test_Cat.class);
			System.out.println(cat.catName());
		}
		//如果有Test_Dog注解
		if (clazz.isAnnotationPresent(Test_Dog.class)) {
			Test_Dog dog = clazz.getAnnotation(Test_Dog.class);
			System.out.println(dog.dogName());
		}
		//如果有Test_WhiteCat注解
		if (clazz.isAnnotationPresent(Test_WhiteCat.class)) {
			Test_WhiteCat whiteCat = clazz.getAnnotation(Test_WhiteCat.class);
			System.out.println(whiteCat.whiteCatName());
		}
		//如果有Test_BlackDog注解
		if (clazz.isAnnotationPresent(Test_BlackDog.class)) {
			Test_BlackDog blackDog = clazz.getAnnotation(Test_BlackDog.class);
			System.out.println(blackDog.blackDogName());
		}
	}
}

@Documented					
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Test_Cat {
	String catName() default "cat";
}

@Documented				
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Test_WhiteCat {
	String whiteCatName() default "white cat";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Test_Dog {
	String dogName() default "dog";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Test_BlackDog {
	String blackDogName() default "black dog";
}

@Test_Cat	//不可被继承
@Test_Dog	//可被继承
class AnimalFather{
	
}

@Test_WhiteCat
@Test_BlackDog
class AnimalSon extends AnimalFather{
	
}

