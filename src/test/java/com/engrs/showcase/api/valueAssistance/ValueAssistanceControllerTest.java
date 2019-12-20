package com.engrs.showcase.api.valueAssistance;

import com.engrs.showcase.domain.valueAssistance.ValueAssistanceProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ValueAssistanceController.class)
public class ValueAssistanceControllerTest
{
  @Autowired
  protected ObjectMapper mapper;

  @Autowired
  protected MockMvc mvc;

  @MockBean
  private ValueAssistanceService service;

  @Test
  public void getValueAssistanceTest() throws Exception
  {
    List<String> vaTypes = Collections.singletonList("BusinessModel");
    ValueAssistanceDTOBuilder dtoBuilder = new ValueAssistanceDTOBuilder();
    ValueAssistanceProvider valueAssistanceProvider = new ValueAssistanceProvider();
    valueAssistanceProvider.forEach(new HashSet<>(vaTypes), dtoBuilder::add);
    ValueAssistanceDTO valueAssistanceDTO = dtoBuilder.build();

    given(service.getValueAssistance(vaTypes))
            .willReturn(valueAssistanceDTO);

    String resultJson = mapper.writeValueAsString(valueAssistanceDTO);

    mvc.perform(MockMvcRequestBuilders
        .get("/api/va?types=BusinessModel")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().json(resultJson));
  }
}

