package pl.videoaggregate.bootstrap;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.videoaggregate.domain.VideoLink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.videoaggregate.repositories.VideoLinkRepository;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Slf4j
public class VideoLinkLoader implements ApplicationListener<ContextRefreshedEvent> {

    private VideoLinkRepository videoLinkRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        VideoLink shirt = new VideoLink();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        videoLinkRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        VideoLink mug = new VideoLink();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        videoLinkRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
