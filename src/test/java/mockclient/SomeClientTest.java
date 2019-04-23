package mockclient;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@MicronautTest
public class SomeClientTest {

    @Inject
    SomeClient someClient;

    @Test
    public void testClient() {
        assertNotNull(someClient);
    }

    // commenting out the MockClient class at the bottom of this source file
    // and uncomment the following method and its @MockBean annotation
    // causes the test to fail

//    @MockBean(SomeClient.class)
//    SomeClient someBean() {
//        return mock(SomeClient.class);
//    }

}

@Replaces(SomeClient.class)
class MockClient implements SomeClient {}
