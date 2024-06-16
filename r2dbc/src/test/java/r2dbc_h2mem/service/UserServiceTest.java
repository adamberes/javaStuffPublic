package r2dbc_h2mem.service;

import r2dbc_h2mem.entities.Users;
import r2dbc_h2mem.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

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
        Flux<Users> userFlux = userRepository.findAll();
        userFlux.subscribe(new Subscriber<Users>() {
            private Subscription s;
            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
                s.request(100);
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Users user)  {
                System.out.println("onNext");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
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
                System.exit(0);
            }
        });
        Thread.sleep(20000);
    }

}