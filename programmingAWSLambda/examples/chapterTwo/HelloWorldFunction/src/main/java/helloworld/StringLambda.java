package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class StringLambda implements RequestHandler<String, String>{
    @Override
    public String handleRequest(String input, Context context) {
        return "Hello, " + input;
    }
}
