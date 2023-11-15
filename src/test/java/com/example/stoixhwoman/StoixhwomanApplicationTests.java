package com.example.stoixhwoman;

import com.example.stoixhwoman.controller.MatchController;
import com.example.stoixhwoman.repository.MatchRepository;
import com.example.stoixhwoman.service.MatchService;
import com.example.stoixhwoman.utilities.DTOUtilities;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class StoixhwomanApplicationTests {

    @Autowired
    private MatchController matchController;

    @Autowired
    private MatchService matchService;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private DTOUtilities dtoUtilities;

    @Test
    void contextLoads() {
        assertNotNull(matchController);
        assertNotNull(matchService);
        assertNotNull(matchRepository);
        assertNotNull(dtoUtilities);
    }

}
