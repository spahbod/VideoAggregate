package pl.videoaggregate.services;

import lombok.AllArgsConstructor;
import pl.videoaggregate.domain.VideoLink;
import org.springframework.stereotype.Service;
import pl.videoaggregate.repositories.VideoLinkRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoLinkServiceImpl implements VideoLinkService {

    private VideoLinkRepository videoLinkRepository;

    @Override
    public List<VideoLink> listAllProducts() {
        return videoLinkRepository.findAll();
    }

    @Override
    public VideoLink getProductById(Long id) {
        return videoLinkRepository.findById(id).orElse(null);
    }

    @Override
    public VideoLink saveProduct(VideoLink product) {
        return videoLinkRepository.save(product);
    }

    @Override
    public List<VideoLink> findByPrice(BigDecimal price) {
        return videoLinkRepository.findByPrice(price);
    }

    @Override
    public List<VideoLink> findByDescription(String description) {
        return videoLinkRepository.findByDescription(description);
    }
}
