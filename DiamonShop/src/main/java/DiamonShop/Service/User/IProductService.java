package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface IProductService {
	public ProductsDto GetProductByID(long id);
}
