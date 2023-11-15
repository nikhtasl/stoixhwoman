package com.example.stoixhwoman.service;

import com.example.stoixhwoman.dto.MatchDTO;
import com.example.stoixhwoman.model.Match;
import com.example.stoixhwoman.repository.MatchRepository;
import com.example.stoixhwoman.utilities.DTOUtilities;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestMatchService {

    @InjectMocks
    private MatchService matchService;

    @Mock
    private MatchRepository matchRepository;
    @Mock
    private DTOUtilities dtoUtilities;

    @Test
    public void testGetAllMatchesByDate() throws Exception {
        Match match1 = new Match();
        match1.setId(1L);
        match1.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 25));

        Match match2 = new Match();
        match2.setId(2L);
        match2.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 25));

        List<Match> allMatches = Arrays.asList(match1, match2);

        when(matchRepository.getMatchesByMatchDate(Mockito.any())).thenReturn(allMatches);

        List<Match> result = matchService.getAllMatchesByMatchDate(LocalDate.of(2023, Month.NOVEMBER, 25));

        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(match1));
        Assert.assertTrue(result.contains(match2));
    }

    @Test
    public void testAddMatch() throws Exception {

        Match match6 = new Match();
        match6.setId(6L);
        match6.setTeam_a("OSFP");
        match6.setTeam_b("PAOK");
        match6.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 29));

        when(matchRepository.save(Mockito.any()))
                .thenReturn(match6);

        when(dtoUtilities.transformMatchDTOToMatch(Mockito.any()))
                .thenReturn(match6);

        MatchDTO matchDTO1 = new MatchDTO();
        matchDTO1.setTeam_a("OSFP");
        matchDTO1.setTeam_b("PAOK");

        Match result = matchService.addMatch(matchDTO1);

        Assert.assertNotNull(result);
        Assert.assertEquals("OSFP", result.getTeam_a());
        Assert.assertEquals("PAOK", result.getTeam_b());
    }

    @Test
    public void testReadMatch() throws Exception {

        Match match3 = new Match();
        match3.setId(3L);
        match3.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 27));

        when(matchRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(match3));
        Match result = matchService.readMatch(3L);

        Assert.assertNotNull(result);
        Assert.assertEquals(3L, result.getId().longValue());
    }

    @Test
    public void testUpdateMatch() throws Exception {

        Match match4 = new Match();
        match4.setId(4L);
        match4.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 28));

        when(matchRepository.save(Mockito.any()))
                .thenReturn(match4);
        when(dtoUtilities.transformMatchDTOToMatch(Mockito.any()))
                .thenReturn(match4);

        MatchDTO matchDTO1 = new MatchDTO();
        matchDTO1.setTeam_a("OFA");
        matchDTO1.setTeam_b("PAO");

        Match result = matchService.updateMatch(4L, matchDTO1);

        Assert.assertNotNull(result);
        Assert.assertEquals(4L, result.getId().longValue());
    }

    @Test
    public void testDeleteMatch() throws Exception {
        doNothing().when(matchRepository).deleteById(Mockito.any());
        matchService.deleteMatch(4L);

    }

}
