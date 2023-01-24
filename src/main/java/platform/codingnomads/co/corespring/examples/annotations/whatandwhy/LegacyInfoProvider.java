package platform.codingnomads.co.corespring.examples.annotations.whatandwhy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface LegacyInfoProvider {
    String info();

    @SecondaryData
    String data();


    @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface SecondaryData {
            @SecondaryData
            String data() default "secondary data return";
        }


    }









   // Inside the LegacyInfoProvider interface, add a data()
// method that returns a String. Create another custom annotation called SecondaryData in which data() returns
// "secondary data return". In AnnotationDemoService, override data() with a return of "primary data" and add your
// @SecondaryData annotation. In AnnotationParsingDemo, modify the if statement to check for this new annotation, and call
// its data() method if present
