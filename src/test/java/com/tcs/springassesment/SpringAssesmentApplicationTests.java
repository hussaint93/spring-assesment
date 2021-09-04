package com.tcs.springassesment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import com.tcs.springassesment.entity.Question;
import com.tcs.springassesment.repository.IQuestionRepository;
import com.tcs.springassesment.service.IQuestionService;



@SpringBootTest
class SpringAssesmentApplicationTests {
	@Mock
	IQuestionRepository repo;

	@InjectMocks
	IQuestionService appointments;

	List<String> li = new ArrayList<String>();
	
	@Test
	void toRetrieveAllQuestions() {
		
		when(repo.findAll()).thenReturn(Arrays.asList(new Question(1,"ghhgff",li.add("hbdcjhbch"),2,2,null)));
		appointments.getAll();
	}
	
	@Test
	void testSavedQuestions() {
		Question  a1= new Question(2,"nmdcb",li.add("nbbdjbcjhbd"),1,4,null);
		when(repo.save(a1)).thenReturn(a1);
		Question q1 = appointments.saveQuestion(a1);
		assertEquals(a1.getId(), q1.getId());
	}
	
	@Test
	void testRetrieveQuestionsWithMoreThenZeroVotes() {
		List<Question> qu = new ArrayList<Question>();
		List<Question> ty = new ArrayList<Question>();
		qu.add(new Question(1,"nmdcb",li.add("nbbdjbcjhbd"),0,4,null));
		qu.add(new Question(2,"nmdcb",li.add("nbbdjbcjhbd"),2,1,null));
		qu.add(new Question(3,"nmdcb",li.add("ippuythbd"),2,4,null));
		qu.add(new Question(4,"nmdcb",li.add("bd"),0,4,null));
		for(int i=0;i<qu.size();i++) {
			assertNotEquals(qu.get(i), 0);
		}
	}
	
	@Test
	void testQuestionHasZeroVotes() {
		Question q1= new Question(2,"nmdcb",li.add("nbbdjbcjhbd"),0,4,null);
		assertEquals(q1.getVote(),0);
	}
	
	@Test
	void testDeleteAppointment() {
		Optional<Question> a1 = Optional.of(new Question(2,"nmdcb",li.add("nbbdjbcjhbd"),0,4,null));
		when(repo.findById(2)).thenReturn(a1).thenReturn(null);
		assertNull(repo.findById(2));
	}
}
