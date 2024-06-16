package r2dbc_h2mem.service;

import r2dbc_h2mem.repository.UserRepository;
import r2dbc_h2mem.entities.Wetter;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void selectTest() throws Exception{

        System.out.println("selectTest()");
        Flux<Wetter> userFlux = userRepository.findAll();
        userFlux.subscribe(new Subscriber<Wetter>() {
            private Subscription s;
            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
                s.request(100);
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Wetter user)  {
                System.out.println("onNext");
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch ( InterruptedException e ){System.out.println(e.getMessage());}
                System.out.println(user.toString());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
        Thread.sleep(20000);
    }

}