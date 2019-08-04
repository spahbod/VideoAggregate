package pl.videoaggregate.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.videoaggregate.domain.VideoLink;

public interface VideoLinkRepository extends CrudRepository<VideoLink, Long>{
}
