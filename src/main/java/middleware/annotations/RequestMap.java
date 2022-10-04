package main.java.middleware.annotations;

// Fonte: https://www.eclipse.org/aspectj/doc/released/adk15notebook/annotations.html#using-annotations

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RequestMap {
	
    public String router() default "";

}
