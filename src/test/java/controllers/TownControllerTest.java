package controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.diginamic.web.dto.TownDTO;
import com.diginamic.web.mappers.TownMapper;
import com.diginamic.web.models.*;
import com.diginamic.web.repo.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class TownControllerTest {
	
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	MockMvc mock;
	
	@MockBean
	TownRepository townRepository;
	@MockBean
	DepartmentRepository departmentRepository;

	@Test
	public void testGetAllTowns() throws Exception {
		Town t1 = new Town("Paris", 11111, new Department("75","Paris"));
		Town t2 = new Town("Marseille",22222,new Department("13", "Bouche du Rhone"));
		Town t3 = new Town("Lyon",33333,new Department("69","Rhone"));
		
		when(townRepository.findAll()).thenReturn(List.of(t1, t2, t3));
		
		//
		this.mock.perform(MockMvcRequestBuilders.get("/towns")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Marseille")));
	}
	
	@Test
	void addTownKo() throws Exception {
		this.mock.perform(MockMvcRequestBuilders.post("/towns")
				.content(objectMapper.writeValueAsString(new TownDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void addTownOk() throws Exception {
		Department department = new Department("49", "Maine-et-Loire");
		Town newTown = new Town("Angers", 142000, department);
		
		List<Department> expectedResult = new ArrayList<Department>();
		expectedResult.add(department);
		
		when(departmentRepository.findByCode(anyString())).thenReturn(expectedResult);
		
		this.mock.perform(MockMvcRequestBuilders.post("/towns")
				.content(objectMapper.writeValueAsString(TownMapper.toDto(newTown)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
}
