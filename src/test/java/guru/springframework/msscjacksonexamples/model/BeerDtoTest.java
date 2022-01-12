package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }


    @Test
    void testDeserialize() throws IOException {
        String jsonString = "{\"id\":\"2d576d99-8e1e-4d05-b380-4001aa68d84d\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2022-01-12T12:15:17.8615154+01:00\",\"lastUpdatedDate\":\"2022-01-12T12:15:17.8625133+01:00\"}";
        BeerDto beerDto = objectMapper.readValue(jsonString,BeerDto.class);
        System.out.println(beerDto);
    }

}