package com.example.stoixhwoman.utilities;

import com.example.stoixhwoman.dto.MatchDTO;
import com.example.stoixhwoman.dto.MatchOddsDTO;
import com.example.stoixhwoman.model.Match;
import com.example.stoixhwoman.model.MatchOdds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOUtilities {

    public Match transformMatchDTOToMatch(MatchDTO matchDTO) {
        Match match = new Match();
        match.setDescription(matchDTO.getTeam_a() + "-" + matchDTO.getTeam_b());
        match.setMatchDate(matchDTO.getMatchDate());
        match.setMatchTime(matchDTO.getMatchTime());
        match.setTeam_a(matchDTO.getTeam_a());
        match.setTeam_b(matchDTO.getTeam_b());
        match.setSport(matchDTO.getSport());
        List<MatchOdds> matchOddsList = new ArrayList<>();
        for (MatchOddsDTO matchOddDTO : matchDTO.getMatchOddsDTOs()) {
            matchOddsList.add(transformMatchOddsDTOToMatchOdds(matchOddDTO));
        }
        match.setMatchOdds(matchOddsList);
        return match;
    }

    public MatchOdds transformMatchOddsDTOToMatchOdds(MatchOddsDTO matchOddsDTO) {
        MatchOdds matchOdds = new MatchOdds();
        matchOdds.setSpecifier(matchOddsDTO.getSpecifier());
        matchOdds.setOdd(matchOddsDTO.getOdd());
        return matchOdds;
    }
}
