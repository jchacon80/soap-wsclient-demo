package com.pspro.soapwsclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.pspro.schemas.school.StudentDetailsRequest;
import com.pspro.schemas.school.StudentDetailsResponse;
 
@SpringBootApplication
public class SoapWsclientDemoApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SoapWsclientDemoApplication.class, args);
    }
     
    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Sajal";//Default Name
            if(args.length>0){
                name = args[0];
            }
            StudentDetailsRequest request = new StudentDetailsRequest();
            request.setName(name);
            StudentDetailsResponse response =(StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
            System.out.println("Got Response As below ========= : ");
            System.out.println("Name : "+response.getStudent().getName());
            System.out.println("Standard : "+response.getStudent().getStandard());
            System.out.println("Address : "+response.getStudent().getAddress());
        };
    }
}