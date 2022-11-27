package com.dmvirtualstore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DmVirtualStoreApplication implements CommandLineRunner {

	/*
	@Autowired
	private S3Service s3Service;
	*/


	
	public static void main(String[] args) {
		SpringApplication.run(DmVirtualStoreApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		//s3Service.uploadFile("E:\\Pictures\\amor\\20200216_130143.jpg");



	}

}
