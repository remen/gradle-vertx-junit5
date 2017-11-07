package io.github.remen.techstacks;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTest {
    private Application application = new Application();

    @BeforeAll
    void beforeAll() {
        application.start();
    }

    @AfterAll
    void afterAll() {
        application.stop();
    }

    @Nested
    @DisplayName("GET /health")
    class get_health {
        @Test
        void responds_with_200() throws Exception {
            OkHttpClient httpClient = new OkHttpClient.Builder().build();

            Request request = new Request.Builder().url("http://localhost:" + application.getPort() + "/health").get().build();
            try(Response response = httpClient.newCall(request).execute()) {
                assertThat(response.code()).isEqualTo(200);
            }
        }
    }
}
