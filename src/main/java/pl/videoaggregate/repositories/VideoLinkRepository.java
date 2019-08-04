package pl.videoaggregate.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.videoaggregate.domain.VideoLink;

import java.math.BigDecimal;
import java.util.List;

public interface VideoLinkRepository extends CrudRepository<VideoLink, Long>{
    List<VideoLink> findByPrice(BigDecimal price);

    List<VideoLink> findByDescription(String description);

    List<VideoLink> findAll();
}