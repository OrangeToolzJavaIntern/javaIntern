package com.example.demo;



import javax.sql.DataSource;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Bean.User;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;
	
	



	@Bean
	public FlatFileItemReader<User> reader() {

		FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
		reader.setResource(new ClassPathResource("records.csv"));
		reader.setLineMapper(new DefaultLineMapper<User>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "fname", "lname", "email" });

					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {
					{
						setTargetType(User.class);
					}
				});

			}
		});

		return reader;
	}

	@Bean
	public UserItemProcessor processor() {
		return new UserItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<User> writer() {
		JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<User>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
		
		writer.setSql("INSERT INTO user(fname,lname,email) VALUES (:fname, :lname, :email)");
	    
		
		
		writer.setDataSource(dataSource);
		
		System.out.println(writer);

		return writer;
	}
	
	

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<User, User>chunk(10000)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.faultTolerant()
				.build();
	}

	@Bean
	public Job importUserJob() {

		return (Job) jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}
	
	
	

}

