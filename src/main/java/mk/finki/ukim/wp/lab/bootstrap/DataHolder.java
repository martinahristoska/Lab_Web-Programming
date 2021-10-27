package mk.finki.ukim.wp.lab.bootstrap;
import lombok.Data;
import lombok.Getter;
import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>(10);
    public static List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        balloonList.add(new Balloon("Red balloon","Red balloon Description"));
        balloonList.add(new Balloon("Green balloon","Green balloon Description"));
        balloonList.add(new Balloon("White balloon","White balloon Description"));
        balloonList.add(new Balloon("Yellow balloon","Yellow balloon Description"));

    }
}
