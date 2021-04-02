package com.example.feign;

import com.example.team.entity.Language;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.hystrix.FallbackFactory;
import feign.hystrix.HystrixFeign;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "team-service-repository")
public interface LanguageServiceFeignClient {

    class FeignHolder {

        private FeignHolder() {
        }

        public static LanguageServiceFeignClient create() {
            return HystrixFeign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .target(LanguageServiceFeignClient.class, "http://localhost:9004/",
                            (FallbackFactory<LanguageServiceFeignClient>) throwable ->
                                    (LanguageServiceFeignClient) () -> null);
        }
    }

    @RequestLine("GET /language")
    List<Language> getAllTeams();
}
