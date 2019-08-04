package pl.videoaggregate.services;


import pl.videoaggregate.domain.VideoLink;

import java.math.BigDecimal;
import java.util.List;

public interface VideoLinkService {
    List<VideoLink> listAllProducts();

    VideoLink getProductById(Long id);

    VideoLink saveProduct(VideoLink product);

    List<VideoLink> findByPrice(BigDecimal price);

    List<VideoLink> findByDescription(String description);
}
