package com.example.stoixhwoman.service;

import com.example.stoixhwoman.dto.MatchDTO;
import com.example.stoixhwoman.dto.MatchOddsDTO;
import com.example.stoixhwoman.model.Match;
import com.example.stoixhwoman.model.MatchOdds;
import com.example.stoixhwoman.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatchesByMatchDate(LocalDate date) {
        return matchRepository.getMatchesByMatchDate(date);
    }

    public Match addMatch(MatchDTO matchDTO) {
        Match match = transformMatchDTOToMatch(matchDTO);
        return matchRepository.save(match);
    }

    public Match readMatch(Long id) {
        return matchRepository.findById(id).get();
    }

    public Match updateMatch(Long id, MatchDTO matchDTO) {
        Match match = transformMatchDTOToMatch(matchDTO);
        match.setId(id);
        return matchRepository.save(match);
    }

    Match transformMatchDTOToMatch(MatchDTO matchDTO) {
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

    MatchOdds transformMatchOddsDTOToMatchOdds(MatchOddsDTO matchOddsDTO) {
        MatchOdds matchOdds = new MatchOdds();
        matchOdds.setSpecifier(matchOddsDTO.getSpecifier());
        matchOdds.setOdd(matchOddsDTO.getOdd());
        return matchOdds;
    }

}
