package com.example;

import entity.Course;
import entity.Section;
import entity.Tag;
import entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.*;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	UserRepository userRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	TagRepository tagRepository;

	@Autowired
	ContentRepository contentRepository;
	@Test
	public void contextLoads() {
	}
	@Test
	public void addCourse(){
		User user=new User("lhr","123");
		userRepository.save(user);
		Course course =new Course();
		course.setAuto(user);
		course.setName("商业应用架构及其实践");
		courseRepository.save(course);
		Assert.assertNotNull(course.getId());

		Section htmlsection=new Section();
		Section csssection=new Section();
		Section bootstrapsection=new Section();
		Section javascriptsection =new Section();
		Section springbootsection =new Section();
		Section editormdsection =new Section();

		htmlsection.setTitle("HTML基础");
		htmlsection.setCourse(course);
		htmlsection.setIntroduction("前端HTML基础知识，包括页面结构、常用标签");
		htmlsection.getTags().add(new Tag("HTML基础"));
		htmlsection.getTags().add(new Tag("HTML5页面结构"));
		htmlsection.getTags().add(new Tag("HTML标签"));

		csssection.setTitle("CSS基础");
		csssection.setCourse(course);
		csssection.setIntroduction("前端CSS基础知识，包括CSS语法基础、CSS常用属性");
		csssection.getTags().add(new Tag("CSS基础"));
		csssection.getTags().add(new Tag("CSS语法基础"));
		csssection.getTags().add(new Tag("CSS常用属性"));

		bootstrapsection.setTitle("Bootstrap实践");
		bootstrapsection.setCourse(course);
		bootstrapsection.setIntroduction("Bootstrap框架简介，Bootstrap基本使用、Bootstrap常用组件");
		bootstrapsection.getTags().add(new Tag("Bootstrap简介"));
		bootstrapsection.getTags().add(new Tag("Bootstrap组件"));

		javascriptsection.setTitle("JavaScript基础 & jQuery & Ajax");
		javascriptsection.setCourse(course);
		javascriptsection.setIntroduction("前端JavaScript基础知识，包括JavaScript语法基础、JavaScript面向对象、jQuery基础、Ajax");
		javascriptsection.getTags().add(new Tag("JavaScript基础"));
		javascriptsection.getTags().add(new Tag("JavaScript面向对象"));
		javascriptsection.getTags().add(new Tag("jQuery基础"));
		javascriptsection.getTags().add(new Tag("Ajax基础"));

		springbootsection.setTitle("Spring Boot Controller & Repository");
		springbootsection.setCourse(course);
		springbootsection.setIntroduction("Spring Boot框架简介、Spring Boot项目基础、Spring Boot Controller基础、Spring Boot JPA Repository基础");
		springbootsection.getTags().add(new Tag("Spring Boot项目基础"));
		springbootsection.getTags().add(new Tag("Spring Boot Controller基础"));
		springbootsection.getTags().add(new Tag("JPA Repository基础"));

		editormdsection.setTitle("Editor.md & 文件上传");
		editormdsection.setCourse(course);
		editormdsection.setIntroduction("富文本框编辑器简介、Markdown编辑器、图片上传");
		editormdsection.getTags().add(new Tag("Markdown基础"));
		editormdsection.getTags().add(new Tag("Editor.md"));
		editormdsection.getTags().add(new Tag("Spring Boot文件上传"));

		sectionRepository.save(Arrays.asList(htmlsection,csssection,bootstrapsection,javascriptsection,springbootsection,editormdsection));
	}

}

