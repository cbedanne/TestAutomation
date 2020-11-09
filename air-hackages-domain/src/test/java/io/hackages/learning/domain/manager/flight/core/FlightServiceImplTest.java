package io.hackages.learning.domain.manager.flight.core;

import io.hackages.learning.domain.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.domain.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
        when(flightProvider.getFlights()).thenReturn(Arrays.asList(flight, flight));
        //when
        List<Flight> flights =  flightService.getFlights();
        //then
        assertThat(flights.size()).isEqualTo(2);
    }

    @Test
    void givenOrigin_whenGetOriginFlight_thenReturn1Flights() {
        //given
        Flight flight = Mockito.mock(Flight.class);
        Mockito.when(flight.getOrigin()).thenReturn("Amsterdam Schipol");
        when(flightProvider.getFlightByOrigin("Amsterdam Schipol")).thenReturn(Arrays.asList(flight));

        //when
        List<Flight> originFlights = flightService.getFlightByOrigin("Amsterdam Schipol");

        //then
        assertThat(originFlights.size()).isEqualTo(1);
        assertThat(originFlights.get(0).getOrigin()).isEqualTo("Amsterdam Schipol");
    }

    @Test
    void givenDestination_whenGetDestination_thenReturn1Flights() {
        //given
        Flight flight = Mockito.mock(Flight.class);
        Mockito.when(flight.getDestination()).thenReturn("Paris Charles de Gaule");
        when(flightProvider.getFlightByDestination("Paris Charles de Gaule")).thenReturn(Arrays.asList(flight));

        //when
        List<Flight> destinationFlights = flightService.getFlightByDestination("Paris Charles de Gaule");

        //then
        assertThat(destinationFlights.size()).isEqualTo(1);
        assertThat(destinationFlights.get(0).getDestination()).isEqualTo("Paris Charles de Gaule");
    }

}