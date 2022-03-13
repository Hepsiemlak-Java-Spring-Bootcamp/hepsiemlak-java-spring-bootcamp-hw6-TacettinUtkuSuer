package emlakburada.service;

import emlakburada.dto.request.AddressRequest;
import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.model.Address;
import emlakburada.model.Banner;
import emlakburada.repository.BannerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class BannerServiceTest {

    @InjectMocks
    private BannerService bannerService;

    @Mock
    private BannerRepository bannerRepository;
    
    @Test
    void getAllBannersTest(){
        
        //// @formatter:off
        Mockito
        .when(bannerRepository.findAllBanners() )
        .thenReturn( prepareBannerList() ) ;
        // @formatter:on

        List<BannerResponse> bannerResponseList = bannerService.getAllBanners();

        for (BannerResponse bannerResponse : bannerResponseList) {
            assertThat(bannerResponse.getAdvertNo()).isEqualTo(1);

            assertEquals(1, bannerResponse.getAdvertNo());
            assertEquals("555 444 33 22", bannerResponse.getPhone());
            assertEquals(10, bannerResponse.getTotal());
             }

    }

    private List<Banner> prepareBannerList(){
        List<Banner> banner = new ArrayList<>();
        banner.add(prepareBanner());
        banner.add(prepareBanner());
        banner.add(prepareBanner());
        return banner;
    }

    private Banner prepareBanner(){
        Address address = new Address("Ankara","Çankaya","Tunalı");
        Banner banner = new Banner(1,"555 444 33 22", 10, address);
        return banner;
    }

    @Test
    private void saveBannerTest(){

        Banner banner = prepareBanner();
        // BannerRequest bannerRequest = prepareBannerRequest();
        // @formatter:off
        Mockito
                .when(bannerRepository.saveBanner( any()) )
                .thenReturn( banner );
        // @formatter:on

        BannerResponse bannerResponse = bannerService.saveBanner(prepareBannerRequest());
        assertEquals(banner.getPhone(), bannerResponse.getPhone());

    }

    private BannerRequest prepareBannerRequest(){
        BannerRequest bannerRequest = new BannerRequest(1,"555 444 33 22", 10,new AddressRequest("Ankara","Çankaya","Tunalı"));
        return bannerRequest;
    }
}
