package io.hackages.learning.domain.manager.flight.core;

import io.hackages.learning.domain.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.domain.model.Aircraft;
import io.hackages.learning.domain.model.Flight;
import io.hackages.learning.domain.model.FlightType;
import io.hackages.learning.domain.model.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class FlightServiceImplTest {

    @Mock FlightServiceProvider flightProvider;

    @InjectMocks FlightServiceImpl flightService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenNoParameters_whenGetFlight_thenSucceed() {
        //given
        Aircraft aircraft = new Aircraft("AH123", "Airbus A380");
        Flight flight = new Flight(
                FlightType.MH.getType(),
                Location.CDG.getAirport(),
                Location.AMS.getAirport(),
                LocalDateTime.now().plusHours(1).toString(),
                LocalDateTime.now().plusHours(2).toString(),
                aircraft);
        when(flightProvider.getFlights()).thenReturn(Arrays.asList(flight, flight));
        //when
        List<Flight> flights =  flightService.getFlights();
        //then
        assertThat(flights.size()).isEqualTo(2);
        assertThat(flights.get(1).getAircraft()).isEqualTo(aircraft);
    }

    @Test
    public void givenOrigin_whenGetOriginFlight_thenReturn1Flights() {
        //given
        Flight flight = mock(Flight.class);
        when(flight.getOrigin()).thenReturn("Amsterdam Schiphol");
        when(flightProvider.getFlightByOrigin("Amsterdam Schiphol")).thenReturn(Arrays.asList(flight));

        //when
        List<Flight> originFlights = flightService.getFlightByOrigin("Amsterdam Schiphol");

        //then
        assertThat(originFlights.size()).isEqualTo(1);
        assertThat(originFlights.get(0).getOrigin()).isEqualTo("Amsterdam Schiphol");
    }

    @Test
    public void givenDestination_whenGetDestination_thenReturn1Flights() {
        //given
        Flight flight = mock(Flight.class);
        when(flight.getDestination()).thenReturn("Paris Charles de Gaulle");
        when(flightProvider.getFlightByDestination("Paris Charles de Gaulle")).thenReturn(Arrays.asList(flight));

        //when
        List<Flight> destinationFlights = flightService.getFlightByDestination("Paris Charles de Gaulle");

        //then
        assertThat(destinationFlights.size()).isEqualTo(1);
        assertThat(destinationFlights.get(0).getDestination()).isEqualTo("Paris Charles de Gaulle");
    }

    @Test
    public void givenNull_whenGetFlightsByParameters_thenReturnAllTheFlights() {
        //given
        Flight flight = mock(Flight.class);
        when(flight.getOrigin()).thenReturn("Paris Charles de Gaulle");
        when(flightProvider.getFlights()).thenReturn(Arrays.asList(flight, flight, flight));

        //when
        List<Flight> flights = flightService.getFilteredFlights(null);

        //then
        assertThat(flights.size()).isEqualTo(3);
        assertThat(flights.get(0).getOrigin()).isEqualTo("Paris Charles de Gaulle");
    }

    @Test
    public void giveOriginFilterParameters_whenGetFilteredFlights_thenReturn1Flight() {
        //given
        Flight flight = mock(Flight.class);
        when(flight.getOrigin()).thenReturn("Paris Charles de Gaulle").thenReturn("Amsterdam Schiphol");
        when(flightProvider.getFlights()).thenReturn(Arrays.asList(flight, flight, flight));
        Map<String, String> parameters = new HashMap<>();
        parameters.put("origin", "Paris Charles de Gaulle");

        //when
        List<Flight> flights = flightService.getFilteredFlights(parameters);

        //then
        assertThat(flights.size()).isEqualTo(1);
    }

    @Test
    public void giveEmptyFilterParameters_whenGetFilteredFlights_thenSucceed() {
        //given
        Flight flight = mock(Flight.class);
        when(flight.getOrigin()).thenReturn("Paris Charles de Gaulle").thenReturn("Amsterdam Schiphol");
        when(flightProvider.getFlights()).thenReturn(Arrays.asList(flight, flight, flight));
        Map<String, String> parameters = new HashMap<>();

        //when
        List<Flight> flights = flightService.getFilteredFlights(parameters);

        //then
        assertThat(flights.size()).isEqualTo(3);
    }

}