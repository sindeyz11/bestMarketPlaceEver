"use client";

import { Carousel } from "@/components/layout/carousel";
import { Filter } from "@/components/layout/filter";
import { ProductCard } from "@/components/layout/product-card";
import { Select } from "@/components/ui/select";
import product from "@/store/product";
import { observer } from "mobx-react-lite";

import AuthService from "@/app/api/auth-service";
import authorizedUser from "@/store/authorizedUser";
import authorizedUserStore from "@/store/authorizedUser";
import { useRouter } from "next/navigation";

const HomePage = observer(() => {
  return (
    <div>
      <title>Главная</title>
      <Carousel banners={product.allProducts} />
      <div className="px-20 py-12">
        <div className="mb-6 flex items-center justify-between">
          <h3 className="text-2xl">Витрина магазина</h3>
          <span className="flex items-center gap-2 text-sm">
            Сортировать по:
            <div className="w-48">
              <Select
                options={["Популярности", "Цене", "Алфавиту"]}
                size="small"
              />
            </div>
          </span>
        </div>
        <div className="flex items-start gap-20">
          <Filter
            minPrice={123}
            maxPrice={6000}
            categories={[
              { name: "Все категории", count: 500 },
              { name: "Категория 1", count: 100 },
              { name: "Помидоры", count: 150 },
              { name: "Огурцы", count: 50 },
              { name: "Категория 4", count: 200 },
            ]}
          />
          <div
            className="base-xl:grid-cols-3 grid w-full grid-cols-2 gap-5 xl:grid-cols-4 2xl:grid-cols-5"
            id="products"
          >
            {product.allProducts.map((product) => (
              <ProductCard
                key={product.id}
                id={product.id}
                title={product.title}
                image={product.image || "./no-product.png"}
                price={product.price}
                discountPrice={product.discountPrice}
                unit={product.unit}
                availableQuantity={product.availableQuantity}
                description={product.description}
                category={product.category}
              />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
});
export default HomePage;
