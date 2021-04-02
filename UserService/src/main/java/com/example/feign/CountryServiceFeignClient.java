package com.example.feign;

import com.example.entity.Country;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.hystrix.FallbackFactory;
import feign.hystrix.HystrixFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "country-dao-service")
public interface CountryServiceFeignClient {

    class FeignHolder {

        private FeignHolder() {
        }

        public static CountryServiceFeignClient create() {
            return HystrixFeign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .target(CountryServiceFeignClient.class, "http://localhost:9006/",
                            (FallbackFactory<CountryServiceFeignClient>) throwable -> new CountryServiceFeignClient() {
                                @Override
                                public List<Country> getCountries() {
                                    return new ArrayList<>();
                                }

                                @Override
                                public Country getCountry(final long id) {
                                    return null;
                                }
                            });
        }
    }

    @RequestLine("GET /country")
    List<Country> getCountries();

    @RequestLine("GET /country/{id}")
    Country getCountry(@PathVariable long id);
}
