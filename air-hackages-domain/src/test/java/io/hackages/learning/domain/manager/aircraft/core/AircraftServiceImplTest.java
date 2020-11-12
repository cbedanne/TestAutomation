package io.hackages.learning.domain.manager.aircraft.core;

import io.hackages.learning.domain.exception.FunctionalException;
import io.hackages.learning.domain.exception.TechnicalException;
import io.hackages.learning.domain.manager.aircraft.spi.AircraftServiceProvider;
import io.hackages.learning.domain.model.Aircraft;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AircraftServiceImplTest {

    @Mock AircraftServiceProvider provider;

    @InjectMocks AircraftServiceImpl aircraftService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenNothing_whenGetAircrafts_thenSucceed() {
        //Given
        Aircraft aircraft = mock(Aircraft.class);
        when(provider.getAircrafts()).thenReturn(Arrays.asList(aircraft, aircraft, aircraft));
        //When
        List<Aircraft> aircrafts = aircraftService.getAircrafts();
        //Then
        assertThat(aircrafts.size()).isEqualTo(3);
    }

    @Test(expected = FunctionalException.class)
    public void givenNullCode_whenAddAircraft_thenThrowFunctionException() {
        //When
        aircraftService.addAircraft(new Aircraft(null,"Best Thing to do"));
    }

    @Test
    public void giveCode_whenDeleteAircraft_thenSucceed() throws Exception {
        //Give
        aircraftService.deleteAircraft("AH111");
        //Then
        verify(provider, times(1)).deleteAircraft("AH111");
    }

    @Test(expected = FunctionalException.class)
    public void giveCode_whenDeleteAircraft_thenThrowFunctionalError() throws Exception {
        //When
        Mockito.doThrow(FunctionalException.class).when(provider).deleteAircraft("007");
        //Give
        aircraftService.deleteAircraft("007");
    }

    @Test
    public void giveCode_whenDeleteAircraft_thenThrowTechnicalException() throws Exception {
        //When
        Mockito.doThrow(IOException.class).when(provider).deleteAircraft("0011");
        //Give
        try {
            aircraftService.deleteAircraft("0011");
        } catch (TechnicalException ex) {
            assertThat(ex.getMessage()).isEqualTo("Connection error with the database");
        }
    }

    @Test
    public void giveCode_whenGetAircraftByCode_thenWeSucceedToGetOneAircraft() {
        //When
        Aircraft aircraft = new Aircraft("AH007", "Airbus A360");
        Mockito.when(provider.fetchAircraftByCode("AH007")).thenReturn(aircraft);

        //Give
        Aircraft result = aircraftService.getAircraftByCode("AH007");

        // Then
        assertThat(result).isEqualTo(aircraft);
    }

    @Test
    public void giveNull_whenAircraftByCode_then_fail() {
        //When
        // This call will return a functional exception
        //Give
        try {
            Aircraft result = aircraftService.getAircraftByCode(null);
            // Then
        } catch (FunctionalException ex) {
            assertThat(ex.getMessage()).isEqualTo("Incorrect Entry Data");
        }
    }

}