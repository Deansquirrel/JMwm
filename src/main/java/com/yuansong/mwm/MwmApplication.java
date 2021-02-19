package com.yuansong.mwm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = { "com.yuansong" })
@EnableScheduling
@EnableAsync
public class MwmApplication {
	
	public static void main(String[] args) {
		long begTime = System.currentTimeMillis();

		SpringApplication.run(MwmApplication.class, args);

		long endTime = System.currentTimeMillis();

		System.out.println("\n" 
				+ "-----------------------------------------------------------------------\n"
				+ "-----------------------------------------------------------------------\n"
				+ "                               _     _\n" 
				+ "                              ( \\---/ )\n"
				+ "                               ) . . (\n"
				+ "-------------------------,--._(___Y___)_,--.---------------------------\n"
				+ "                         `--'           `--'\n"
				+ "                     	 mwm  启动成功                   \n" 
				+ "\n" + " 启动耗时: " + (endTime - begTime)
				+ "毫秒 \n" 
				+ "-----------------------------------------------------------------------\n"
				+ "-----------------------------------------------------------------------\n");

	}

}
