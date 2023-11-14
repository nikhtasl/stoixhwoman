package com.example.stoixhwoman.controller;

import com.example.stoixhwoman.model.Match;
import com.example.stoixhwoman.service.MatchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MatchController.class)
public class TestMatchController {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MatchService matchService;

    @Test
    public void testGetAllMatchesByDate()
            throws Exception {

        Match match1 = new Match();
        match1.setId(1L);
        match1.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 25));

        Match match2 = new Match();
        match2.setId(2L);
        match2.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 25));

        List<Match> allMatches = Arrays.asList(match1, match2);

        given(matchService.getAllMatchesByMatchDate(Mockito.any())).willReturn(allMatches);

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/matches/2023-11-25")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(match1.getId().intValue())))
                .andExpect(jsonPath("$[1].id", is(match2.getId().intValue())));
    }
}
