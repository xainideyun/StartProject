using HelloWebapi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace HelloWebapi.Controllers
{
    public class ProductController : ApiController
    {
        Product[] list = new Product[]
        {
            new Product() { Id = 1, Name = "奔驰", Category = "白色", Price = 459000 },
            new Product() { Id = 2, Name = "宝马", Category = "红色", Price = 339000 },
            new Product() { Id = 3, Name = "别克", Category = "蓝色", Price = 189922 },
        };
        public IEnumerable<Product> GetAllProduct()
        {
            return list;
        }
        public Product GetProductById(int id)
        {
            var product = list.FirstOrDefault(a => a.Id == id);
            if(product == null)
            {
                throw new HttpResponseException(HttpStatusCode.NotFound);
            }
            return product;
        }
        public IEnumerable<Product> GetProductsByCategory(string category)
        {
            return list.Where(a => string.Equals(a.Category,category, StringComparison.OrdinalIgnoreCase));
        }
    }
}
