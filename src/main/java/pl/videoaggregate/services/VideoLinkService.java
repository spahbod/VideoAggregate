package pl.videoaggregate.services;


import pl.videoaggregate.domain.VideoLink;

public interface VideoLinkService {
    Iterable<VideoLink> listAllProducts();

    VideoLink getProductById(Integer id);

    VideoLink saveProduct(VideoLink product);
}
