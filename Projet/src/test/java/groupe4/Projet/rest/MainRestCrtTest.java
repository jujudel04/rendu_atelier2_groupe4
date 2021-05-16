package groupe4.Projet.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import groupe4.Projet.Model.User;
import groupe4.Projet.Service.UserService;
import groupe4.Projet.controller.MainRestCrt;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MainRestCrt.class)
public class MainRestCrtTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService hService;

/*	User mockHero=new User(1, "jdoe", "log" "pass");
	
	@Test
	public void signupUser() throws Exception {
		Mockito.when(
				hService.signup(Mockito.anyString(), Mockito.anyString())
				).thenReturn(mockHero);
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/signup/log/pass").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expectedResult="{\"id\":1,\"name\":\"jdoe\",\"superPowerName\":\"strong\",\"superPowerValue\":100,\"imgUrl\":\"https//url.com\"}";


		JSONAssert.assertEquals(expectedResult, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void retrieveHero() throws Exception {
		Mockito.when(
				hService.getHero(Mockito.anyInt())
				).thenReturn(mockHero);
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hero/50").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expectedResult="{\"id\":1,\"name\":\"jdoe\",\"superPowerName\":\"strong\",\"superPowerValue\":100,\"imgUrl\":\"https//url.com\"}";


		JSONAssert.assertEquals(expectedResult, result.getResponse()
				.getContentAsString(), false);
	}
*/
}
