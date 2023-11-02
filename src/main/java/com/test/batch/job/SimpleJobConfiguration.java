package com.test.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Configuration
public class SimpleJobConfiguration {
	
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job simpleJob() {
		return jobBuilderFactory
				.get("simpleJob")
				.start(simpleStep1())
				.next(simpleStep2())
				.build();
	}
	
	@Bean
	public Step simpleStep1() {
		return stepBuilderFactory.get("simpleStep3")
				.tasklet((contribution,chunkContext)->{
				 System.out.println("hello world");
				return RepeatStatus.FINISHED;
				})
				.build();
		
	}
	
	@Bean
	public Step simpleStep2() {
		return stepBuilderFactory.get("simpleStep4")
				.tasklet((contribution,chunkContext)->{
				 System.out.println("hello world2");
				return RepeatStatus.FINISHED;
				})
				.build();
		
	}
	

}
