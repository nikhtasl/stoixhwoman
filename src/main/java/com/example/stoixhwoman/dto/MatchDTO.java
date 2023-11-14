package com.example.stoixhwoman.dto;

import com.example.stoixhwoman.enums.Sport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MatchDTO {
    private LocalDate matchDate;
    private LocalTime matchTime;
    private String team_a;
    private String team_b;
    private Sport sport;
    private List<MatchOddsDTO> matchOddsDTOs;

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeam_a() {
        return team_a;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public List<MatchOddsDTO> getMatchOddsDTOs() {
        return matchOddsDTOs;
    }

    public void setMatchOddsDTOs(List<MatchOddsDTO> matchOddsDTOs) {
        this.matchOddsDTOs = matchOddsDTOs;
    }
}
