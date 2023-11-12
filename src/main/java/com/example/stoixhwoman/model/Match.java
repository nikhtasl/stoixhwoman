package com.example.stoixhwoman.model;

import com.example.stoixhwoman.enums.Sport;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String description;
    private LocalDate match_date;
    private LocalDateTime match_time;
    private String team_a;
    private String team_b;
    private Sport sport;
    @OneToMany(mappedBy = "match")
    private List<MatchOdds> matchOdds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMatch_date() {
        return match_date;
    }

    public void setMatch_date(LocalDate match_date) {
        this.match_date = match_date;
    }

    public LocalDateTime getMatch_time() {
        return match_time;
    }

    public void setMatch_time(LocalDateTime match_time) {
        this.match_time = match_time;
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

    public List<MatchOdds> getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(List<MatchOdds> matchOdds) {
        this.matchOdds = matchOdds;
    }
}
