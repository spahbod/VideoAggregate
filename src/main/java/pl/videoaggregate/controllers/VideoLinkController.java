package pl.videoaggregate.controllers;

import lombok.AllArgsConstructor;
import pl.videoaggregate.domain.VideoLink;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.videoaggregate.services.VideoLinkService;

@Controller
@AllArgsConstructor
public class VideoLinkController {

    private VideoLinkService videoLinkService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", videoLinkService.listAllProducts());
        System.out.println("Returning products:");
        return "products";
    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", videoLinkService.getProductById(id));
        return "productshow";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", videoLinkService.getProductById(id));
        return "productform";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new VideoLink());
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(VideoLink product) {

        videoLinkService.saveProduct(product);

        return "redirect:/product/" + product.getId();
    }
}
