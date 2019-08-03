package pl.videoaggregate.services;

import pl.videoaggregate.domain.VideoLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.videoaggregate.repositories.VideoLinkRepository;

@Service
public class VideoLinkServiceImpl implements VideoLinkService {

    @Autowired
    private VideoLinkRepository videoLinkRepository;

    @Override
    public Iterable<VideoLink> listAllProducts() {
        return videoLinkRepository.findAll();
    }

    @Override
    public VideoLink getProductById(Integer id) {
        return videoLinkRepository.findById(id).orElse(null);
    }

    @Override
    public VideoLink saveProduct(VideoLink product) {
        return videoLinkRepository.save(product);
    }
}
