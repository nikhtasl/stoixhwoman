package com.example.stoixhwoman.controller;

import com.example.stoixhwoman.dto.MatchDTO;
import com.example.stoixhwoman.model.Match;
import com.example.stoixhwoman.service.MatchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
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
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MatchController.class)
public class TestMatchController {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MatchService matchService;

    @Test
    public void testGetAllMatchesByDate() throws Exception {

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

    @Test
    public void testAddMatch() throws Exception {

        Match match6 = new Match();
        match6.setId(6L);
        match6.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 29));

        given(matchService.addMatch(Mockito.any()))
                .willReturn(match6);

        MatchDTO matchDTO1 = new MatchDTO();
        matchDTO1.setTeam_a("OSFP");
        matchDTO1.setTeam_b("PAOK");

        mvc.perform(MockMvcRequestBuilders.post("/api/v1/match/")
                        .content(objectMapper.writeValueAsString(matchDTO1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(match6.getId().intValue())));
    }

    @Test
    public void testReadMatch() throws Exception {

        Match match3 = new Match();
        match3.setId(3L);
        match3.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 27));

        given(matchService.readMatch(Mockito.any()))
                .willReturn(match3);

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/match/3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(match3.getId().intValue())));
    }

    @Test
    public void testUpdateMatch() throws Exception {

        Match match4 = new Match();
        match4.setId(4L);
        match4.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 28));

        given(matchService.updateMatch(Mockito.any(), Mockito.any()))
                .willReturn(match4);

        MatchDTO matchDTO1 = new MatchDTO();
        matchDTO1.setTeam_a("OFA");
        matchDTO1.setTeam_b("PAO");

        mvc.perform(MockMvcRequestBuilders.put("/api/v1/match/4")
                        .content(objectMapper.writeValueAsString(matchDTO1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(match4.getId().intValue())));
    }

    @Test
    public void testDeleteMatchNotFound() throws Exception {

        doThrow(EmptyResultDataAccessException.class).when(matchService).deleteMatch(Mockito.anyLong());

        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/match/3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteMatch() throws Exception {


        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/match/3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}
