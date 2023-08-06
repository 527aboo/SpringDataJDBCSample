package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Member;
import com.example.demo.ropository.MemberCrudRepository;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {
	
	@Autowired
	MemberCrudRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcSampleApplication.class, args)
		.getBean(SpringDataJdbcSampleApplication.class).execute();;
	}
	
	private void execute() {
		System.out.println("execute");
		executeInsert();
		executeSelect();
	}
	
	private void executeInsert() {
		Member member = new Member(null, "花子");
		member = repository.save(member);
		
		System.out.println("登録したデータ：" + member);
	}
	
	private void executeSelect() {
		System.out.println("--- 全件取得します ---");
		Iterable<Member> members = repository.findAll();
		for (Member member : members) {
			System.out.println(member);
		}			
	}

}
