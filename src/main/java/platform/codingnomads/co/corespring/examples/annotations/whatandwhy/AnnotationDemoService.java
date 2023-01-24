package platform.codingnomads.co.corespring.examples.annotations.whatandwhy;

public class AnnotationDemoService implements LegacyInfoProvider {

    @ModernInfo
    @Override
    public String info() {
        return "legacy api fetching information";
    }

    @Override
    @SecondaryData
    public String data() {
        return "primary data";
    }
}




// Inside the LegacyInfoProvider interface, add a data()
// method that returns a String. Create another custom annotation called SecondaryData in which data() returns
// "secondary data return". In AnnotationDemoService, override data() with a return of "primary data" and add your
// @SecondaryData annotation. In AnnotationParsingDemo, modify the if statement to check for this new annotation, and call
// its data() method if present