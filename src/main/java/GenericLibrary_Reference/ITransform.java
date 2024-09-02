package GenericLibrary_Reference;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class ITransform implements IAnnotationTransformer{
	
public void transform(ITestAnnotation annotation)
{
	annotation.setRetryAnalyzer(GenericLibrary_Reference.RetryImplementation.class);
}
}
