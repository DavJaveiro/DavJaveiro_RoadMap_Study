package helloworld;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;

public class ContextLambda {
    public Map<String, Object> handler(Object input, Context context) {
        Map<String, Object> toReturn = new HashMap<>();

        Runtime runtime = Runtime.getRuntime();

        toReturn.put("getMemoryLimitInMB", context.getMemoryLimitInMB());
        toReturn.put("getFunctionName", context.getFunctionName());
        toReturn.put("getFunctionVersion", context.getFunctionVersion());
        toReturn.put("getInvokedFunctionArn", context.getInvokedFunctionArn());
        toReturn.put("getAwsRequestId",context.getAwsRequestId());
        toReturn.put("getLogStreamName",context.getLogStreamName());
        toReturn.put("getLogGroupName",context.getLogGroupName());
        toReturn.put("getClientContext",context.getClientContext());
        toReturn.put("getIdentity",context.getIdentity());
        toReturn.put("getRemainingTimeInMillis", context.getRemainingTimeInMillis());
        toReturn.put("jvmMaxMemory", runtime.maxMemory());
        return toReturn;
    }
}
