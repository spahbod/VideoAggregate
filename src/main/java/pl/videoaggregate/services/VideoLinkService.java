package pl.videoaggregate.services;


import pl.videoaggregate.domain.VideoLink;

public interface VideoLinkService {
    Iterable<VideoLink> listAllProducts();

    VideoLink getProductById(Long id);

    VideoLink saveProduct(VideoLink product);
}
