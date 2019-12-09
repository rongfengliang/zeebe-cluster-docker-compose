package com.dalong;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
public class Application {

    public static void main(String[] args) {

        final String broker = "nginx-grpc-lb:26500";
        final String bpmnProcessId = "demoProcess";
        ZeebeClient client = ZeebeClient.newClientBuilder()
                .brokerContactPoint(broker)
                .usePlaintext()
                .build();
        for (int i = 0; i <1000000 ; i++) {
            final WorkflowInstanceEvent wfInstance = client.newCreateInstanceCommand()
                    .bpmnProcessId(bpmnProcessId)
                    .latestVersion()
                    .send()
                    .join();

            final long workflowInstanceKey = wfInstance.getWorkflowInstanceKey();

            System.out.println("Workflow instance created. Key: " + workflowInstanceKey);
        }
    }
}
