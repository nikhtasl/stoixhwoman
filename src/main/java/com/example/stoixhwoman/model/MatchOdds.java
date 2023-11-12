package com.example.stoixhwoman.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_odds")
public class MatchOdds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private char specifier;
    private double odd;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getSpecifier() {
        return specifier;
    }

    public void setSpecifier(char specifier) {
        this.specifier = specifier;
    }

    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }
}
