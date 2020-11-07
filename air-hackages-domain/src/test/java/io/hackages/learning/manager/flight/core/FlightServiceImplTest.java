package io.hackages.learning.manager.flight.core;

import io.hackages.learning.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @Mock FlightServiceProvider flightProvider;

    FlightServiceImpl flightService;

    @BeforeEach
    void setUp() {
        flightService = new FlightServiceImpl(flightProvider);
    }

    @Test
    void getFlight() {
        //given
        Flight flight = mock(Flight.class);
        when(flightProvider.getFlight(null)).thenReturn(Arrays.asList(flight, flight));
        //when
        List<Flight> flights =  flightService.getFlights(null);
        //then
        assertThat(flights.size()).isEqualTo(2);
    }

}