package io.hackages.learning.domain.manager.flight.core;

import io.hackages.learning.domain.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.domain.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FlightServiceImplTest {

    @Mock FlightServiceProvider flightProvider;

    @InjectMocks FlightServiceImpl flightService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenNoParameters_whenGetFlight_thenSucceed() {
        //given
        Flight flight = mock(Flight.class);
        when(flightProvider.getFlight()).thenReturn(Arrays.asList(flight, flight));
        //when
        List<Flight> flights =  flightService.getFlights();
        //then
        assertThat(flights.size()).isEqualTo(2);
    }

}